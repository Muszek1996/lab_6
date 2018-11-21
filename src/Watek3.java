public class Watek3 implements Runnable {

    int wiersz;
    Obraz obr;

    public Watek3(Obraz obr,int wiersz) {
        this.obr = obr;
        this.wiersz = wiersz;
    }

    @Override
    public void run() {
            int [] localTab = obr.calculateRowHistogram(wiersz);
            for(int k = 0;k<94;k++){
                obr.addValsToHistogram(localTab);
            }

        }



    }
