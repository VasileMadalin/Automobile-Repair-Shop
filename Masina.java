public abstract class Masina {
    private static int ID;
    private int index, nr_km, an_fb, diesel;
    private int mecanic;
    private int Timp;
    public Masina() {
        ID = ID + 1;
        this.index = ID;
    }

    public void set(int nr_km, int an_fb, int diesel, int mecanic) {
        this.nr_km = nr_km;
        this.an_fb = an_fb;
        this.diesel = diesel;
        this.mecanic = mecanic;
    }

    public int get_nr_km() {
        return this.nr_km;
    }
    public int get_an_fb() {
        return this.an_fb;
    }
    public int get_diesel () {
        return diesel;
    }

    public int polita() {
        return 0;
    }

    public int getMecanic() {
        return mecanic;
    }
    public void afisare() {

    }
    public void setMecanic(int index) {
        this.mecanic = index;
    }
    public void SetTimp(int timp) {
        this.Timp = timp;
    }
    public int getTime() {
        return this.Timp;
    }
    public static int getID_static() {
        return ID;
    }
    public int getID() {
        return index;
    }
}
