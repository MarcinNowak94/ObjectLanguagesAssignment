package ObjectLanguagesAssignment;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.security.KeyStore;

/* C05E01_Wspolrzedna_TreeSet
 * Dostosuj poniższą klasę:
 * do wymagań stawianych wobec elementów dodawanych do kontenera TreeSet,
  * tak aby w wyniku wykonania programu: [ C05E01_Wspolrzedna_TreeSet()]
 * punkty zbioru TreeSetbyły wyświetlone na ekranie w kolejności leksykograficznej
 * (czyli (−3, −2), (−3, 0), (−1, 2), (2, 3)).
 * Wskazówka•Klasa Wspolrzedna powinna implementować interfejs Comparable
 */


/* C05E02_Wspolrzedna_hashmap --------------------------------
 * Dostosuj klasę Wspolrzednaz poprzedniego zadania do wymagań stawianych wobec elementów dodawanych
 * do kontenera HashMap. Wówczas w wyniku wykonania programu:
 *
 * C05E02_Wspolrzedna_hashmap
 *
 * na ekranie zostanie wyświetlony tekst:
 * Punkt (-1, 2) ma kolor czerwony
 *
 * Wskazówka•Klasa Wspolrzednapowinna przesłonić metody hashCode oraz equals.
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
        if (this.x==arg.x && this.y>arg.y) return 1;
        return -1;
    }

    @Override
    public int hashCode(){
      //as per https://javastart.pl/baza-wiedzy/programowanie-obiektowe/metoda-hashcode
      //Pretty much caveman solution
        return this.x*this.y;
    }
    @Override
    public boolean equals(Object obj){
        //sanity check
        if(this==obj) return TRUE;
        if(obj==null) return FALSE;
        if(this.getClass()!=obj.getClass()) return FALSE; //eliminate subtypes
        Wspolrzedna arg = (Wspolrzedna) obj;

        return (this.hashCode()==obj.hashCode());
    }
}
