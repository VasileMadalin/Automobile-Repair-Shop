public class Standard extends Masina{
    private String transmisie;
    public Standard () {

    }
    public Standard(String transmisie) {
        this.transmisie = transmisie;
    }
    public int polita() {
        int polita = (2020 - super.get_an_fb())*100;
        if (super.get_diesel() == 1) {
            polita = polita + 500;
        }
        if (super.get_nr_km() > 200000) {
            polita = polita + 500;
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
        System.out.println("Standard" + "   " + mesaj);
    }
}
