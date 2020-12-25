package recognition;

import java.util.Scanner;

class DigitAnalyzer {

    int[][] inputLayer = new int[3][3];
    final int[][] weights = {{2, 1, 2}, {4, -4, 4}, {2, -1, 2}};
    final int bias = -5;

    public void analyzeDigit() {
        System.out.println("Input grid:");
        getInputGrid();
        System.out.println("This number is " + determineOutput());
    }

    private void getInputGrid() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            String cell = scanner.nextLine();
            for (int j = 0; j < 3; j++) {
                inputLayer[i][j] = (cell.charAt(j) == 'X') ? 1 : 0;
            }
        }
    }

    private int determineOutput() {
        int weightedSum = -5;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                weightedSum += inputLayer[i][j] * weights[i][j];
            }
        }

        return (weightedSum < 0) ? 1 : 0;
    }
}