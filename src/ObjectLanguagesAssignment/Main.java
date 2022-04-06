package ObjectLanguagesAssignment;

/**
 * Source:
 * https://www.dropbox.com/sh/w6rd2uyodkapzqg/AADhjwYfw6KSlRtO56e4Ngzta?preview=ZadaniaJava3Inz.pdf
 *
 * */
public class Main {
    public static void C01_expressions_instructions_methods(){
        C01E01_DialogBoxes();
        C01E02_BigFactorial();
        C01E03_SumUneven();
        C01E04_BitwiseOperators();
    }

    public static void C01E01_DialogBoxes(){
        /**
         * Okna dialogowe są wygodnym sposobem interakcji programu z użytkownikiem. Kilka specjalizowanych rodzajów
         * dialogów pozwala na wyświetlanie komunikatów, wprowadzanie danych czy uzyskiwanie potwierdzeń wykonywanych
         * czynności od użytkownika. Do wyświetlania dialogów służą statyczne metody showXXXDialog z klasy
         * JOption Panepakietu javax.swing. Jest ich dość dużo, ze względu na bogate możliwościkonfiguracji
         * wyglądu i zachowań dialogów. Napisz program, który:
         * 1.za pomocą okna dialogowego pobierze od użytkownika łańcuch znakowy,
         * 2.zamieni w nim małe litery na wielkie,
         * 3.wyświetli wynik w dialogowym oknie informacyjnym.
         *
         * Wskazówki
         * •Do wyświetlania okna dialogowego pozwalającego na wprowadzeniedanych służy przeciążona, statyczna metoda showInputDialog()z klasy JOptionPane.
         * •Do zamiany małych liter na wielkie służy metoda toUpperCase()z klasy String. Zwraca ona nowy obiekt (nie modyfikuje źródła)!
         * •Do wyświetlenia okna informacyjnego służy statyczna, przeciążonametoda klasy JOptionPaneo nazwie showMessageDialog().
         * •Spośród wielu wariantów metod przeciążonych należy wybrać teo najmniejszej liczbie parametrów. Wykorzystują one domyślnewartości dla konfigurowalnych cech dialogów (np. ikona, tytuł).
         * •Programy korzystające z okien biblioteki Swing(w szczególności korzystające z dialogów wyświetlanych przez metody klasyJOptionPane) należy kończyć wywołując metodę System.exit(int).
         */

    }
    public static void C01E02_BigFactorial(){
        /**
         * Korzystając z klasy BigIntegernapisać program który wyznacza silnię z podanej liczby całkowitej n
         * nawet dla dużych n(rzędu kilkuset).
         */
    };
    public static void C01E03_SumUneven(){
        /**
         * Napisać program sumujący liczby nieparzyste z przedziału od 1 do n,gdzie n ­ podaje użytkownik
         * na starcie programu. Program powinienzakończyć sumowanie na liczbie n, gdy liczba n jest nieparzysta
         * lub naliczbie n − 1, gdy liczba n jest parzysta.
         */
    };
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
         * ustalonymina 1, a pozostałymi na 0).Chcemy mieć metody, które zmieniają liczbę na
         * napis ją reprezentujący w zadanym systemie liczenia (binarny, ósemkowy, szesnastkowy).
         * Aby uprościć zadanie, ograniczymy się do liczb nieujemnych. Zatem należy zaimplementować
         * trzy metody pobierające jako argument liczbę całkowitątypu inti zwracającą łańcuch znakowy
         * (obiekt klasy String) będący:
         *  1.binarną reprezentacją argumentu,
         *  2. ósemkową reprezentacją argumentu,
         *  3. szesnastkową reprezentacją argumentu.
         *  Wskazówki
         *  • Można skorzystać z operatorów bitowych przesunięcia w prawo i koniunkcji.
         *  • Można skorzystać z operatorów dzielenia oraz reszty z dzielenia (/,%).
         *
         *
         */
    };


    public static void main(String[] args) {
        C01_expressions_instructions_methods();
    };
}
