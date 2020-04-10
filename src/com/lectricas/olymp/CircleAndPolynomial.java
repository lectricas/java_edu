package com.lectricas.olymp;

import java.io.FileNotFoundException;
import java.util.Scanner;

class CircleAndPolynomial {
    public static void main(String[] args) throws FileNotFoundException {
        CircleAndPolynomial c = new CircleAndPolynomial();
        c.run();
    }

    private void run() throws FileNotFoundException {
//        Scanner s = new Scanner(new File("input.txt"));
        Scanner s = new Scanner(System.in);
        int circleX = s.nextInt();
        int circleY = s.nextInt();
        int circleR = s.nextInt();
        int n = s.nextInt();
        int[] coef = new int[n + 1];
        for (int i = 0; i < coef.length; i++) {
            coef[i] = s.nextInt();
        }
        double rightX = s.nextDouble();
        double rightY = sample(coef, rightX);
        double leftX = rightX;
        double leftY = rightY;

        while (distanceToCenter(circleX, circleY, leftX, leftY) < circleR) {
            leftX = leftX * 2;
            leftY = sample(coef, leftX);
        }

        boolean rightInCenter = true;
        if (leftX >  rightX) {
            rightInCenter = false;
            double t1 = rightX;
            rightX = leftX;
            leftX = t1;
        }

        System.out.println(leftX);
        System.out.println(rightX);

        for (int i = 0; i < 100; i++) {
            double x = (leftX + rightX) / 2;
            double y = sample(coef, x);
            if (distanceToCenter(circleX, circleY, x, y) < circleR) {
                if (rightInCenter) {
                    rightX = x;
                } else {
                    leftX = x;
                }
            } else {
                if (rightInCenter) {
                    leftX = x;
                } else {
                    rightX = x;
                }
            }
        }

        System.out.println(leftX);
    }

    private double distanceToCenter(int circleX, int circleY, double x, double y) {
        double under = Math.pow(x - circleX, 2) + Math.pow(y - circleY, 2);
        return Math.sqrt(under);
    }

    private Double sample(int[] couef, double value) {
        double answer = couef[0];
        for (int i = 1; i < couef.length; i++) {
            answer = value * answer + couef[i];
        }
        return answer;
    }
}
