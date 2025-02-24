import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class AnagramSolver {

    private AnagramSolver() {};

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     * @param filename
     * @return
     */
    public static HashMap<String, ArrayList<String>> anagrams(String filename) throws FileNotFoundException {
        HashMap<String,ArrayList<String>> result = new HashMap<>();
        Scanner scanner = new Scanner(new File(filename));
        while(scanner.hasNextLine()){
            String word = scanner.nextLine().trim();
            List<Character> charList = new ArrayList<>();
            for(int i =0;i<word.length();i++){
                charList.add(word.charAt(i));
            }
            Collections.sort(charList);
            StringBuilder sortedWord = new StringBuilder();
            for(Character c: charList){
                sortedWord.append(c);
            }
            String sortedFinal = sortedWord.toString();
            ArrayList<String> anagramsList = result.get(sortedFinal);
            if(anagramsList == null){
                anagramsList = new ArrayList<>();
                result.put(sortedFinal, anagramsList);
            }
            anagramsList.add(word);
        }
        scanner.close();
        return result;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        ArrayList<String> mostFrequent = new ArrayList<>();
        int maxCount = 0;
        for(ArrayList<String> anagramList : anagrams.values()){
            int currentCount = anagramList.size();
            if(currentCount>maxCount){
                maxCount = currentCount;
                mostFrequent = anagramList;
            }
        }
        return mostFrequent;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: prints all key value pairs in the hashmap.
     * @param anagrams
     */
    public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
        System.out.println(anagrams);
    }

}
