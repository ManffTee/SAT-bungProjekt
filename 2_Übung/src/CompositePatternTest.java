public class CompositePatternTest {
    public static void main(String[] args) {
        Mitarbeiter manager = new Mitarbeiter("REICH Egon", 258762, "MANAGEMENT", "Geschäftsführung", 40239.39);
        Mitarbeiter medien = new Mitarbeiter("FAUL Lars", 304909, "MEDIEN", "Leiter Medienabteilung", 4020.03);
        Mitarbeiter sach1 = new Mitarbeiter("Schmitt Konrad", 30000, "MEDIEN", "Sachbearbeiter", 2020.0);
        Mitarbeiter sach2 = new Mitarbeiter("Meyer Peter", 32000, "MEDIEN", "Sachbearbeiter", 2000.0);

        manager.addZugeordneteMitarbeiter(medien);
        medien.addZugeordneteMitarbeiter(sach1);
        medien.addZugeordneteMitarbeiter(sach2);

        System.out.println(manager);
    }
}
