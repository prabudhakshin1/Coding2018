import java.util.*;

class FactorCombinations {
    private static List<List<Integer>> getCombinations(int n) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> temp = new ArrayList<Integer>();
        helper(2 /*start*/, n /*required*/, temp, output);
        return output;
    }

    private static void helper(int startingFactor, int required, List<Integer> temp,
                               List<List<Integer>> output) {
        if (required == 1) {
            if( temp.size()>1)
                output.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int factor = startingFactor; factor <= required; factor++) {
            if (required % factor != 0)
                continue;

            temp.add(factor);
            helper(factor, required/factor, temp, output);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String args[]) {
        List<List<Integer>> output = getCombinations(54);
        for(List<Integer> f : output)
            System.out.println(f.toString());
    }
}