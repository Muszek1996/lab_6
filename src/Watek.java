class Watek extends Thread{

    private Obraz obr;
    private char znak;

    Watek (Obraz obr,char a){
        this.obr = obr;
        znak = a;
    }

    @Override
    public void run(){
        obr.calculate_part_of_histogram(znak);
        obr.print_part_of_histogram(znak);
    }


}