public class Watek2 implements Runnable {

    int start,koniec;
    Obraz obr;

    public Watek2(Obraz obr,int start, int koniec) {
        this.obr = obr;
        this.start = start;
        this.koniec = koniec;
        localTab = new int[koniec-start];
    }
    int localTab[];

    @Override
    public void run() {
        for(int i = start;i<koniec;i++){
            localTab[i-start] = obr.calculate_and_return_part_of_histogram((char)i);
        }
        for(int i = start;i<koniec;i++)
        obr.setHistogram(i,localTab[i-start]);

        for(int i=start;i<koniec;i++){
            obr.print_part_of_histogram((char)(i));
        }
    }
}
