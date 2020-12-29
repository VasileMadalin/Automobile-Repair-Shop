public class Coada {
    Nod_lista list;
    public Coada(){
    }
    public void add(Angajat y) {
        Nod_lista iterator = list;
        if (list == null) {
            list = new Nod_lista();
            list.data = y;
        }
        else {
            while( iterator.next != null ) {
                iterator = iterator.next;
            }
            iterator.next = new Nod_lista();
            iterator.next.data = y;
        }
    }
    public void afisare() {
        if (Angajat.getID_static() != 0) {
            Nod_lista iterator = list;
            while (iterator != null) {
                iterator.data.afisare();
                iterator = iterator.next;
            }
        }
        else {
            System.out.println("Nu exista angajati momentan");
        }
    }
    public void stergere(int index) {
        Nod_lista iterator = list;
        Nod_lista back = null;
        int k = 1;
        while (iterator != null && k != index) {
            k = k + 1;
            back = iterator;
            iterator = iterator.next;
        }
        list.data.decIDstatic();
        if (back == null) {
            list = list.next;
        } else {
            back.next = iterator.next;
        }
        if (back == null) back = list;
        else back = back.next;
        while (back != null) {
            k = back.data.getID();
            back.data.setIndex(k - 1);
            back = back.next;
        }
    }
    public double calculare(int index) {
        Nod_lista iterator = list;
        Nod_lista back = null;
        int k = 1;
        while (iterator != null && k != index) {
            k = k + 1;
            iterator = iterator.next;
        }
        double coef = iterator.data.getCoef();
        String data = iterator.data.getData_angajarii();
        String[] parts = data.split("[.]");
        int an_angajare = Integer.parseInt(parts[2]);
        double rez = (2020 - an_angajare) * coef * 1000;
        return rez;
    }
    public void editare(int index, Angajat y) {
        Nod_lista iterator = list;
        int k = 1;
        while (iterator != null && k != index) {
            k = k + 1;
            iterator = iterator.next;
        }
        y.setIndex(index);
        iterator.data = y;
    }
}