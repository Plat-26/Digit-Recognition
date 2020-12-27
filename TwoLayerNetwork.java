package recognition;

import java.util.Scanner;

class TwoLayerNetwork {

    //predefined weights for numbers 0 - 9 on a 5 x 3 grid
    int[][][] weights = new int[][][] {
            {{1, 1, 1}, {1, -1, 1}, {1, -1, 1}, {1, -1, 1}, {1, 1, 1}},
            {{-1, 1, -1}, {-1, 1, -1}, {-1, 1, -1}, {-1, 1, -1}, {-1, 1, -1}},
            {{1, 1, 1}, {-1, -1, 1}, {1, 1, 1}, {1, -1, -1}, {1, 1, 1}},
            {{1, 1, 1}, {-1, -1, 1}, {1, 1, 1}, {-1, -1, 1}, {1, 1, 1}},
            {{1, -1, 1}, {1, -1, 1}, {1, 1, 1}, {-1, -1, 1}, {-1, -1, 1}},
            {{1, 1, 1}, {1, -1, -1}, {1, 1, 1}, {-1, -1, 1}, {1, 1, 1}},
            {{1, 1, 1}, {1, -1, -1}, {1, 1, 1}, {1, -1, 1}, {1, 1, 1} },
            {{1, 1, 1}, {-1, -1, 1}, {-1, -1, 1}, {-1, -1, 1}, {-1, -1, 1}},
            {{1, 1, 1}, {1, -1, 1}, {1, 1, 1}, {1, -1, 1}, {1, 1, 1}},
            {{1, 1, 1}, {1, -1, 1}, {1, 1, 1}, {-1, -1, 1}, {1, 1, 1}},

    };
    int[] bias = new int[] {-1, 6, 1, 0, 2, 0, -1, 3, -2, -1};
    int[] outputNeurons = new int[10];
    int[][] inputNeurons = new int[5][3];

    public void analyzeDigit() {
        System.out.println("Input grid:");
        getInputGrid();
        System.out.println("This number is " + activateOutputNeurons());
    }

    private void getInputGrid() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            String cell = scanner.nextLine();
            for (int j = 0; j < 3; j++) {
                inputNeurons[i][j] = (cell.charAt(j) == 'X') ? 1 : 0;
            }
        }
    }

    private int activateOutputNeurons() {
        int max = Integer.MIN_VALUE;
        int number = -1;

        for (int k = 0; k < 10; k++) {
            int weightedSum = bias[k];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 3; j++) {
                    weightedSum += inputNeurons[i][j] * weights[k][i][j];
                }
            }
            outputNeurons[k] = weightedSum;

            if (max < weightedSum) {
                max = weightedSum;
                number = k;
            }
        }
        return number;
    }

}
