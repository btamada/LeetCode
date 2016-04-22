import java.util.*;

/**
 * Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo","bar"));
    }

    /**
     *  Algorithm Design
     *
     *  Create a hashmap for string s
     *  Create a hashmap for string t
     *
     *  Iterate through the chars of string s and count # of occurrences
     *  Iterate through the chars of string t and count # of occurrences
     *
     *  Iterate though keys of hm1 and compare to keys of hm2
     *
     */
    static boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return false;
        LinkedHashMap<Character, Integer> hm1 = new LinkedHashMap<>();
        LinkedHashMap<Character, Integer> hm2 = new LinkedHashMap<>();
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        // counting number of chars in string s
        for(Character c : sCharArr) {
            if(hm1.containsKey(c)) {
                int val = hm1.get(c);
                hm1.put(c, ++val);
            } else {
                hm1.put(c,1);
            }
        }

        // counting number of chars in string t
        for(Character c : tCharArr) {
            if(hm2.containsKey(c)) {
                int val = hm2.get(c);
                hm2.put(c, ++val);
            } else {
                hm2.put(c,1);
            }
        }

        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

        for(Character c : hm1.keySet()) {
            //System.out.print(c + " ");
            l1.add(hm1.get(c));
        }

        for(Character c : hm2.keySet()) {
            //System.out.print(c + " ");
            l2.add(hm2.get(c));
        }

        for(int i = 0; i < l1.size(); i++) {
            if(l1.get(i) != l2.get(i)) return false;
        }

        return true;
    }

}
