/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz".

Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same
shifting sequence.
*/
import java.util.*;

class GroupShifted {
    public static List<List<String>> groupShifted(String[] input) {
        List<List<String>> output = new ArrayList<>();

        Map<String, List<String>> m = new HashMap<>();

        for(String s : input) {
            String transWord = getEndState(s);

            if(!m.containsKey(transWord)) {
                m.put(transWord, new ArrayList<String>());
            }

            m.get(transWord).add(s);
        }

        output.addAll(m.values());
        return output;
    }

    private static String getEndState(String s) {
        char[] ip = s.toCharArray();
        int diff = 'z'-ip[0];

        for(int i=0; i<ip.length; i++) {
            int current = ip[i]-'a';
            current = (current+diff)%26;
            ip[i] = (char)('a'+current);
        }

        return String.valueOf(ip);
    }

    public static void main(String args[]) {
        List<List<String>> res = groupShifted(new String[] {"glu","az","a","z","acef","rwf","bcd","ba"});

        for(List<String> g : res){
            System.out.println(g.toString());
        }
    }
}