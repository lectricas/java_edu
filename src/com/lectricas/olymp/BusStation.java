package com.lectricas.olymp;

public class BusStation {

    private static int size = 60;
    private static int len = 11;
    public static void main(String[] args) {


        int[] guy = new int[size];
        int[] bus = new int[size];

        int count = 0;

        for (int i = 0; i < guy.length; i++) {
            int j = i;
            guy = new int[size];
            while (j < guy.length && j - i < len) {
                guy[j] = 1;
                j++;
            }

            for (int k = 0; k < bus.length; k++) {
                int r = k;
                bus = new int[size];
                while (r < bus.length && r - k < len) {
                    bus[r] = 1;
                    r++;
                }

                int l = 0;
                while (l < bus.length) {
                    if (bus[l] == 1 && guy[l] == 1) {
                        count++;
                        break;
                    }
                    l++;
                }
            }

//            for (int i1 = 0; i1 < guy.length; i1++) {
//                System.out.print(guy[i1] + ",");
//            }

        }
        System.out.println(count);
    }
}
