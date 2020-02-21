package com.lectricas.contest5048;

import java.util.*;

public class TournamentTest {
    public static void main(String[] args) {
        List<Letter> numbers = new ArrayList<>();

        Random r = new Random();

//        numbers.add(new Letter(7, 'b'));
//        numbers.add(new Letter(5, 'e'));
//        numbers.add(new Letter(6, 'c'));
//        numbers.add(new Letter(7, 'a'));
//        numbers.add(new Letter(6, 'd'));
//        numbers.add(new Letter(3, 'f'));
//        numbers.add(new Letter(3, 'k'));
        for (int i = 0; i < 1000; i++) {
            char c = (char)(r.nextInt(26) + 'a');
            numbers.add(new Letter(r.nextInt(1000), c));
        }


        numbers.sort(new Comparator<Letter>() {
            @Override
            public int compare(Letter o1, Letter o2) {
                return Integer.compare(o2.number, o1.number);
            }
        });


        int place = 1;
        int i = 0;
        while (place < 4 && i < numbers.size()) {
            while (i < numbers.size() - 1 && numbers.get(i).number == numbers.get(i + 1).number) {
                System.out.println(numbers.get(i).letter + " " + place);
                i++;
            }
            System.out.println(numbers.get(i).letter + " " + place);
            i++;
            place++;
        }

        System.out.println();
    }

    static class Letter {
        int number;
        char letter;

        public Letter(int number, char letter) {
            this.number = number;
            this.letter = letter;
        }
    }
}
