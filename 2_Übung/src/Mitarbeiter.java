public class Mitarbeiter extends Personal{

    public Mitarbeiter(String name, long personalnummer, String abteilung, String zustaendigkeit, double gehalt){
        this.setName(name);
        this.setPersonalnummer(personalnummer);
        this.setAbteilung(abteilung);
        this.setZustaendigkeit(zustaendigkeit);
        this.setGehalt(gehalt);
    }

    @Override
    public String toString() {
         return
                "Name='" + getName() + '\'' +
                ", Personalnummer=" + getPersonalnummer() + '\'' +
                ", Abteilung='" + getAbteilung() + '\'' +
                ", Zuständigkeit='" + getZustaendigkeit() + '\'' +
                ", Gehalt=" + getGehalt() +
                ((this.getZugeordneteMitarbeiter() != null) ? "\nZugeordnete Mitarbeiter: \n"
                        + this.getZugeordneteMitarbeiter().toString()
                        .replace("[Name", "[\r\n Name")
                        .replace(",", "")
                        + "\n": "\n") ;

    }
}
