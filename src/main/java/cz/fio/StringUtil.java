package cz.fio;

public class StringUtil {

    /**
     * Trim string of whitespaces and return Null if only empty string remains.
     * @param s
     * @return Trimmed string or Null if string was empty or white spaces.
     */
    static String trimToNull(String s) {
        if (s == null) {
            return null;
        } else {
            s = s.trim();
            if (s.length() == 0) {
                return null;
            } else {
                return s;
            }
        }
    }
}
