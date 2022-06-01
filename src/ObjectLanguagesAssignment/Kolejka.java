package ObjectLanguagesAssignment;

/**
 * C03E01_Catching_errors()
 * zmodyfikuj tak, aby w funkcji main można było przechwytywać wyjątki przepełnienia
 * (próba dodania, gdy liczba elementów w kolejce wynosi N) i niedomiaru kolejki
 * (próba pobrania elementu kolejki, gdy liczbaelementów w kolejce wynosi 0):
 */
public class Kolejka {
       static final int N = 5;
       private Object[] tab;
       private int pocz, zaost, lbel;
       public Kolejka() {
              pocz=0; zaost=0; lbel=0;
              tab = new Object[N];
       }

       void doKolejki(Object el) throws Przepelnienie {
              if (lbel==5) {throw new Przepelnienie();};
              tab[zaost] = el;
              zaost = (zaost+1) % N;
              ++lbel;
       }

       Object zKolejki() throws Niedomiar {
              if (lbel==0) {throw new Niedomiar();};
              int ind = pocz;
              pocz = (pocz+1) % N;
              --lbel;
              return tab[ind];
       }
}

