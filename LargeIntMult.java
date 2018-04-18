/*
https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
*/
class LargeIntMult {
    public String multiply(String num1, String num2) {
        int[] output = new int[num1.length()+num2.length()];
        Arrays.fill(output, 0);
        
        for(int j=num2.length()-1; j>=0; j--) {
            for(int i=num1.length()-1; i>=0; i--) {
                int multValue = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum = multValue + output[i+j+1];
                output[i+j+1] = sum%10;
                output[i+j] += sum/10;
            }
        }

        StringBuilder o = new StringBuilder();
        
        for(int v : output) {
            if (v == 0 && o.length() == 0)
                continue;
            
            o.append(v);
        }
        
        if (o.length()==0)
            return "0";
        
        return o.toString();
    }
}