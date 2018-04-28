/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 */
class LargestSubstringWithUniqueChars {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();
        
        Set<Character> seen = new HashSet<>();
        int start=0, end=0;
        int maxLen = 0;
        
        while(end < s.length()) {
            if (seen.add(s.charAt(end))) {
                if (end-start+1 > maxLen) {
                    maxLen = end-start+1;
                }
            }
            else {
                while(s.charAt(start) != s.charAt(end)) {
                    seen.remove(s.charAt(start));
                    start++;
                }
                
                start++;
            }
            
            end++;
        }
        
        return maxLen;
    }
}