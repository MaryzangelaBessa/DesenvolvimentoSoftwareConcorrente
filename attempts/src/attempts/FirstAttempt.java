package attempts;

public class FirstAttempt extends Thread {

    static int N = 2;   // Número de processos
    static int turn = 0;
    private int id;

    public FirstAttempt(int i) {
        id = i;
    }

    private int random(int n) {
        return (int) Math.round( n * Math.random() - 0.5 );
    }

    private void work() {
        try{
            sleep(random(500));
        } catch (InterruptedException e) { }
    }

    private void nonCriticalSection() {
        System.out.println("O processo " + id + " está na seção não crítica.");
        work();
    }

    private void criticalSection() {
        System.out.println("O processo " + id + " está entrando na seção crítica.");
        work();
        System.out.println("O processo " + id + " está saindo da seção crítica.");
    }

    private void await() {
        do{
        } while (turn != id);
    }

    private void changeTurn() {
        turn = random(N);
        System.out.println("turn = " + turn);
    }

    public void run() {
        do{
            nonCriticalSection();
            await();
            criticalSection();
            changeTurn();
        } while (true);
    }
}
