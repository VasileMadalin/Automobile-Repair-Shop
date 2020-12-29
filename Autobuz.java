public class Autobuz extends Masina {
    private int nr_locuri;
    public Autobuz() {

    }
    public Autobuz(int nr_locuri) {
        this.nr_locuri = nr_locuri;
    }
    public int polita() {
        int polita = (2020 - super.get_an_fb()) * 200;
        if (super.get_diesel() == 1) {
            polita = polita + 1000;
        }
        if (super.get_nr_km() > 100000 && super.get_nr_km() <= 200000) {
            polita = polita + 1000;
        }
        if (super.get_nr_km() > 200000) {
            polita = polita + 1000;
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
        System.out.println("Autobuz" + "    " + mesaj);
    }
}
