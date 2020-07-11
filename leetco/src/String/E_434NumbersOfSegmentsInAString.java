package String;

public class E_434NumbersOfSegmentsInAString {
    //solution1 use trim O(n)
    public int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
}
