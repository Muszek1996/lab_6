import  java.util.Random;
import java.util.Scanner;


class Obraz {

    private int size_n;

    public int getSize_m() {
        return size_m;
    }

    private int size_m;
    private char[][] tab;
    private int[] histogram;

    public void setHistogram(int pos,int val) {
        this.histogram[pos] = val;
    }
    synchronized public void addValsToHistogram(int [] tab) {
        for(int i=0;i<94;i++){
            histogram[i] +=tab[i];
        }
    }

    public Obraz(int n, int m) {

        this.size_n = n;
        this.size_m = m;
        tab = new char[n][m];

        final Random random = new Random();

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                tab[i][j] = (char)(random.nextInt(94)+33);  // ascii 33-127
                System.out.print(tab[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");

        histogram = new int[94];
        clear_histogram();
    }

    public void clear_histogram(){

        for(int i=0;i<94;i++) histogram[i]=0;

    }

    public void calculate_histogram(){

        for(int i=0;i<size_n;i++) {
            for(int j=0;j<size_m;j++) {

                for(int k=0;k<94;k++) {
                    if(tab[i][j] == (char)(k+33)) histogram[k]++;
                }

            }
        }

    }

    public void calculate_part_of_histogram(char znak){


        for(int i=0;i<size_n;i++) {
            for(int j=0;j<size_m;j++) {
                    if(tab[i][j] == (char)(znak+33)) histogram[znak]++;
            }
        }

    }
    public int calculate_and_return_part_of_histogram(char znak){
        int localhistogram = 0;

        for(int i=0;i<size_n;i++) {
            for(int j=0;j<size_m;j++) {
                    if(tab[i][j] == (char)(znak+33)) localhistogram++;
            }
        }
        return localhistogram;
    }

   public void print_histogram(){

        for(int i=0;i<94;i++) {
            System.out.print("Wątek"+Thread.currentThread().getId()+" "+(int)i+": ");
            for(int j=0;j<histogram[i];j++)
                System.out.print("=");
            System.out.print("\n");
        }

    }

    int [] calculateRowHistogram(int rowNmber){
        int [] localHistogram= new int [94];

        for(int j=0;j<(size_m-1);j++) {
            char currChar = (char)tab[rowNmber][j];
                localHistogram[currChar-33]++;
            }
            return localHistogram;
    }

    synchronized public void print_part_of_histogram(char i){


        System.out.print("Wątek"+Thread.currentThread().getId()+" "+(int)i+": ");
        for(int j=0;j<histogram[i];j++)
            System.out.print("=");
        System.out.print("\n");
    }

}
