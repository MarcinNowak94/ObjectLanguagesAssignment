package ObjectLanguagesAssignment;

 /**
 * Dostosuj poniższą klasę:
 * do wymagań stawianych wobec elementów dodawanych do kontenera TreeSet,
  * tak aby w wyniku wykonania programu: [ C05E01_Wspolrzedna_TreeSet()]
 * punkty zbioru TreeSetbyły wyświetlone na ekranie w kolejności leksykograficznej
 * (czyli (−3, −2), (−3, 0), (−1, 2), (2, 3)).
 * Wskazówka•Klasa Wspolrzedna powinna implementować interfejs Comparable
 */

public class Wspolrzedna implements Comparable<Wspolrzedna>{
    private int x, y;
    public Wspolrzedna(int _x, int _y) {
        x = _x;
        y = _y;
    }
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
     public int compareTo(Wspolrzedna arg){
        if (this.equals(arg)) return 0;
        if (this.x>arg.x) return 1;
        if (this.x>arg.x && this.y>arg.y) return 1;
        return -1;
    }
}
