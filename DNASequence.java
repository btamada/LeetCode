import java.util.HashMap;
import java.util.Map;

/**
 * Created by User1 on 7/22/16.
 */
public class DNASequence {

    final static String DNA_SEQUENCE = "ACGT";

    public static void main(String[] args) {
        System.out.println(dnaSequence("AACT"));
    }

    private static String dnaSequence(String s) {
        if(s == null || s.length() == 0) throw new IllegalArgumentException("invalid input");
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i) {
            if(map.containsKey(s.charAt(i))) {
                int val = map.get(s.charAt(i));
                map.put(s.charAt(i), ++val);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for(int i = 0; i < DNA_SEQUENCE.length(); ++i) {
            if(map.containsKey(DNA_SEQUENCE.charAt(i)))
                sb.append(map.get(DNA_SEQUENCE.charAt(i)) + ",");
            else
                sb.append("0,");
        }
        return sb.toString();
    }

}
