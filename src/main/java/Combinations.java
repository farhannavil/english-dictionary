import java.util.HashSet;
import java.util.Set;

public class Combinations {
    public static Set<String> allPossibleCombinations = new HashSet<>();
    private final StringBuilder output = new StringBuilder();
    private final String inputString;

    public Combinations(final String str) {
        inputString = str;
        System.out.println("The input string  is  : " + inputString);
    }

    public static Set<String> getAllPossibleCombinations(String input) {
        Combinations combObj = new Combinations(input);
        combObj.combine();

        return allPossibleCombinations;
    }

    public void combine() {
        combine(0);
    }

    private void combine(int start) {
        for (int i = start; i < inputString.length(); ++i) {
            output.append(inputString.charAt(i));
            combine(i + 1);
            output.setLength(output.length() - 1);
            allPossibleCombinations.add(output.toString());
            allPossibleCombinations.remove("");
        }
    }
}