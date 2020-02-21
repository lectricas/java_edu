package com.lectricas.contest5048;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Tournament {

    //rebyata, eto zhest', ne smotrite

    TreeMap<String, TreeMap<String, String>> plays = new TreeMap<>();

    int numberLength = 0;
    int nameLength = 0;
    int scoreLength = 0;
    int versusLength = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Tournament t = new Tournament();
        long before = System.currentTimeMillis();
        t.run();
//        System.out.println(System.currentTimeMillis() - before + " ms");
    }

    private void run() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input.txt"));

        while (s.hasNext()) {
            String[] line = s.nextLine().split(" ");
            for (int i = 0; i < line.length; i++) {
                String who = line[0];
                String with = line[2];
                String score = line[4];
                if (!plays.containsKey(who)) {
                    TreeMap<String, String> h = new TreeMap<>();
                    h.put(with, score);
                    plays.put(who, h);
                } else {
                    plays.get(who).put(with, score);
                }

                StringBuilder b = new StringBuilder(score);
                score = b.reverse().toString();
                if (!plays.containsKey(with)) {
                    TreeMap<String, String> h = new TreeMap<>();
                    h.put(who, score);
                    plays.put(with, h);
                } else {
                    plays.get(with).put(who, score);
                }
            }
        }

        numberLength = Integer.toString(plays.size()).length();
        versusLength = plays.size();

        List<Letter> letters = new ArrayList<>();
        List<Line> lines = new ArrayList<>();

        for (String key : plays.keySet()) {
            if (nameLength < key.length()) {
                nameLength = key.length();
            }
            TreeMap<String, String> guys = plays.get(key);
            int total = 0;
            Line l = new Line(plays.size());
            for (String key1 : guys.keySet()) {
                String verdict = guys.get(key1);
                if (verdict.equals("0:1")) {
                    verdict = "L";
                } else if (verdict.equals("1:0")) {
                    total += 2;
                    verdict = "W";
                } else {
                    verdict = "D";
                    total++;
                }
                l.versus[plays.headMap(key1).size()] = verdict;
            }

            int length = Integer.toString(total).length();
            if (scoreLength < length) {
                scoreLength = length;
            }

            l.score = total;
            l.name = key;
            lines.add(l);
            letters.add(new Letter(total, key));
        }

        HashMap<String, Integer> positions = getPositions(letters);
        String divider = divider();

        for (int i1 = 0; i1 < lines.size(); i1++) {
            Line l = lines.get(i1);
            System.out.println(divider);
            String leftAlignFormat = "|%" + numberLength + "d|%-"+nameLength+"s |";
            System.out.format(leftAlignFormat, i1 + 1, l.name);
            for (int i = 0; i < l.versus.length; i++) {
                String versus = l.versus[i];
                if (versus == null) {
                    if (i == i1) {
                        versus = "X";
                    } else {
                        versus = " ";
                    }
                }
                System.out.print(versus + "|");
            }
            leftAlignFormat = "%" + scoreLength + "d|%-1s|%n";
            Integer position = positions.get(l.name);
            String p;
            if (position == null) {
                p = " ";
            }   else {
                p = position.toString();
            }
            System.out.format(leftAlignFormat, l.score, p);
        }
        System.out.println(divider);
    }

    private HashMap<String, Integer> getPositions(List<Letter> letters) {
        letters.sort((o1, o2) -> Integer.compare(o2.number, o1.number));
        HashMap<String, Integer> positions = new HashMap<>();
        int place = 1;
        int i = 0;
        while (place < 4 && i < letters.size()) {
            while (i < letters.size() - 1 && letters.get(i).number == letters.get(i + 1).number) {
                positions.put(letters.get(i).letter, place);
                i++;
            }
            positions.put(letters.get(i).letter, place);
            i++;
            place++;
        }
        return positions;
    }

    private String divider() {
        StringBuilder builder = new StringBuilder();
        builder.append("+");
        for (int i = 0; i < numberLength; i++) {
            builder.append("-");
        }
        builder.append("+");
        for (int i = 0; i < nameLength + 1; i++) {
            builder.append("-");
        }
        for (int i = 0; i < versusLength; i++) {
            builder.append("+");
            builder.append("-");
        }
        builder.append("+");
        for (int i = 0; i < scoreLength; i++) {
            builder.append("-");
        }
        builder.append("+");
        builder.append("-");
        builder.append("+");
        return builder.toString();
    }

    class Letter {
        int number;
        String letter;

        public Letter(int number, String letter) {
            this.number = number;
            this.letter = letter;
        }
    }

    class Line {
        String name;
        String[] versus;
        int pos = 0;
        int score = 0;

        public Line(int n) {
            versus = new String[n];
        }
    }
}