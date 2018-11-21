import java.util.Scanner;

class Histogram_test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //System.out.println("Set image size: n (#rows), m(#kolumns)");
        //int n = scanner.nextInt();
        int n = 15;
        //int m = scanner.nextInt();
        int m = 15;
        Obraz obraz_1 = new Obraz(n, m);





        //obraz_1.calculate_histogram();
        //obraz_1.print_histogram();

//        Watek thr[] = new Watek[94];
//
//        for(int k=0;k<94;k++) {
//            thr[k]= new Watek(obraz_1,(char)k);
//            thr[k].start();
//        }
//        for(int i = 0;i<94;i++){
//            try {
//                thr[i].join();
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//            }



//        System.out.println("Set number of threads");
//        int num_threads = scanner.nextInt();
//        Thread thrds[] = new Thread[num_threads];
//
//        int numCharPerThread = (94/num_threads);
//
//        for(int i = 0;i<num_threads;i++){
//            int start = i*numCharPerThread;
//            int end = (i+1)*numCharPerThread;
//            if(i==(num_threads-1)&&end<94) end = 94;
//            if(end > 94) end = 94;
//            {
//                thrds[i] = new Thread(new Watek2(obraz_1,start,end));
//                thrds[i].start();
//            }
//        }

        Thread thrdss[] = new Thread[94];

        for(int i = 0;i<m;i++){
            Watek3 wt = new Watek3(obraz_1,i);
            thrdss[i] = new Thread(wt);
            thrdss[i].start();
        }

        obraz_1.print_histogram();






        // Watek[] NewThr = new Watek[num_threads];

        // for (int i = 0; i < num_threads; i++) {
        //     (NewThr[i] = new Watek(...,obraz_1)).start();
        // }

        // for (int i = 0; i < num_threads; i++) {
        //     try {
        // 	NewThr[i].join();
        //     } catch (InterruptedException e) {}
        // }

    }

}
