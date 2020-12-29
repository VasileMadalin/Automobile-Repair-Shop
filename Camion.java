public class Camion extends Masina {
    private int tonaj;
    public Camion () {

    }
    public Camion(int tonaj) {
        this.tonaj = tonaj;
    }
    public int polita() {
        int polita = (2020 - super.get_an_fb())*300;
        if (super.get_nr_km() > 800000) {
            polita = polita + 700;
        }
        return polita;
    }
    public void afisare() {
        String mesaj = "";
        if (super.getMecanic() == -1)
            mesaj = "In asteptare    ?                  " + super.getID();
        if (super.getMecanic() == -2)
            mesaj = "Finalizat                          " + super.getID();
        if (super.getMecanic() == -3)
            mesaj = "Comanda anulata -                  " + super.getID();
        if (super.getMecanic() > 0) {
            mesaj = "ID" + super.getMecanic() + "   " + "         " + super.getTime() + "                   " + super.getID();
        }
        System.out.println("Camion" + "     " + mesaj);
    }
}
