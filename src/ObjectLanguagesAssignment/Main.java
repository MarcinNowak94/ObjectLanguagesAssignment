package ObjectLanguagesAssignment;

import javax.swing.JOptionPane;
import java.math.BigInteger;
import java.util.Random;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Assignments source:
 * https://www.dropbox.com/sh/w6rd2uyodkapzqg/AADhjwYfw6KSlRtO56e4Ngzta?preview=ZadaniaJava3Inz.pdf
 * */

public class Main {
    public static void C01_expressions_instructions_methods(){
        C01E01_DialogBoxes();
        C01E02_BigFactorial();
        C01E03_SumOdd();
        C01E04_BitwiseOperators();
    }
    public static void C02_Classes_and_Objects(){
        C02E01_Rational();
        C02E02_Quadratic_formula();
        C02E03_Class_Hierarchy();
    }
    public static void C03_Error_handling(){
        C03E01_Catching_errors();
        C03E02_Adding_error_handling();
    }
    //Noncompulsory apparently
    public static void C04_Streams(){
        C04E01_Text_editor();
        C04E02_GZIP();
    }
    public static void C05_Containers(){
        C05E01_Wspolrzedna_TreeSet();
        C05E02_Wspolrzedna_hashmap();
        C05E03_Graf_toString();
    }
    //Noncompulsory
    public static void C06_Multithreading(){
        C06E01_Character_swap();
        C06E02_HashMap_multithreaded();
    }
    //Noncompulsory
    public static void C07_Network_Programming(){
        C07E01_NTP_communicator();
        C07E02_Minesweeper_server();
    }

    public static void C01E01_DialogBoxes(){
        /**
         * Okna dialogowe są wygodnym sposobem interakcji programu z użytkownikiem. Kilka specjalizowanych rodzajów
         * dialogów pozwala na wyświetlanie komunikatów, wprowadzanie danych czy uzyskiwanie potwierdzeń wykonywanych
         * czynności od użytkownika. Do wyświetlania dialogów służą statyczne metody showXXXDialog z klasy JOptionPane
         * pakietu javax.swing. Jest ich dość dużo, ze względu na bogate możliwościkonfiguracji wyglądu i zachowań
         * dialogów. Napisz program, który:
         *  1.za pomocą okna dialogowego pobierze od użytkownika łańcuch znakowy,
         *  2.zamieni w nim małe litery na wielkie,
         *  3.wyświetli wynik w dialogowym oknie informacyjnym.
         *
         * Wskazówki
         * •Do wyświetlania okna dialogowego pozwalającego na wprowadzeniedanych służy przeciążona, statyczna metoda
         *  showInputDialog()z klasy JOptionPane.
         * •Do zamiany małych liter na wielkie służy metoda toUpperCase()z klasy String. Zwraca ona nowy obiekt
         *  (nie modyfikuje źródła)!
         * •Do wyświetlenia okna informacyjnego służy statyczna, przeciążonametoda klasy JOptionPaneo nazwie
         *  showMessageDialog().
         * •Spośród wielu wariantów metod przeciążonych należy wybrać teo najmniejszej liczbie parametrów. Wykorzystują
         *  one domyślnewartości dla konfigurowalnych cech dialogów (np. ikona, tytuł).
         * •Programy korzystające z okien biblioteki Swing(w szczególności korzystające z dialogów wyświetlanych przez
         *  metody klasyJOptionPane) należy kończyć wywołując metodę System.exit(int).
         */
        String user_text= JOptionPane.showInputDialog(
                null,
                "Input sample text"
        );
        user_text=user_text.toUpperCase();
        JOptionPane.showMessageDialog(
                null,
                user_text
        );
    }
    public static void C01E02_BigFactorial(){
        /**
         * Korzystając z klasy BigInteger napisać program który wyznacza silnię z podanej liczby całkowitej n
         * nawet dla dużych n(rzędu kilkuset).
         */
        String returntext;
        returntext =JOptionPane.showInputDialog(
                null,
                "Input number You want to factor"
        );
        BigInteger number= new BigInteger(returntext);
        BigInteger result= BigInteger.ONE;

        for (BigInteger i= BigInteger.ONE;
             i.compareTo(number)!=1;                        //calculation has to contain i=number as well
             i=i.add(BigInteger.ONE) ){
            result=result.multiply(i);
        }

        JOptionPane.showMessageDialog(
                null,
                "Result: "+number+"!= "+result,
                "Whoah ;___;",
                JOptionPane.INFORMATION_MESSAGE             //if type is not present title cannot be set
        );
    }
    public static void C01E03_SumOdd(){
        /**
         * Napisać program sumujący liczby nieparzyste z przedziału od 1 do n,gdzie n podaje użytkownik na starcie
         * programu. Program powinien zakończyć sumowanie na liczbie n, gdy liczba n jest nieparzysta lub na liczbie
         * n − 1, gdy liczba n jest parzysta.
         */
        String userNumber;
        userNumber=JOptionPane.showInputDialog(
                null,
                "Input n:",
                "Input",
                JOptionPane.INFORMATION_MESSAGE
        );
        BigInteger n= new BigInteger(userNumber);
        BigInteger end_at;
        BigInteger result = new BigInteger("0");
        end_at=(n.testBit(1))?n.subtract(BigInteger.ONE):n;

        for (BigInteger number= BigInteger.ONE;
            number.compareTo(end_at)!=1;
            number=number.add(BigInteger.TWO)
        ){
            result=result.add(number);
        }

        JOptionPane.showMessageDialog(
                null,
                "Sum of odd numbers (1,"+n+")="+result,
                "Result",
                JOptionPane.INFORMATION_MESSAGE
        );

    }
    public static void C01E04_BitwiseOperators(){
        /**
         * Operatory bitowe pozwalają traktować zmienne typów całkowitoliczbowych jak
         * zestawy bitów i wykonywać na nich operacje. Oprócz bitowych odpowiedników
         * operatorów logicznych (alternatywa, koniunkcja, negacja) dostępne są również
         * operatory przesunięcia. Ich działanie polega naprzesunięciu całego zestawu bitów o
         * zadaną pozycję w lewo lub w prawo(część bitów zostanie utrącona, a wolne miejsca
         * wypełnione 0 lub 1).Operatory bitowe stosuje się rzadko, głównie do kodowania w
         * zwartysposób binarnych informacji w postaci tzw. flag, które można badać za
         * pomocą tzw. masek (są to zmienne typów całkowitoliczbowych z określonymi bitami
         * ustalonymina 1, a pozostałymi na 0). Chcemy mieć metody, które zmieniają liczbę na
         * napis ją reprezentujący w zadanym systemie liczenia (binarny, ósemkowy, szesnastkowy).
         * Aby uprościć zadanie, ograniczymy się do liczb nieujemnych. Zatem należy zaimplementować
         * trzy metody pobierające jako argument liczbę całkowitątypu inti zwracającą łańcuch znakowy
         * (obiekt klasy String) będący:
         *  1. binarną reprezentacją argumentu,
         *  2. ósemkową reprezentacją argumentu,
         *  3. szesnastkową reprezentacją argumentu.
         *  Wskazówki
         *  • Można skorzystać z operatorów bitowych przesunięcia w prawo i koniunkcji.
         *  • Można skorzystać z operatorów dzielenia oraz reszty z dzielenia (/,%).
         *
         *
         */
        String input;
        input= JOptionPane.showInputDialog(
                null,
                "Input number, to be represented in different base"
        );
        int number= Integer.parseInt(input);
        String[] binary={"0","1"};
        String[] octal={"0","1","2","3","4","5","6","7","8"};
        String[] hexadecimal={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

        JOptionPane.showMessageDialog(
                null,
                ("Result: "+number+" representation in:"+
                        "\nBinary:             "+num_to_base(number, 2, binary)+
                        "\nOctal:               "+num_to_base(number, 8, octal)+
                        "\nHexadecimal: "+num_to_base(number, 16, hexadecimal))
        );
    }

    public static void C02E01_Rational(){
        /**
         * Zaprojektuj klasę Rational, reprezentującą liczby wymierne jako pary liczb
         * całkowitych (licznik i mianownik), wraz z podstawowymi działaniami arytmetycznymi
         * i porównaniem. W klasie powinny znaleźć się następujące metody publiczne (oprócz konstruktora):
         * 1. dodawanie: Rational add(Rational arg);
         * 2. mnożenie: Rational mul(Rational arg);
         * 3. odejmowanie: Rational sub(Rational arg);
         * 4. dzielenie: Rational div(Rational arg);
         * 5. równość: boolean equals(Rational arg);
         * 6. porównanie: int compareTo(Rational arg);
         * 7. tekstowa reprezentacja liczby: String toString().
         *
         * Metody 1–4 powinny zwracać jako rezultat referencję do nowego obiektu klasy
         * Rational, będącego wynikiem operacji wykonanej na argumencie argi this. Metoda
         * 5. ma porównywać obiekty klasy Rationalnapodstawie wartości liczb, np. 1/2 = 2/4.
         * Metoda 6. ma działać podobnie, jak odpowiadająca jej metoda compareTo(Object o)z interfejsu
         *
         * Java.lang.Comparable:
         * •Jeśli thisjest równe arg, to zwraca 0.
         * •Jeśli thisjest mniejsze od arg, to zwraca −1.
         * •Jeśli this jest większe niż arg, to zwraca 1.
         * Metoda 7. mazwracać łańcuch znakowy opisujący ten obiekt. Na przykład może to
         * być napis postaci 1/2 lub -1/1.
         */
        C02E01_Rational rational1 = new C02E01_Rational(2,1);
        C02E01_Rational rational2 = new C02E01_Rational("3/7").mul(rational1);
        C02E01_Rational rational3 = new C02E01_Rational();
        rational3.setMy_numerator(6);
        rational3.setMy_denominator(14);

        //Check equality
        String message = rational2.toString()+" and "+rational3.toString()+" are";
        System.out.println(rational2.equals(rational3)==TRUE?(message+" equal"):(message+" not equal"));

        message = rational1.toString()+" and "+rational3.toString()+" are";
        System.out.println(rational1.equals(rational3)==TRUE?(message+" equal"):(message+" not equal"));

        switch (rational1.compareTo(rational2)){
            case 1: System.out.println(rational1.toString()+" is bigger than "+rational2.toString() ); break;
            case 0: System.out.println(rational1.toString()+" is equal to "+rational2.toString() ); break;
            case -1: System.out.println(rational1.toString()+" is lower than "+rational2.toString() ); break;
            default: System.out.println("Comparison error"); break;
        }

        System.out.println(rational1.toString()+" + "+rational2.toString()+" = "+rational1.add(rational2) );
        System.out.println(rational1.toString()+" - "+rational2.toString()+" = "+rational1.sub(rational2) );
        System.out.println(rational1.toString()+" * "+rational2.toString()+" = "+rational1.mul(rational2) );
        System.out.println(rational1.toString()+" / "+rational2.toString()+" = "+rational1.div(rational2) );

    }
    public static void C02E02_Quadratic_formula(){
        /**
         * Napisz klasę opisującą równanie kwadratowe o postaci y = ax2+ bx +c. Współczynniki
         * a, b i c powinny być prywatne. Zdefiniuj następujące publiczne funkcje składowe:
         * •nadającą wartości współczynnikom,
         * •obliczającą y dla podanego x,
         * •wyznaczającą liczbę pierwiastków.
         * Potrzebne wzory:
         * •delta: d = b2−4ac,
         * •liczba pierwiastków: p =0 : d < 0,1 : d = 0,2 : d > 0.
         */
        //String formula="x2+x";
        String formulas[]={"2x2+4x+7", "-200x2+47.67x+7.6","-4x2+x-1", "x2+x"};

        for (String formula: formulas) {
            Random rand= new Random();
            Double randx= rand.nextDouble();
            try{
                C02E02_Quadratic_formula formula1 = new C02E02_Quadratic_formula(formula);
                Double solution[] = new Double[2];
                solution= formula1.solveX0();
                System.out.print(formula+" parsed to"
                        +"\na:\t"+formula1.getA()
                        +"\nb:\t"+formula1.getB()
                        +"\nc:\t"+formula1.getC()
                        +"\nDelta equal: "+formula1.getDelta()
                        +"\nWith x="+randx+" y="+formula1.solveY(randx)
                        +"\nSolutions:\t"+formula1.solutions()
                        +"\nSolution1:\t"+solution[0]+"; solution2:\t"+solution[1]
                        +"\n\n"
                );
            }
            catch (Exception ex){
                System.out.println(ex.toString());
            }
        }

    }
    public static void C02E03_Class_Hierarchy(){
        /**
         * Zdefiniuj poniższą hierarchię klas
         *
         *  Klasa Wielomian złożona z klas: FunkcjaLiniowa i FunkcjaKwadratowa
         *
         *  tak, aby w wyniku wykonania programu:
         *  public class Zadanie {
         *      public static void main(String[] args) {
         *          Wielomian w[] = new Wielomian[3];
         *          w[0] = new FunkcjaLiniowa(2, 1); // 2x + 1
         *          w[1] = new FunkcjaKwadratowa(1, -2, 2); // x*x -2x + 2
         *          w[2]= new FunkcjaKwadratowa(1, 0, -1); // x*x -1
         *          for (int i=0; i<3; i++) {
         *              w[i].wypiszMiejscaZerowe();
         *              }
         *          }
         * }
         *
         * na ekranie pojawił się wynik:
         * -0.5
         * brak
         * -1 1
         *
         * Wskazówka: Wielomian może być klasą abstrakcyjną lub nawet interfejsem
         */
        Wielomian w[] = new Wielomian[3];
              w[0] = new FunkcjaLiniowa(2, 1); // 2x + 1
              w[1] = new FunkcjaKwadratowa(1, -2, 2); // x*x -2x + 2
               w[2]= new FunkcjaKwadratowa(1, 0, -1); // x*x -1
               for (int i=0; i<3; i++) {
                   w[i].wypiszMiejscaZerowe();
                  }
    }

    public static void C03E01_Catching_errors(){
        /**
         * Poniższy program:
         * class Kolejka {
         *      static final int N = 5;
         *      private Object[] tab;
         *      private int pocz, zaost, lbel;
         *      public Kolejka() {
         *          pocz=0; zaost=0; lbel=0;
         *          tab = new Object[N];
         *          }
         *
         *      void doKolejki(Object el) {
         *          tab[zaost] = el;
         *          zaost = (zaost+1) % N;
         *          ++lbel;
         *      }
         *
         *      Object zKolejki() {
         *          int ind = pocz;
         *          pocz = (pocz+1) % N;
         *          --lbel;
         *          return tab[ind];
         *      }
         * }
         *
         * public class Zadanie {
         *      public static void main(String[] args) {
         *          Kolejka k = new Kolejka();
         *          k.doKolejki(new Integer(7));
         *          k.doKolejki(new String("Ala ma kota"));
         *          k.doKolejki(new Double(3.14));
         *          for (int i=1; i<=3; ++i)
         *              System.out.println((k.zKolejki()).toString());
         *      }
         * }
         *
         * zmodyfikuj tak, aby w funkcji main można było przechwytywać wyjątki przepełnienia
         * (próba dodania, gdy liczba elementów w kolejce wynosi N) i niedomiaru kolejki
         * (próba pobrania elementu kolejki, gdy liczbaelementów w kolejce wynosi 0):
         *
         * public static void main(String[] args) {
         *      Kolejka k = new Kolejka();
         *      try {
         *          k.doKolejki(new Integer(7));
         *          k.doKolejki(new String("Ala ma kota"));
         *          k.doKolejki(new Double(3.14));
         *          for (int i=1; i<=4; ++i)
         *              System.out.println((k.zKolejki()).toString());
         *      }
         *      catch (Przepelnienie e) {
         *          System.out.println("Przepełniona kolejka!");
         *      }
         *      catch (Niedomiar e) {
         *          System.out.println("Pusta kolejka!");
         *      }
         *  }
         */
        Kolejka k = new Kolejka();
        try {
            k.doKolejki(new Integer(7));
            k.doKolejki(new String("Ala ma kota"));
            k.doKolejki(new Double(3.14));
            for (int i=1; i<=4; ++i)
                System.out.println((k.zKolejki()).toString());
        }
        catch (Przepelnienie e) {
            System.out.println("Przepełniona kolejka!");
        }
        catch (Niedomiar e) {
            System.out.println("Pusta kolejka!");
        }
    }
    public static void C03E02_Adding_error_handling(){
        /**
         * Wiadomo, że wyrażenie arytmetyczne może być reprezentowane za pomocą drzewa binarnego.
         * Wierzchołki wewnętrzne takiego drzewa reprezentują działanie, natomiast liście reprezentują stałe.
         * Na przykład wyrażeniu(3 ∗((1 + 2) − 1)) odpowiada następujące drzewo:
         * //graf przykłądowego drzewa//
         * W poniższym programie:
         *
         * abstract class Wierzcholek {
         *      Wierzcholek lewy, prawy;
         *      public abstract int wartosc();
         * }
         * class Stala extends Wierzcholek {
         *      private int wart;
         *      public Stala(int x) {
         *          wart = x;
         *      }
         *      public int wartosc() {
         *          return wart;
         *      }
         * }
         * class Dzialanie extends Wierzcholek {
         *      private char op; // operator +, -, / lub *
         *      public Dzialanie(char znak) {
         *          op = znak;
         *      }
         *      public void dodajLewyArg(Wierzcholek arg) {
         *          lewy = arg;
         *      }
         *      public void dodajPrawyArg(Wierzcholek arg) {
         *          prawy = arg;
         *      }
         *      public int wartosc() {
         *          switch (op) {
         *              case ’+’: return lewy.wartosc() + prawy.wartosc();
         *              case ’-’: return lewy.wartosc() - prawy.wartosc();
         *              case ’/’: return lewy.wartosc() / prawy.wartosc();
         *              case ’*’: return lewy.wartosc() * prawy.wartosc();
         *          }
         *          return 0;
         *      }
         * }
         * class Wyrazenie {
         *      private Wierzcholek korzen;
         *      privateWierzcholek utworzDrzewo(String w, int p, int q) {
         *          if (p == q)
         *              return new Stala(Character.digit(w.charAt(p), 10));
         *          else {
         *              int i = p+1, nawiasy = 0;
         *              while ( (nawiasy != 0) || (w.charAt(i) == ’(’) ||(w.charAt(i) == ’)’) ||
         *                      (Character.isDigit(w.charAt(i)))) {
         *                          if (w.charAt(i) == ’(’) ++nawiasy;
         *                          if (w.charAt(i) == ’)’) --nawiasy;
         *                          ++i;
         *              }
         *              Dzialanie nowy = new Dzialanie(w.charAt(i));
         *              nowy.dodajLewyArg(utworzDrzewo(w, p+1, i-1));
         *              nowy.dodajPrawyArg(utworzDrzewo(w, i+1, q-1));
         *              return nowy;
         *         }
         *     }
         *     public Wyrazenie(String w) {
         *          korzen = utworzDrzewo(w, 0, w.length()-1);
         *     }
         *     public int oblicz() {
         *          return korzen.wartosc();
         *     }
         * }
         * public class Zadanie {
         *      public static void main(String[] args) {
         *          Wyrazenie wyr = new Wyrazenie("(3*((1+2)-1))");
         *          System.out.println("" + wyr.oblicz());
         *      }
         * }
         *
         * stworzono hierarchię klas:
         * Klasa wierzchołek złożona z klas: klasa Stała i klasa Działanie
         * a następnie zaimplementowano klasę Wyrazenie, której metoda oblicz() zwraca
         * wartość podanego wyrażenia. Zakładamy, że konstruktor akceptuje wyrażenia
         * arytmetyczne skonstruowane zgodnie z gramatyką:
         *  <wyrażenie> ::= (<wyrażenie><działanie><wyrażenie>)
         *  <wyrażenie> ::= <stała>
         *  <działanie> ::= + | -| / | *
         *  <stała> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
         *
         * Uzupełnij przytoczony program o obsługę następujących wyjątków:
         *  •dzielenie przez zero,
         *  •niepoprawnie skonstruowane wyrażenie.
         */
    }

    public static void C04E01_Text_editor(){
        /**
         * Napisz prosty edytor tekstowy, w którym będzie możliwość zapisywaniatekstu do pliku w jednym z wybranych
         * standardów kodowania znaków:UTF-8, ISO-8859-2 lub windows-1250.
         * Wskazówki:
         *  •Skorzystaj z klas OutputStreamWriter oraz FileOutputStream.
         *  •Łańcuchami reprezentującymi wymienione standardy kodowaniaznaków są: UTF8, ISO8859 2 oraz Cp1250.
         */
    }
    public static void C04E02_GZIP(){
        /**
         * Napisz program kompresujący plik do formatu GZIP oraz program rozpakowujący plik GZIP.
         * Wskazówka •Skorzystaj z klas GZIPOutputStreamoraz GZIPInputStream.
          */
    }

    public static void C05E01_Wspolrzedna_TreeSet(){
        /**
         * Dostosuj poniższą klasę:
         * class Wspolrzedna {
         *      private int x, y;
         *      public Wspolrzedna(int _x, int _y) {
         *          x = _x;
         *          y = _y;
         *      }
         *      public String toString() {
         *          return "(" + x + ", " + y + ")";
         *      }
         * }
         *
         * do wymagań stawianych wobec elementów dodawanych do kontenera TreeSet,
         * tak aby w wyniku wykonania programu:
         * import java.util.*;
         * //Tu wstaw zmodyfikowaną klasę przechowującą współrzędne punktu
         * public class Zadanie {
         *      private static void wypiszElementy(TreeSet zbior) {
         *          Iterator it = zbior.iterator();
         *          while (it.hasNext()) {
         *              System.out.println((it.next()).toString());
         *          }
         *      }
         *      public static void main(String[] args) {
         *          TreeSet zbior = new TreeSet();
         *          zbior.add( new Wspolrzedna(2, 3) );
         *          zbior.add( new Wspolrzedna(-3, 0) );
         *          zbior.add( new Wspolrzedna(-1, 2) );
         *          zbior.add( new Wspolrzedna(-1, 2) );
         *          zbior.add( new Wspolrzedna(-3, -2) );
         *          wypiszElementy(zbior);
         *      }
         * }
         *
         * punkty zbioru TreeSetbyły wyświetlone na ekranie w kolejności leksykograficznej
         * (czyli (−3, −2), (−3, 0), (−1, 2), (2, 3)).
         * Wskazówka•Klasa Wspolrzednapowinna implementować interfejs Comparable
         */
    }
    public static void C05E02_Wspolrzedna_hashmap(){
        /**
         * Dostosuj klasę Wspolrzednaz poprzedniego zadania do wymagań stawianych wobec elementów dodawanych
         * do kontenera HashMap. Wówczasw wyniku wykonania programu:
         * import java.util.*;
         * //Tu wstaw zmodyfikowaną klasę przechowującą współrzędne punktu
         * public class Zadanie {
         *      public static void main(String[] args) {
         *          HashMap mapa = new HashMap();
         *          mapa.put(new Wspolrzedna(2, 3), new String("czerwony"));
         *          mapa.put(new Wspolrzedna(-3, 0), new String("czarny"));
         *          mapa.put(new Wspolrzedna(-1, 2), new String("czerwony"));
         *          mapa.put(new Wspolrzedna(2, -1), new String("czarny"));
         *          Wspolrzedna w = new Wspolrzedna(-1, 2);
         *          System.out.println("Punkt " + w.toString()+ " ma kolor " + mapa.get(w));
         *      }
         * }
         *
         * na ekranie zostanie wyświetlony tekst:
         * Punkt (-1, 2) ma kolor czerwony
         *
         * Wskazówka•Klasa Wspolrzednapowinna przesłonić metody hashCode oraz equals.
         */
    }
    public static void C05E03_Graf_toString(){
        /**
         * W poniższej klasie Graf:
         * import java.util.*;
         * class Graf {
         *      private int n; // liczba wierzchołków, V = {0,1,...,n-1}
         *      private LinkedList[] tab; // tablica wierzchołków połączonych z danym wierzcholkiem
         *      public Graf(String lan) {
         *          StringTokenizer st = new StringTokenizer(lan, "() ,");
         *          n = Integer.parseInt(st.nextToken());
         *          tab = new LinkedList[n];
         *          for (int i=0; i<n; ++i)
         *              tab[i] = new LinkedList();
         *          while (st.hasMoreTokens()) {
         *              tab[Integer.parseInt(st.nextToken())].add(new Integer(st.nextToken()));
         *          }
         *      }
         *      public String toString() {
         *      ...
         *      }
         * }
         * public class Zadanie {
         *      public static void main(String[] args) {
         *          Graf g = new Graf("4, (0,1), (1,2), (3,0), (1,3)");
         *          System.out.println(g.toString());
         *      }
         * }
         *
         * zdefiniuj metodę toStringw taki sposób, aby graf był przedstawiany jako tablica
         * ciągów wierzchołków połączonych z kolejnymi wierzchołkamigrafu skierowanego:
         * 0: 1
         * 1: 2 3
         * 2:
         * 3: 0
         * Wskazówki
         * • W celu wielokrotnego dołączania łańcucha (lub liczby) na końcuinnego łańcucha
         *   najlepiej skorzystać z klasy StringBufferi jej metody append.
         * •Przejście do nowego wiersza realizujemy dołączając do łańcuchasekwencję sterującą "\n".
         */
    }

    public static void C06E01_Character_swap(){
        /**
         * W poniższym programie użytkownik ma możliwość wprowadzania tekstu do okienka.
         * Działający w programie wątek zamienia we wpisywanym tekście wystąpienie znaku
         * klamry otwierającej na słowo beginoraz znakuklamry zamykającej na słowo end.
         *
         * import java.awt.*;
         * import java.awt.event.*;
         * import javax.swing.*;
         *
         * class Zamieniacz extends Thread {
         *      JTextArea okno;
         *      volatile boolean zakonczyc;
         *      public Zamieniacz(JTextArea comp) {
         *          okno = comp;
         *          zakonczyc = false;
         *      }
         *      public void run() {
         *          while (! zakonczyc) {
         *              try {
         *                  String tekst = okno.getText();
         *                  int indeks = tekst.indexOf("{");
         *                  if (indeks >= 0) {
         *                      okno.replaceRange("begin", indeks, indeks+1);
         *                      okno.setCaretPosition(tekst.length()+4);
         *                  }
         *                  else {
         *                      indeks = tekst.indexOf("}");
         *                      if (indeks >=0) {
         *                          okno.replaceRange("end", indeks, indeks+1);
         *                          okno.setCaretPosition(tekst.length()+2);
         *                      }
         *                   }
         *                   sleep(2000);
         *                 }
         *               catch (Exception e) {}
         *          }
         *      }
         * }
         *
         * public class NewJFrame extends JFrame {
         *      public NewJFrame() {
         *          initComponents();
         *          setSize(350, 250);
         *          watek = new Zamieniacz(jTextArea1);
         *          watek.start();
         *      }
         *      private void initComponents() {
         *          jScrollPane1 = new JScrollPane();
         *          jTextArea1 = new JTextArea();
         *          setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         *          addWindowListener(new WindowAdapter() {
         *              public void windowClosing(WindowEvent evt) {
         *                  formWindowClosing(evt);
         *              }
         *          });
         *          jTextArea1.setPreferredSize(new Dimension(300, 200));
         *          jScrollPane1.setViewportView(jTextArea1);
         *          getContentPane().add(jScrollPane1, BorderLayout.CENTER);
         *          pack();
         *      }
         *      private void formWindowClosing(WindowEvent evt) {
         *          watek.zakonczyc = true;
         *          watek =null;
         *      }
         *      public static void main(String args[]) {
         *          EventQueue.invokeLater(new Runnable() {
         *              public void run() {
         *                  new NewJFrame().setVisible(true);
         *              }
         *          });
         *      }
         *      private JScrollPane jScrollPane1;
         *      private JTextArea jTextArea1;
         *      private Zamieniacz watek;
         * }
         *
         * Napisz oraz dodaj do programu wątek sprawdzający co 10 sekund, czy użytkownik wprowadził do okienka
         * tekstowego słowo niecenzuralne (np.„cholera”) i informujący o tym fakcie za pomocą odpowiedniego
         * komunikatu przekazanego do metody JOptionPane.showMessageDialog().
         */

    }
    public static void C06E02_HashMap_multithreaded(){
        /**
         * W poniższym programie zdefiniowano klasę KolejkaKomunikatow, doktórej może
         * odwoływać się kilka wątków naraz.
         *
         * import java.util.*;
         * class KolejkaKomunikatow {
         *      Vector kolejka = new Vector();
         *      public synchronized void wyslij(Object ob) {
         *          kolejka.addElement(ob);
         *      }
         *      public synchronized Object odbierz() {
         *          if (kolejka.size() == 0) return null;
         *          Object ob = kolejka.firstElement();
         *          kolejka.removeElementAt(0);return ob;
         *      }
         * }
         * class Watek extends Thread {
         *      private KolejkaKomunikatow koko;
         *      private int istart;
         *      public Watek(KolejkaKomunikatow kk, int pocz) {
         *          koko = kk;
         *          istart = pocz;
         *      }
         *      public void run() {
         *          try {
         *              for (int i=istart; i<=10; i+=2) {
         *                  koko.wyslij(new Integer(i));
         *                  Thread.sleep(50);
         *              }
         *          }
         *          catch (InterruptedException e) {};
         *      }
         * }
         * public class Zadanie {
         *      public static void main(String args[]) {
         *          KolejkaKomunikatow k = new KolejkaKomunikatow();
         *          Watek w1 = new Watek(k, 1);
         *          Watek w2 = new Watek(k, 2);
         *          w1.start();
         *          w2.start();
         *          try {
         *              w1.join();
         *              //Poniższa linijka znalazła się chyba w materiale oryginalnym przez pomyłkę
         *              14 Zbiór zadań do przedmiotu programowanie obiektowe
         *              w2.join();
         *          }
         *          catch (InterruptedException e) {};
         *          Object ob = k.odbierz();
         *          while (k != null) {
         *              System.out.println(((Integer)ob).toString());
         *              ob = k.odbierz();
         *          }
         *      }
         * }
         *
         * Zaimplementuj w podobny sposób odwoływanie się przez wątki do klasy HashMap
         * (klucz może być obiektem klasy String, a wartość obiektemklasy Integer).
         */
    }

    public static void C07E01_NTP_communicator(){
        /**
         * Poniższy program łączy się z podanym (jako parametr wywołania) „daytime”
         * serwerem na porcie 13, a następnie odczytuje komunikat wysyłanyprzez serwer.
         *
         * import java.net.*;
         * import java.io.*;
         * public class Zadanie {
         *      public static void main(String[] args) {
         *          String nazwahosta;
         *          if (args.length > 0) {
         *              nazwahosta = args[0];
         *          }
         *          else {
         *              nazwahosta = "time-a.nist.gov";
         *          }
         *          try {
         *              Socket gniazdo = new Socket(nazwahosta, 13);
         *              InputStream strumien = gniazdo.getInputStream();
         *              BufferedReader bufor = new BufferedReader(
         *                  new InputStreamReader(strumien));
         *              String wiersz = "";
         *              while (wiersz != null) {
         *                  System.out.println(wiersz);
         *                  wiersz = bufor.readLine();
         *              }
         *          }
         *          catch (UnknownHostException e) {
         *              System.err.println(e);
         *          }
         *          catch (IOException e) {
         *              System.err.println(e);
         *          }
         *     }
         * }
         *
         * Listę wybranych serwerów podających aktualną datę i czas przedstawiono poniżej:
         *  •time-a.nist.gov
         *  •time-b.nist.gov
         *  •time-nw.nist.gov
         *  •time.windows.com
         *  Po połączeniu się z jednym z nich przez port 37 wysyła on 32 bity reprezentujące
         *  liczbę sekund, które upłynęły od północy 1 stycznia 1900 r. Napisz program odczytujący tę liczbę.
         *  Wskazówki
         *  •Skorzystaj z metody read()klasy InputStream.
         *  •Cztery bajty zamień na liczbę typu long za pomocą operatorów <<oraz |
         */
    }
    public static void C07E02_Minesweeper_server(){
        /**
         * Rozważmy następujący program-serwer.
         *
         * import java.net.*;
         * import java.io.*;
         * class Gracz implements Runnable {
         *      private int plansza[][];// liczba >= 100 to mina, 0, 1, ..., 8 --ile wokól min
         *      private boolean klikniete[][];
         *      private PrintWriter out;
         *      private BufferedReader in;
         *      private Socket polaczenie;
         *      private void InicjujPlansze() {
         *          plansza = new int[11][11];
         *          klikniete = new boolean[11][11];
         *          int w, k, licznik;
         *          licznik = 0;
         *          while (licznik < 10) {
         *              w = (int)(Math.random()*9) + 1;
         *              k = (int)(Math.random()*9) + 1;
         *              if (plansza[w][k] < 100) {
         *                  ++licznik;
         *                  plansza[w][k] = 100;
         *                  ++plansza[w-1][k-1];
         *                  ++plansza[w-1][k];
         *                  ++plansza[w-1][k+1];
         *                  ++plansza[w][k-1];
         *                  ++plansza[w][k+1];
         *                  ++plansza[w+1][k-1];
         *                  ++plansza[w+1][k];
         *                  ++plansza[w+1][k+1];
         *              }
         *          }
         *     }
         *     public Gracz(Socket polaczenie) {
         *          InicjujPlansze();
         *          this.polaczenie = polaczenie;
         *          try {
         *              out = new PrintWriter(polaczenie.getOutputStream(), true);
         *              in = new BufferedReader(new InputStreamReader(polaczenie.getInputStream()));
         *          }
         *          catch (IOException e) {
         *              System.out.println(e.toString());
         *          }
         *     }
         *     public void run() {
         *          int w, k, odkryte, liczba;
         *          String wsp, odp;
         *          boolean koniec = false;
         *          odkryte=0;
         *          try {
         *              out.println("OK.");
         *              while ((!koniec) && (odkryte<71)) {
         *                  wsp = in.readLine();
         *                  if (wsp == null) koniec = true;
         *                  else {
         *                      try {
         *                          liczba = Integer.parseInt(wsp);
         *                          w = (int)((liczba-1)/9) + 1;
         *                          k = (liczba-1) % 9 + 1;
         *                      }
         *                      catch (NumberFormatException e) {
         *                          w = 200;k = 200;
         *                      }
         *                      if ((w>=1) && (w<=9) && (k>=1) && (k<=9)) {
         *                          if (plansza[w][k] >= 100) {
         *                              out.println("bum");
         *                              koniec = true;
         *                          }
         *                          else {
         *                              out.println(Integer.toString(plansza[w][k]));
         *                              if (!klikniete[w][k]) ++odkryte;
         *                          }
         *                          klikniete[w][k] = true;
         *                      }
         *                 }
         *             }
         *         }
         *         catch (IOException e) {
         *              System.out.println(e.toString());
         *         }
         *         finally {
         *              try {
         *                  polaczenie.close();
         *              }
         *              catch (IOException e) {}
         *         }
         *     }
         * }
         *
         * public class Serwer {
         *      public static void main(String[] args) {
         *          ServerSocket server;
         *          try {
         *              server = new ServerSocket(9696);
         *              while(true) {
         *                  Socket polaczenie = server.accept();
         *                  Thread t = new Thread(new Gracz(polaczenie));
         *                  t.start();
         *              }
         *          }
         *          catch (IOException e) {
         *              System.out.println(e.toString());
         *          }
         *      }
         * }
         *
         * Jest to program, który dla każdego klienta, który się z nim połączy generuje pole
         * minowe znane z windowsowej gry „Saper”. Numerację pól tegopola przedstawiono na poniższym rysunku:
         *      //tablica 9x9 z liczbami 1-81
         * Serwer na tym polu rozmieszcza losowo 10 min. Na każdym polu wolnymod miny
         * umieszcza liczbę od 0 do 8 określającą ile min jest wokół niego.Napisz klienta,który:
         * 1.połączy się z serwerem przez port 9696;
         * 2.odbierze wiersz tekstu (słowo „OK.”);
         * w pętli, do momentu „odkrycia” wszystkich 71 wolnych pól lubnatrafienia na minę
         * (serwer wtedy odpowiada „bum”), będzie przesyłał serwerowi liczbę x (jako String)
         * podaną przez użytkownikai odbierał od serwera liczbę (również jako String)
         * określającą ilejest min wokół pola x.
         */
    }

    //returns integer in given base, represented by characters in given map
    public static String num_to_base(int number, int base, String[] representation){
        String temp="";
        String result="";
        String digit="";

        while (number>0){
            temp=temp+representation[number%base];
            number=number/base;
        }
        //now reverse string
        for (int i=temp.length()-1; i>=0;i--){
            result=result+temp.charAt(i);
        }
        return result;

    }

    public static void main(String[] args) {
        Integer active_chapter=3;

        switch (active_chapter) {
            case 1: {C01_expressions_instructions_methods();}; break;
            case 2: {C02_Classes_and_Objects();}; break;
            case 3: {C03_Error_handling();}; break;
            case 4: {C04_Streams();}; break;
            case 5: {C05_Containers();}; break;
            case 6: {C06_Multithreading();}; break;
            case 7: {C07_Network_Programming();}; break;
            default: {
                C01_expressions_instructions_methods();
                C02_Classes_and_Objects();
                C03_Error_handling();
                C04_Streams();
                C05_Containers();
                C06_Multithreading();
                C07_Network_Programming();
            }; break;
        }
    }
}
