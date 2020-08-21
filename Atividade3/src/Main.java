public class Main {
// Equipe: Eduardo e Maryzangela

    public static void main(String[] args) {

        int arrayC [] = {3, 8, 7, 1, 9, 0, 5, 4, 2, 6};
        //int arrayC [] = {3, 7, 7, 1, 9, 9, 5, 4, 2, 2};
        int arrayD [] = new int[10];

        Ordenador ordenador;
        Ordenador ordenadores [] = new Ordenador[arrayC.length];


        // Apresentação da lista desordenada (array C)
        System.out.print("Lista Desordenada:    { ");
        for (int i = 0; i < arrayC.length; i++) {
            System.out.print(arrayC[i]);
            if (i < arrayC.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");


        //
        for (int i = 0; i < arrayC.length; i++) {
            ordenador = new Ordenador(i, arrayC);
            ordenadores[i] = ordenador;
            ordenadores[i].start();
        }

        for (int i = 0; i < arrayC.length; i++) {
            try {
                ordenadores[i].join();
                int count = ordenadores[i].getCount();
                while (arrayD[count] == ordenadores[i].getMyNumber()) {
                    count++;
                }
                arrayD[count] = ordenadores[i].getMyNumber();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }


        // Apresentação da lista ordenada (array D)
        System.out.print("Lista Ordenada:    { ");
        for (int i = 0; i < arrayD.length; i++) {
            System.out.print(arrayD[i]);
            if (i < arrayD.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(" }");
    }
}
