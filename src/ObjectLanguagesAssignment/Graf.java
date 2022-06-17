package ObjectLanguagesAssignment;

import java.util.*;

/** C05E03_Graf_toString
 * W poniższej klasie Graf:
 *
 * zdefiniuj metodę toString w taki sposób, aby graf był przedstawiany jako tablica
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

class Graf {
     private int n;             // liczba wierzchołków, V = {0,1,...,n-1}
     private LinkedList[] tab;  // tablica wierzchołków połączonych z danym wierzcholkiem
     public Graf(String lan) {
         StringTokenizer st = new StringTokenizer(lan, "() ,");
         n = Integer.parseInt(st.nextToken());
         tab = new LinkedList[n];
         for (int i=0; i<n; ++i)
             tab[i] = new LinkedList();
         while (st.hasMoreTokens()) {
             tab[Integer.parseInt(st.nextToken())].add(st.nextToken());
         }
     }
     public String toString() {
        StringBuffer buffer = new StringBuffer();
         for (int level=0; level<this.n; level++){
            buffer.append(level+": ");
             Iterator<Integer> iterator = this.tab[level].iterator();
             while(iterator.hasNext()){
                 buffer.append(iterator.next()+" ");
             }
             buffer.append('\n');
        }
         return buffer.toString();
     }
}
