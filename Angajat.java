public abstract class Angajat {
    private static int index;
    private String Nume, Prenume, Data_Nasterii ;
    private String Data_Angajarii;
    private int ID;
    private double Coeficient_salarial;

    public Angajat() {
        index = index + 1;
        this.ID = index;
    }
    public void set (String Nume, String Prenume, String Data_Nasterii, String Data_Angajarii) {
        this.Nume = Nume;
        this.Prenume = Prenume;
        this.Data_Nasterii = Data_Nasterii;
        this.Data_Angajarii = Data_Angajarii;
    }
    public void afisare() {
        System.out.println(this.Nume + " " + this.Prenume + " " + this.Data_Nasterii + " " + this.Data_Angajarii + " " + this.ID);
    }
    public int getID() {
        return this.ID;
    }
    public void setCoef(double Coeficient_salarial) {
        this.Coeficient_salarial =  Coeficient_salarial;
    }
    public double getCoef() {
        return Coeficient_salarial;
    }

    public String getData_angajarii() {
        return Data_Angajarii;
    }
    public String getData_Nasterii() {
        return Data_Nasterii;
    }
    public String getNume() {
        return Nume;
    }
    public String getPrenume() {
        return Prenume;
    }

    public void setIndex(int index) {
        this.ID = index;
    }

    public static int getID_static() {
        return index;
    }
    public void decIDstatic() {
        index = index - 1;
    }
}
