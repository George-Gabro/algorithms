import java.util.ArrayList;
import java.util.List;

public class PatternSearch {

    public static List<Integer> searchPattern(String text, String pattern) {
        int[] PatternArray = patternArray(pattern);

        int t = 0; // index text
        int p = 0; // index pattern

        List<Integer> result = new ArrayList<>();

        while (t < text.length()) {
            if (pattern.charAt(p) == text.charAt(t)) {
                p++;
                t++;
            }
            if (p == pattern.length()) {
                result.add(t - p);
                p = PatternArray[p - 1];
            }
            else if (t < text.length() && pattern.charAt(p) != text.charAt(t)) {
                if (p != 0)
                    p = PatternArray[p - 1];
                else
                    t = t + 1;
            }
        }

        return result;
    }

    public static int[] patternArray(String pattern) {
        int length = 0;
        int patternLength = pattern.length();
        int i = 1;
        int[] patternArray = new int[patternLength];
        patternArray[0] = 0;

        while (i < patternLength) {
            if(pattern.charAt(i) != pattern.charAt(length)){
                if (length == 0) {
                    patternArray[i] = length;
                    i++;
                } else length = patternArray[length - 1];
            } else {
                length++;
                patternArray[i] = length;
                i++;
            }
        }

        return patternArray;
    }

}
