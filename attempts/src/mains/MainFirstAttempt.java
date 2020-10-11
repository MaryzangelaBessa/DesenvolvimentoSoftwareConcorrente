package mains;
import attempts.FirstAttempt;

public class MainFirstAttempt {
    static int N = 2;   // Number of processes.

    public static void main(String[] args) {
        Thread process[] = new FirstAttempt[N];
        for (int i = 0 ; i < N ; i++) {
            process[i] = new FirstAttempt(i);
            process[i].start();
        }
    }
}
