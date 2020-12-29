public class Coada_Masini {
    Nod_lista_masina list;

    public Coada_Masini() {
    }
    public void add(Masina y) {
        Nod_lista_masina iterator = list;
        if (list == null) {
            list = new Nod_lista_masina();
            list.data = y;
        }
        else {
            while( iterator.next != null ) {
                iterator = iterator.next;
            }
            iterator.next = new Nod_lista_masina();
            iterator.next.data = y;
        }
    }
    public void afisare() {
        Nod_lista_masina iterator = list;
        while (iterator != null) {
            iterator.data.afisare();
            iterator = iterator.next;
        }
    }
    public int verificare_index(int index, Masina z) {
        Nod_lista_masina iterator = list;
        int k1 = 0, k2 = 0, k3 = 0;
        while (iterator != null) {
            if ( iterator.data.getMecanic() == index) {
                if (iterator.data instanceof Standard) k1 = k1 + 1;
                if (iterator.data instanceof Camion) k2 = k2 + 1;
                if (iterator.data instanceof Autobuz) k3 = k3 + 1;
            }
            iterator = iterator.next;
        }
        if ((z instanceof Standard) && (k1 < 3)) return 1;
        if ((z instanceof Camion) && (k2 < 1))  return 1;
        if ( (z instanceof Autobuz) && (k3 < 1)) return 1;

        return 0;
    }
    public void trece_timpul(int Timp) {
        Nod_lista_masina iterator = list;
        while (iterator != null) {
            if ( iterator.data.getMecanic() > 0) {
                int noul_timp = iterator.data.getTime() - Timp;
                if (noul_timp < 0) noul_timp = 0;
                if (noul_timp == 0) {
                    iterator.data.setMecanic(-2);
                }
                iterator.data.SetTimp(noul_timp);
            }
            iterator = iterator.next;
        }
    }
    public void actualizare() {
        Nod_lista_masina iterator = list;
        while (iterator != null) {
            if ( iterator.data.getMecanic() == -1) {
                int ok = 0;
                int max = Angajat.getID_static();
                for (int i = 1; i <= max; i++) {
                    if ( verificare_index(i, iterator.data) == 1 ) {
                        iterator.data.setMecanic(i);
                        iterator.data.SetTimp(20);
                        ok = 1;
                        break;
                    }
                }
                if (ok == 0) {
                    iterator.data.setMecanic(-1);
                }
            }
            iterator = iterator.next;
        }
    }
    public double calculare_polita(int index, String type) {
        Nod_lista_masina iterator = list;
        int k = 1;
        while (iterator != null && k != index) {
            k = k + 1;
            iterator = iterator.next;
        }
        double rez = iterator.data.polita();
        if (type.equals("DISCOUNT")) {
            if (iterator.data instanceof Standard) rez = 0.95 * rez;
            if (iterator.data instanceof Autobuz) rez = 0.90 * rez;
            if (iterator.data instanceof Camion) rez = 0.85 * rez;
        }
        return rez;
    }
}