package ObjectLanguagesAssignment;

/**
 * C03E02_Adding_error_handling
 */
public class Dzialanie extends Wierzcholek {
    private char op; // operator +, -, / lub *
    public Dzialanie(char znak) {
        op = znak;
    }
    public void dodajLewyArg(Wierzcholek arg) {
        lewy = arg;
    }
    public void dodajPrawyArg(Wierzcholek arg) {
        prawy = arg;
    }
    public int wartosc() throws DzieleniePrzezZero {
        switch (op) {
            case '+': return lewy.wartosc() + prawy.wartosc();
            case '-': return lewy.wartosc() - prawy.wartosc();
            case '/': {
                if (prawy.wartosc()==0) {throw new DzieleniePrzezZero();};
                return lewy.wartosc() / prawy.wartosc();
            }
            case '*': return lewy.wartosc() * prawy.wartosc();
        }
        return 0;
    }
}
