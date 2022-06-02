package ObjectLanguagesAssignment;

/**
 * C03E02_Adding_error_handling
 */
public abstract class Wierzcholek {
    Wierzcholek lewy, prawy;
    public abstract int wartosc() throws DzieleniePrzezZero;
}
