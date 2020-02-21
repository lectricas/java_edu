package com.lectricas.stepik_algs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RecursiveComplexity {

    public static void main(String[] args) {
        RecursiveComplexity r = new RecursiveComplexity();


        r.run();


    }

    private void run() {
        List<Equation> equations = new ArrayList<>();
        equations.add(new Equation(9, 3, 2, "1"));
        equations.add(new Equation(5, 4, 1, "2"));
        equations.add(new Equation(6, 4, 3, "3"));
        equations.add(new Equation(5, 2, 1, "4"));
        equations.add(new Equation(2, 2, 1, "5"));
        equations.add(new Equation(1, 2, 0, "6"));
        equations.add(new Equation(5, 4, 2, "7"));
        equations.add(new Equation(3, 2, 1, "8"));
        equations.add(new Equation(2, 3, 0, "9"));

        for (Equation equation : equations) {
            double complexity = getComplexity(10000000, equation.a, equation.b, equation.d);
            equation.complexity = complexity;
        }

        equations.sort(Comparator.comparingDouble(o -> o.complexity));

        for (Equation equation : equations) {
            System.out.println(equation.name);
        }
    }

    private double getComplexity(int n, int a, int b, int d) {
        if (d > customLog(b, a)) {
            return Math.pow(n, d);
        } else if (d < customLog(b, a)) {
            return Math.pow(n, customLog(b,a));
        } else {
            return Math.pow(n, d) * customLog(5, n);
        }
    }

    private double customLog(int base, int number) {
        return Math.log(number) / Math.log(base);
    }

    class Equation {
        int a;
        int b;
        int d;
        String name;
        double complexity;

        public Equation(int a, int b, int d, String name) {
            this.a = a;
            this.b = b;
            this.d = d;
            this.name = name;
        }
    }
 }
