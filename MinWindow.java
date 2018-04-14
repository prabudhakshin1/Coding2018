import java.util.Map;
import java.util.HashMap;

// Minimum window containing all given works with their frequency
class MinWindow {

    public static void minWindow(String[] input, String[] words, int[] frequency) {
        // build freq map
        Map<String, Integer> m = new HashMap<>();
        int requiredCount = 0;

        for(int i=0; i<words.length; i++) {
            m.put(words[i], frequency[i]);
            requiredCount+=frequency[i];
        }

        int start = 0;
        int end = 0;
        int minWindow = Integer.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;

        while(end < input.length) {
            if(getCurrentAndDecrease(m, input[end++]) > 0)
                requiredCount--;
            
            while(requiredCount == 0) {
                if (end-start < minWindow) {
                    minWindow = end-start;
                    minStart = start;
                    minEnd = end-1;
                }

                if(getCurrentAndIncrease(m, input[start++]) == 0) {
                    requiredCount++;
                }
            }
        }

        System.out.println(minStart + " --- " + minEnd);
    }

    public static int getCurrentAndIncrease(Map<String, Integer> m, String word) {
        int current = -1;

        if (m.containsKey(word)) {
            current = m.get(word);
            m.put(word, current+1);
        }

        return current;
    }
    
    public static  int getCurrentAndDecrease(Map<String, Integer> m, String word) {
        int current = -1;

        if (m.containsKey(word)) {
            current = m.get(word);
            m.put(word, current-1);
        }

        return current;
    }

    public static void main(String args[]) {        
        String[] input = {"quick", "brown", "cat", "rat", "bee", "fly", "fox", "fox", "fox", "jumped", 
            "over", "over", "bush", "bush", "a", "b", "c", "d", "brown", "insect", "over", "bush"};
        String[] words = {"brown", "fox", "jumped", "over", "bush"};
        int[] freq = {1,3,1,2,1};
        minWindow(input, words, freq);
    }
}