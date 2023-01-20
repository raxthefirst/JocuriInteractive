package com.radustan.jocuriinteractive;


import java.util.Random;

public class QuestionAnswer {

    public static Random random = new Random();
    public static int select = random.nextInt(7);



    public static String forme[] ={
            "dreptunghi",
            "oval",
            "cerc",
            "triunghi",
            "pătrat",
            "romb",
            "trapez",
            "pentagon",
            "hexagon"
    };


    public static String[] question ={
            "Fă click pe " + forme[select] + ".",
            "Care dintre formele de mai jos este un " + forme[select + 1] + '?',
            "Apasă pe " + forme[select + 2] + '.',
            "Selectează imaginea cu un " + forme[select + 3] + '.'
    };



    static int rand(int j, int k){
        int nr = random.nextInt(8);
        int nr2 = random.nextInt(8);
        int nr3 = random.nextInt(8);
/*        int i1 = random.nextInt(8);
        int i2 = random.nextInt(8);
        int i3 = random.nextInt(8);
        int i4 = random.nextInt(8);*/

        while(nr == select + k || nr2 == select + k || nr3 == select + k || nr == nr2 || nr == nr3 || nr2 == nr3)
        {
            if(nr == select + k)
                nr = random.nextInt(8);
            if(nr2 == select + k)
                nr2 = random.nextInt(8);
            if(nr3 == select + k)
                nr3 = random.nextInt(8);

            if(nr == nr2)
                nr = random.nextInt(8);
            if(nr == nr3)
                nr = random.nextInt(8);
            if(nr2 == nr3)
                nr2 = random.nextInt(8);
        }


        /*while(nr == nr2 || nr2 == nr3 || nr == nr3 || nr == select + k || nr2 == select + k || nr3 == select + k)
        {
            while(nr == nr2 || nr == nr3)
            {
                nr = random.nextInt(8);
                while (nr2 == nr3)
                    nr3 = random.nextInt(8);
            }
            while(nr2 == nr3)
                nr3 = random.nextInt(8);
            while(nr == select + k)
            {
                nr = random.nextInt(8);
                while(nr == nr2 || nr == nr3)
                    nr = random.nextInt(8);
            }
            while(nr2 == select + k)
            {
                nr2 = random.nextInt(8);
                while(nr2 == nr || nr2 == nr3)
                    nr2 = random.nextInt(8);
            }
            while(nr3 == select + k)
            {
                nr3 = random.nextInt(8);
                while(nr3 == nr || nr2 == nr3)
                    nr3 = random.nextInt(8);
            }
        }*/
        
       /*int[] fr = new int[0];
        
        fr[nr]++;
        fr[nr2]++;
        fr[nr3]++;
        int i, m;
        for(i = 0; i <= 9; i++)
            while(fr[i] > 1)
            {
                fr[i]--;
                m = random.nextInt(9 - i) + i; ///j este o valoare random de la i la 9
                if(fr[m] == 0)
                    fr[m]++; ///creste frecventa unei valori random de la i pana la 9
                else
                    fr[++m]++; ///merg la urm nr din fr
            }

        int[] vec= new int[0];
        for(i = 0; i <= 9 && fr[i] != 0; i++)
        {
            int bula = 0;
            vec[bula++] = fr[i];
        }*/
        String[] treinum={
                String.valueOf(nr),
                String.valueOf(nr2),
                String.valueOf(nr3)

        };
        return Integer.parseInt(treinum[j]);
    }

    public void rr(){
        if(activity_quiz1.da == true)
        {
            int select = random.nextInt(7);
        }
    }

    public static String[][] choices = {
            {forme[select],forme[rand(0,0)],forme[rand(1,0)],forme[rand(2,0)]},
            {forme[rand(0,1)],forme[select+1],forme[rand(1,1)], forme[rand(2,1)]},
            {forme[rand(0,2)],forme[rand(1,2)],forme[select+2],forme[rand(2,2)]},
            {forme[rand(0,3)],forme[rand(1,3)],forme[select+3],forme[rand(2,3)]}
    };

    public static String[] correctAnswers = {
            forme[select],
            forme[select+1],
            forme[select+2],
            forme[select+3]
    };


}

