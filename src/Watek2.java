public class Watek2 implements Runnable {

    private int start,koniec;
    private Obraz obr;
    private int[] localTab;

    Watek2(Obraz obr,int start, int koniec) {
        this.obr = obr;
        this.start = start;
        this.koniec = koniec;
        localTab = new int[koniec-start];
    }


    @Override
    public void run() {
        localTab = obr.calculate_and_return_part_of_histogram((char)start,(char)koniec);

        for(int i = start;i<koniec;i++) {
            obr.setHistogram(i, localTab[i - start]);
            obr.print_part_of_histogram((char) (i));
        }
    }
}
