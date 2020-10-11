package attempts;

public class SecondAttempt extends Thread{

    // Número de Procesos
    static int N = 2;
    static boolean want [] = new boolean[N];
    private int id;

    public SecondAttempt(int i){
        id = i;
    }

    private int random(int n){
        return (int) Math.round( n * Math.random() - 0.5 );
    }

    private void work(){
        try{
            sleep(random(500));
        } catch (InterruptedException e) { }
    }

    private void nonCriticalSection(){
        System.out.println("O processo " + id + " está na seção não crítica.");
        work();
    }

    private void criticalSection(){
        System.out.println("O processo " + id + " está entrando na seção crítica.");
        work();
        System.out.println("O processo " + id + " está saindo da seção crítica.");
    }

    private boolean wait(int i){
        boolean w = false;
        for (int j = 0 ; j < N ; j++) {
            if (j != i){
                w = w;
            } else {
                w = want[j];
            }
        }
        return w;
    }

    private void await(){
        do {
        } while (wait(id));
        want[id] = true;
    }

    private void changeWant(){
        want[id] = false;
    }

    public void run(){

        // Inicializando as variáveis WANT de cada processo
        for (int i = 0; i < N; i++) {
            want[i] = false;
        }

        do{
            nonCriticalSection();
            await();
            criticalSection();
            changeWant();
        } while (true) ;
    }
}