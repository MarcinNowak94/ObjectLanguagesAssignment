package ObjectLanguagesAssignment;

/**
 * C03E02_Adding_error_handling
 */
public class Wyrazenie {
    private Wierzcholek korzen;
    private Wierzcholek utworzDrzewo(String w, int p, int q) throws NiepoprawnieSkonstruowaneWyrazenie{
        if (p>q) {throw new NiepoprawnieSkonstruowaneWyrazenie();};
        if (p == q)
            return new Stala(Character.digit(w.charAt(p), 10));
        else {
            int i = p+1, nawiasy = 0;
            while ( (nawiasy != 0) || (w.charAt(i) == '(') ||
                    (w.charAt(i) == ')') || (Character.isDigit(w.charAt(i)))) {
                if (w.charAt(i) == '(') ++nawiasy;
                if (w.charAt(i) == ')') --nawiasy;
                ++i;
            }
            Dzialanie nowy = new Dzialanie(w.charAt(i));
            nowy.dodajLewyArg(utworzDrzewo(w, p+1, i-1));
            nowy.dodajPrawyArg(utworzDrzewo(w, i+1, q-1));
            return nowy;
        }
    }
    public Wyrazenie(String w) throws NiepoprawnieSkonstruowaneWyrazenie{
        korzen = utworzDrzewo(w, 0, w.length()-1);
    }
    public int oblicz() throws DzieleniePrzezZero {
        return korzen.wartosc();
    }
}
