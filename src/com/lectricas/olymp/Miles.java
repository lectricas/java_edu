package com.lectricas.olymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Miles {

    Map<String, Integer> milesHashMap = getMilesHash();
    Map<Integer, String> kmHashMap = getKmHash();

    int from = 0;
    int size = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Miles m = new Miles();
        m.run();
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        String[] input = s.nextLine().split(" ");
        int a = convertToKmNumber(input);
        String km = convertToKmString(a);
        String ending = getEnding(a);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < from; i++) {
            builder.append(input[i] + " ");
        }
        builder.append(km);
        builder.append(" ");
        builder.append(ending);
        if (from + size + 1 == input.length) {
            builder.append(".");
        } else {
            for (int i = from + size + 1; i < input.length; i++) {
                builder.append(" " + input[i]);
            }
        }
        System.out.println(builder.toString());
    }

    private String convertToKmString(int kmOut) {
        int km = kmOut;
        StringBuilder builder = new StringBuilder();
        int mod = 10;
        while (mod <= 1000) {
            int digit = km % mod;
            km = km - digit;
            mod = mod * 10;
            if (digit != 0) {
                builder.insert(0, kmHashMap.get(digit));
                builder.insert(0, " ");
            }
        }
        return builder.toString().substring(1);
    }

    private int convertToKmNumber(String[] numParts) {
        int total = 0;
        for (int i = 0; i < numParts.length; i++) {
            if (milesHashMap.containsKey(numParts[i])) {
                if (from == 0) {
                    from = i;
                }
                size++;
                total += milesHashMap.get(numParts[i]);
            }
        }
        return (int) Math.round(total * 1.60934);
    }

    private String getEnding(int num) {
        if (num % 10 == 1) {
            return "километр";
        } else if (num % 10 > 1 && num % 10 < 5) {
            return "километра";
        } else {
            return "километров";
        }
    }

    private static Map<Integer, String> getKmHash() {
        String miles = "100 сто  \n" +
                "200 двести  \n" +
                "300 триста  \n" +
                "400 четыреста  \n" +
                "500 пятьсот  \n" +
                "600 шестьсот  \n" +
                "700 семьсот  \n" +
                "800 восемьсот  \n" +
                "900 девятьсот  \n" +
                "10 десять  \n" +
                "11 одиннадцать  \n" +
                "12 двенадцать  \n" +
                "13 тринадцать  \n" +
                "14 четырнадцать  \n" +
                "15 пятнадцать  \n" +
                "16 шестнадцать  \n" +
                "17 семнадцать  \n" +
                "18 восемнадцать  \n" +
                "19 девятнадцать  \n" +
                "20 двадцать  \n" +
                "30 тридцать  \n" +
                "40 сорок  \n" +
                "50 пятьдесят  \n" +
                "60 шестьдесят  \n" +
                "70 семьдесят  \n" +
                "80 восемьдесят  \n" +
                "90 девяносто  \n" +
                "1 один  \n" +
                "2 два  \n" +
                "3 три  \n" +
                "4 четыре  \n" +
                "5 пять  \n" +
                "6 шесть  \n" +
                "7 семь  \n" +
                "8 восемь  \n" +
                "9 девять";
        String[] arrMiles = miles.split("\n");
        Map<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < arrMiles.length; i++) {
            String[] line = arrMiles[i].split(" ");
            hashMap.put(Integer.parseInt(line[0]), line[1]);
        }
        return hashMap;
    }

    private static Map<String, Integer> getMilesHash() {
        String miles = "100 сто  \n" +
                "200 двести  \n" +
                "300 триста  \n" +
                "400 четыреста  \n" +
                "500 пятьсот  \n" +
                "600 шестьсот  \n" +
                "700 семьсот  \n" +
                "800 восемьсот  \n" +
                "900 девятьсот  \n" +
                "10 десять  \n" +
                "11 одиннадцать  \n" +
                "12 двенадцать  \n" +
                "13 тринадцать  \n" +
                "14 четырнадцать  \n" +
                "15 пятнадцать  \n" +
                "16 шестнадцать  \n" +
                "17 семнадцать  \n" +
                "18 восемнадцать  \n" +
                "19 девятнадцать  \n" +
                "20 двадцать  \n" +
                "30 тридцать  \n" +
                "40 сорок  \n" +
                "50 пятьдесят  \n" +
                "60 шестьдесят  \n" +
                "70 семьдесят  \n" +
                "80 восемьдесят  \n" +
                "90 девяносто  \n" +
                "1 одна  \n" +
                "2 две  \n" +
                "3 три  \n" +
                "4 четыре  \n" +
                "5 пять  \n" +
                "6 шесть  \n" +
                "7 семь  \n" +
                "8 восемь  \n" +
                "9 девять";
        String[] arrMiles = miles.split("\n");
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arrMiles.length; i++) {
            String[] line = arrMiles[i].split(" ");
            hashMap.put(line[1], Integer.parseInt(line[0]));
        }
        return hashMap;
    }
}
