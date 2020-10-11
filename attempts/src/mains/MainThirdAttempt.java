package mains;

import attempts.ThirdAttempt;

public class MainThirdAttempt {

    static int N = 2;

    public static void main(String [ ] args){

        Thread process[] = new ThirdAttempt[N];

        for (int i = 0; i < N; i++){
            process[i] = new ThirdAttempt(i);
            process[i].start();
        }
    }
}
