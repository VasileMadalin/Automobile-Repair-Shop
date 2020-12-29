import java.util.Random;
import java.io.IOException;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
public class Test {
    public static boolean verificare_data_n(String Data_nasterii) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String strDate = dateFormat.format(date);
        String[] parts1 = Data_nasterii.split("[.]");
        String[] parts2 = strDate.split("[.]");
        int an_nastere = Integer.parseInt(parts1[2]);
        int an_prezent = Integer.parseInt(parts2[2]);
        if (an_prezent - an_nastere >= 18)  return true;
        return false;
    }
    public static boolean verificare_data_a(String Data_angajarii) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String strDate = dateFormat.format(date);
        String[] parts1 = Data_angajarii.split("[.]");
        String[] parts2 = strDate.split("[.]");
        int an_angajare = Integer.parseInt(parts1[2]);
        int an_prezent = Integer.parseInt(parts2[2]);
        int luna_angajare = Integer.parseInt(parts1[1]);
        int luna_prezent = Integer.parseInt(parts2[1]);
        int zi_angajare = Integer.parseInt(parts1[0]);
        int zi_prezent = Integer.parseInt(parts2[0]);
        if (an_prezent > an_angajare) return true;
        if (an_prezent == an_angajare) {
            if (luna_prezent > luna_angajare) return true;
            if (luna_prezent == luna_angajare) {
                if (zi_prezent > zi_angajare) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {

        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *  *");
        System.out.println("* Aplicatia permite introducerea urmatoarelor comenzi, pentru a finaliza introduceti EXIT  *");
        System.out.println("* ADAUGA_ANGAJAT NUME PRENUME DATA NASTERII DATA ANGAJARII FUNCTIE                         *");
        System.out.println("* STERGE_ANGAJAT ID                                                                        *");
        System.out.println("* EDITARE ID NUME PRENUME DATA NASTERII DATA ANGAJARII FUNCTIE                             *");
        System.out.println("* CALCULARE_SALARIU ID                                                                     *");
        System.out.println("* AFISARE_ANGAJATI                                                                         *");
        System.out.println("* STERGE_ANGAJAT                                                                           *");
        System.out.println("* ADAUGA_MASINA TIP AN DE FABRICARE NR KILOMETRI MOTORIZARE(diesel/benzina) Preferinta ID  *");
        System.out.println("* ADAUGA_MASINA TIP AN DE FABRICARE NR KILOMETRI MOTORIZARE(diesel/benzina) FaraPreferinta *");
        System.out.println("* STATUS_COMENZI *");
        System.out.println("* CALCULARE_POLITA DISCOUNT/NORMAL ID                                                      *");
        System.out.println("* DUPA NR MINUTE(Simuleaza trecerea timpului)                                              *");
        System.out.println("* Functia unui angajat din atelier poate fi Director/Asistent/Mecanic                      *");
        System.out.println("* Tipul masinii poate fi doar Standard/Autobuz/Camion                                      *");
        System.out.println("* Observatie:Dureaza 5 minute ca o masina sa fie procesata in baza de date                 *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *  *");

        int Timp = 0;
        Coada a = new Coada();
        Coada_Masini b = new Coada_Masini();
        Scanner input = new Scanner(System.in);
        String command = input.next();

        while (!command.equals("EXIT")) {
            boolean known = false;
            if (command.equals("ADAUGA_ANGAJAT")) {
                known = true;
                String Nume = input.next();
                String Prenume = input.next();
                String Data_nasterii = input.next();
                boolean ok = true;
                String Data_angajarii = input.next();
                if (!verificare_data_n(Data_nasterii) ) {
                    System.out.println("Angajatul nu are 18 ani");
                    ok = false;
                }
                if (!verificare_data_a(Data_angajarii) ) {
                    System.out.println("Data angajarii nu este valida");
                    ok = false;
                }
                if (ok) {
                    String pozitie = input.next();
                    Angajat y;
                    if (pozitie.equals("Director")) {
                        y = new Director();
                        y.set(Nume, Prenume, Data_nasterii, Data_angajarii);
                        a.add(y);
                    }
                    if (pozitie.equals("Asistent")) {
                        y = new Asistent();
                        y.set(Nume, Prenume, Data_nasterii, Data_angajarii);
                        a.add(y);
                    }
                    if (pozitie.equals("Mecanic")) {
                        y = new Mecanic();
                        y.set(Nume, Prenume, Data_nasterii, Data_angajarii);
                        a.add(y);
                    }
                }
            }
            if (command.equals("STERGE_ANGAJAT")) {
                known = true;
                int index = input.nextInt();
                a.stergere(index);
            }
            if (command.equals("AFISARE_ANGAJATI")) {
                known = true;
                if (Angajat.getID_static() != 0) {
                    System.out.println("Nume Prenume Data nasterii Data angajarii ID");
                }
                a.afisare();
            }
            if ( command.equals("CALCULARE_SALARIU")) {
                known = true;
                int index = input.nextInt();
                if ( Angajat.getID_static() >= index ) {
                    System.out.println(a.calculare(index));
                }
                else System.out.println("Nu exista acest angajat");
            }
            if ( command.equals("EDITARE") ) {
                known = true;
                int index = input.nextInt();
                if (Angajat.getID_static() >= index) {
                    String Nume = input.next();
                    String Prenume = input.next();
                    String Data_nasterii = input.next();
                    boolean ok = true;
                    String Data_angajarii = input.next();
                    if (!verificare_data_n(Data_nasterii) ) {
                        System.out.println("Angajatul nu are 18 ani");
                        ok = false;
                    }
                    if (!verificare_data_a(Data_angajarii) ) {
                        System.out.println("Data angajarii nu este valida");
                        ok = false;
                    }
                    if (ok) {
                        String pozitie = input.next();
                        Angajat y;
                        if (pozitie.equals("Director")) {
                            y = new Director();
                            y.set(Nume, Prenume, Data_nasterii, Data_angajarii);
                            a.add(y);
                        }
                        if (pozitie.equals("Asistent")) {
                            y = new Asistent();
                            y.set(Nume, Prenume, Data_nasterii, Data_angajarii);
                            a.add(y);
                        }
                        if (pozitie.equals("Mecanic")) {
                            y = new Mecanic();
                            y.set(Nume, Prenume, Data_nasterii, Data_angajarii);
                            a.add(y);
                        }
                    }
                }
                else System.out.println("Nu exista acest angajat");
            }
            if (command.equals("ADAUGA_MASINA")) {
                known = true;
                if ( Angajat.getID_static() == 0 )
                    System.out.println("Niciun angajat in atelier");
                else {
                    String type = input.next();
                    int an = input.nextInt();
                    int km = input.nextInt();
                    String com = input.next();
                    Masina z = null;
                    if (type.equals("Standard")) {
                        z = new Standard();
                        int diesel = 0;
                        if (com.equals("diesel")) diesel = 1;
                        z.set(km, an, diesel, 0);
                        b.add(z);
                    }
                    if (type.equals("Autobuz")) {
                        z = new Autobuz();
                        int diesel = 0;
                        if (com.equals("diesel")) diesel = 1;
                        z.set(km, an, diesel, 0);
                        b.add(z);
                    }
                    if (type.equals("Camion")) {
                        z = new Camion();
                        int diesel = 0;
                        if (com.equals("diesel")) diesel = 1;
                        z.set(km, an, diesel, 0);
                        b.add(z);
                    }
                    String dec = input.next();
                    if (dec.equals("Preferinta")) {
                        int index = input.nextInt();
                        int max = Angajat.getID_static();
                        if (index <= max) {
                            if (b.verificare_index(index, z) == 1) {
                                Random rand = new Random();
                                int rand_int = 1 + rand.nextInt(59);
                                z.setMecanic(index);
                                z.SetTimp(rand_int);
                                Timp = Timp + 5;///fiecare procesare dureaza 5 minute
                                b.trece_timpul(5);
                                b.actualizare();
                            } else {
                                System.out.println("Nu mai sunt locuri la acest angajat!");
                                System.out.println("Doriti sa treceti la alt angajat?");
                                String answer = input.next();
                                if (answer.equals("DA")) {
                                    int ok = 0;
                                    for (int i = 1; i <= max; i++) {
                                        if (b.verificare_index(i, z) == 1) {
                                            Random rand = new Random();
                                            int rand_int = 1 + rand.nextInt(59);
                                            z.setMecanic(i);
                                            z.SetTimp(rand_int);
                                            Timp = Timp + 5;
                                            b.trece_timpul(5);
                                            b.actualizare();
                                            ok = 1;
                                            break;
                                        }
                                    }
                                    if (ok == 0) {
                                        System.out.println("Nu mai sunt angajati liberi");
                                        z.setMecanic(-1);
                                    }
                                } else {
                                    System.out.println("Comanda dumneavoastra a fost anulata");
                                    z.setMecanic(-3);
                                }
                            }
                        }
                    } else {
                        int ok = 0;
                        int max = Angajat.getID_static();
                        for (int i = 1; i <= max; i++) {
                            if (b.verificare_index(i, z) == 1) {
                                Random rand = new Random();
                                int rand_int = 1 + rand.nextInt(59);
                                z.setMecanic(i);
                                z.SetTimp(rand_int);
                                Timp = Timp + 5;
                                b.trece_timpul(5);
                                b.actualizare();
                                ok = 1;
                                break;
                            }
                        }
                        if (ok == 0) {
                            z.setMecanic(-1);
                        }
                    }
                }
                System.out.println("Tip" + "    " +   "Status_comanda" + "  " + "Timp_de_asteptare" + "      " + "ID_Masina");
                b.afisare();
            }
            if (command.equals("STATUS_COMENZI")) {
                known = true;
                System.out.println("Tip" + "    " +   "Status_comanda" + "  " + "Timp_de_asteptare" + "      " + "ID_Masina");
                b.afisare();
            }
            if (command.equals("DUPA")) {
                known = true;
                int index = input.nextInt();
                Timp = Timp + index;
                b.trece_timpul(index);
                b.actualizare();
            }
            if ( command.equals("CALCULARE_POLITA")) {
                known = true;
                String type = input.next();
                int index = input.nextInt();
                if ( Masina.getID_static() >= index ) {
                    System.out.println( b.calculare_polita(index, type) );
                }
                else System.out.println("Nu exista acesta masina");
            }
            if (!known)
                System.out.println("Comanda nerecunoscuta");
            command = input.next();
        }

    }
}