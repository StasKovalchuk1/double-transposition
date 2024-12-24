import java.util.*;

public class DoubleTransposition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        sc.close();

        List<String> firstStepResults = getAllTranspositionResults(text);

        Set<String> uniqueSecondStep = new LinkedHashSet<>();

        for (String intermediate : firstStepResults) {
            List<String> secondStepResults = getAllTranspositionResults(intermediate);
            uniqueSecondStep.addAll(secondStepResults);
        }

        for (String finalResult : uniqueSecondStep) {
            System.out.println(finalResult);
            System.out.println();
        }
    }

    private static List<String> getAllTranspositionResults(String text) {
        List<String> results = new ArrayList<>();
        int length = text.length();

        for (int rows = 1; rows <= length; rows++) {
            if (length % rows == 0) {
                int cols = length / rows;

                char[][] table = new char[rows][cols];
                int index = 0;
                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < cols; c++) {
                        table[r][c] = text.charAt(index++);
                    }
                }

                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < cols; c++) {
                    for (int r = 0; r < rows; r++) {
                        sb.append(table[r][c]);
                    }
                }
                results.add(sb.toString());
            }
        }
        return results;
    }
}
