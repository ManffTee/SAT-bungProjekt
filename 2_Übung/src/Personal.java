import java.util.LinkedList;
import java.util.List;

public abstract class Personal {
    private String name;
    private long personalnummer;
    private String abteilung;
    private String zustaendigkeit;
    private double gehalt;
    private List<Personal> zugeordneteMitarbeiter;

    public abstract String toString();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPersonalnummer() {
        return personalnummer;
    }

    public void setPersonalnummer(long personalnummer) {
        this.personalnummer = personalnummer;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    public String getZustaendigkeit() {
        return zustaendigkeit;
    }

    public void setZustaendigkeit(String zustaendigkeit) {
        this.zustaendigkeit = zustaendigkeit;
    }

    public double getGehalt() {
        return gehalt;
    }

    public void setGehalt(double gehalt) {
        this.gehalt = gehalt;
    }

    public List<Personal> getZugeordneteMitarbeiter() {
        return zugeordneteMitarbeiter;
    }

    public void addZugeordneteMitarbeiter(Personal personal) {
        if (zugeordneteMitarbeiter == null) {
            zugeordneteMitarbeiter = new LinkedList<Personal>();
        }
        zugeordneteMitarbeiter.add(personal);
    }

    public void setZugeordneteMitarbeiter(List<Personal> zugeordneteMitarbeiter) {
        if(this.zugeordneteMitarbeiter == null) {
            this.zugeordneteMitarbeiter = new LinkedList<Personal>();
        }
        this.zugeordneteMitarbeiter = zugeordneteMitarbeiter;
    }
}
