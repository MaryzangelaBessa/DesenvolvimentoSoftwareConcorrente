package mains;

import attempts.FourthAttempt;

public class MainFourthAttempt{

    static int N = 2;

    public static void main(String [ ] args){

        Thread process[] = new FourthAttempt[N];

        for (int i = 0; i < N; i++) {
            process[i] = new FourthAttempt(i);
            process[i].start();
        }
    }
}
