import java.util.HashMap;
import java.util.Map;

/**

 Given string say ABCGRETCABCG and substring length let us take length as 3,
 find the count of possible substrings, for example in above string ABC => 2 and BCG => 2,
 where CGR and other 3 word length substrings has a count of 1.

 */
public class CountSubstrings {

    public static void main(String[] args) {
        String str = "ABCGRETCABCG";
        int sub = 3;
        Map<String,Integer> map = countSubstrings(str,sub);
        for(Map.Entry<String,Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    }

    private static Map<String,Integer> countSubstrings(String str, int sub) {
        if(str == null || str.length() == 0 || sub <= 0) return null;

        char[] strChar = str.toCharArray();

        Map<String,Integer> map = new HashMap<>();

        for(int i = 0; i < strChar.length; i++) {
            if(i + sub < str.length()) {
                if (map.containsKey(str.substring(i, i + sub))) {
                    int val = map.get(str.substring(i, i + sub));
                    map.put(str.substring(i, i + sub), ++val);
                } else {
                    map.put(str.substring(i, i + sub), 1);
                }
            } else {
                if (map.containsKey(str.substring(i))) {
                    int val = map.get(str.substring(i));
                    map.put(str.substring(i), ++val);
                } else {
                    map.put(str.substring(i), 1);
                }
                break;
            }
        }



        return map;
    }

}
