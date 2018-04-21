class OneEditDistance {
    public static boolean isOneEdit(String s, String t) {
        if (s.length() > t.length())
            return isOneEdit(t, s);

        if (t.length() - s.length() > 1)
            return false;

        int distance = 0;
        int i=0, j=0;
        while (i<s.length() && j<t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                distance++;

                if (distance > 1)
                    return false;

                if (s.length() == t.length()) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
        }

        if (i < s.length() || j < t.length())
            distance++;

        return distance == 1;
    }

    public static void main(String args[]) {
        System.out.println(isOneEdit("hello","hello"));
        System.out.println(isOneEdit("hello","hemlo"));
        System.out.println(isOneEdit("hello","hellm"));
        System.out.println(isOneEdit("cat","caut"));
        System.out.println(isOneEdit("caut","cat"));
        System.out.println(isOneEdit("cat","dcat"));
        System.out.println(isOneEdit("dcat","cat"));
        System.out.println(isOneEdit("cat","cati"));
        System.out.println(isOneEdit("cat","catss"));
    }
}