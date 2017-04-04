package proposereject;

import java.util.ArrayList;
import java.util.Arrays;

public class ProposeReject {

    public static void main(String[] args) {
        ArrayList<Integer> Menarray = new ArrayList<>(Arrays.asList(-1, -1, -1, -1, -1));
        ArrayList<Integer> Womenarray = new ArrayList<>(Arrays.asList(-1, -1, -1, -1, -1));
        int[] mencount = new int[]{0, 0, 0, 0, 0};
        /* Counter array for men for the record of propose done*/
        int Menpreference[][]
                = {
                    {1, 0, 3, 4, 2},
                    {3, 1, 0, 2, 4},
                    {1, 4, 2, 3, 0},
                    {0, 3, 2, 1, 4},
                    {1, 3, 0, 4, 2}
                };
        int Womenpreference[][]
                = {
                    {4, 0, 1, 3, 2},
                    {2, 1, 3, 0, 4},
                    {1, 2, 3, 4, 0},
                    {0, 4, 3, 2, 1},
                    {3, 1, 4, 2, 0}
                };
        int[][] inverse = new int[5][5];
        /* declare inverse women pref array for efficient implementation */
 /* make inverse women pref array for efficient implementation */
        for (int x = 0; x < Womenpreference.length; x++) {
            for (int y = 0; y < Womenpreference[x].length; y++) {
                inverse[x][Womenpreference[x][y]] = y;
            }
        }
        /* algorithm steps is followed */
        while (Menarray.contains(-1)) {
            int i = Menarray.indexOf(-1);
            int CurrWomanStat = Menpreference[i][mencount[i]];
            if (Womenarray.get(CurrWomanStat) == -1) {
                Menarray.set(i, CurrWomanStat);
                Womenarray.set(CurrWomanStat, i);
                mencount[i]++;
            } else {
                int currentman_pos = inverse[CurrWomanStat][Womenarray.get(CurrWomanStat)];
                int newman_pos = inverse[CurrWomanStat][i];
                if (currentman_pos < newman_pos) {
                } else {
                    Menarray.set(Womenarray.get(CurrWomanStat), -1);
                    Menarray.set(i, CurrWomanStat);
                    Womenarray.set(CurrWomanStat, i);
                }
                mencount[i]++;
            }
        }
        /* print output code is followd*/
        String womenname[] = {"Amy", "Bertha", "Clare", "Diane", "Erika"};
        String menname[] = {"Victor", "Wyaat", "Xavier", "Yancy", "Zeus"};
        System.out.println("Men : Women");
        for (int i = 0; i < Menarray.size(); i++) {
            System.out.printf("%s : %s\n", menname[i], womenname[Menarray.get(i)]);
        }
    }
}
