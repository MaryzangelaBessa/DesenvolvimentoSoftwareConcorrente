import java.util.Vector;

public class Ordenador extends Thread{

    private int myNumber;
    private int [] listaC;
    private Vector arrayD;
    private int count;

    public Ordenador(int id, int [] listaC, Vector <Integer> arrayD){
        this.myNumber = listaC[id];
        this.listaC = listaC;
        this.arrayD = arrayD;
    }

    public int getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(int myNumber) {
        this.myNumber = myNumber;
    }

    public int[] getListaC() {
        return listaC;
    }

    public void setListaC(int[] listaC) {
        this.listaC = listaC;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void run() {
        this.setCount(0);
        for (int i = 0; i < this.listaC.length; i++) {
            if (this.listaC[i] < this.myNumber) {
                this.setCount(this.count+1);
                while (this.arrayD.get(this.getCount()).equals(this.getMyNumber())) {
                    count++;
                }
                arrayD.set(count, this.getMyNumber());
            }
        }
    }
}
