package com.lectricas.linear;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

 class GaussElimination {
    public static void main(String[] args) throws FileNotFoundException {
        GaussElimination el = new GaussElimination();
        el.run();
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));
//        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        double[][] matrix = new double[N][M + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = s.nextInt();
            }
        }

        for (int p = 0; p < matrix.length; p++) {
            //find pivot
            int max = p;
            for (int i = p; i < matrix.length; i++) {
                if (matrix[i][p] > matrix[p][p]) {
                    max = i;
                }
            }
            double[] temp = matrix[p];
            matrix[p] = matrix[max];
            matrix[max] = temp;

            for (int i = p + 1; i < matrix.length; i++) {
                double alpha = matrix[i][p] / matrix[p][p];
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] -= alpha * matrix[p][j];
                }
            }
        }

        int check = checkMatrix(matrix);

        if (check == -1) {
            System.out.println("NO");
        } else if (check == 0) {
            System.out.println("INF");
        } else {
            System.out.println("YES");
            double[] answers = new double[N];

            for (int i = answers.length - 1; i >= 0 ; i--) {
                double sum = 0;
                for (int j = i + 1; j < answers.length; j++) {
                    sum += matrix[i][j] * answers[j];
                }
                answers[i] = (matrix[i][N] - sum) / matrix[i][i];
            }

            for (int i = 0; i < answers.length; i++) {

                System.out.print(answers[i] + " ");
            }
        }
    }

    private int checkMatrix(double[][] matrix) {
        for (int i = matrix.length - 1; i >= 0; i--) {
            double b = matrix[i][matrix[i].length - 1];
            int j = matrix[i].length - 2;
            int nonZero = 0;
            while (j >= 0) {
                if (matrix[i][j] != 0) {
                    nonZero++;
                }
                j--;
            }

            if (nonZero == 0 && b != 0.0) {
                return -1;
            }
            if (nonZero > matrix.length - i) {
                return 0;
            }
        }
        return 1;
    }
}
