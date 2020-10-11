package mains;

import attempts.SecondAttempt;

public class MainSecondAttempt {

    //Número de Procesos
    static int N = 2;

    public static void main(String [ ] args){

        Thread process[] = new SecondAttempt[N];

        for (int i = 0; i < N; i++){
            process[i] = new SecondAttempt(i);
            process[i].start();
        }
    }
}
