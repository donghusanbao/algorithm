package questions;

public class Code0109_StringRotate {
    public boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        String dupS1 = s1 + s1;
        return dupS1.contains(s2);
    }
}
