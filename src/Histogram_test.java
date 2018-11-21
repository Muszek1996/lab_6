import java.util.Scanner;

class Histogram_test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = 25;
        int m = 40;
        Obraz obraz_1 = new Obraz(n, m);

        //Zad1a
        Watek[] thr = new Watek[94];
        for (int k = 0; k < 94; k++) {
            thr[k] = new Watek(obraz_1, (char) k);
            thr[k].start();
        }
        for (int i = 0; i < 94; i++) {
            try {
                thr[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Zad1b
        System.out.println("Set number of threads");
        int num_threads = scanner.nextInt();
        Thread[] thrds = new Thread[num_threads];

        int numCharPerThread = (94 / num_threads);

        for (int i = 0; i < num_threads; i++) {
            int start = i * numCharPerThread;
            int end = (i + 1) * numCharPerThread;
            if (i == (num_threads - 1) && end < 94) end = 94;
            thrds[i] = new Thread(new Watek2(obraz_1, start, end));
            thrds[i].start();
        }


    }

}
