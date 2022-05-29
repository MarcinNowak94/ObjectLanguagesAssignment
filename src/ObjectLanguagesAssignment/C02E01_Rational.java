package ObjectLanguagesAssignment;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.Collections;

public class C02E01_Rational implements Comparable<C02E01_Rational>{
    /**
     * Zaprojektuj klasę Rational, reprezentującą liczby wymierne jako pary liczb
     * całkowitych (licznik i mianownik), wraz z podstawowymi działaniami arytmetycznymi
     * i porównaniem. W klasie powinny znaleźć się nastę-pujące metody publiczne (oprócz konstruktora):
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
     * •Jeśli this jest równe arg, to zwraca 0.
     * •Jeśli this jest mniejsze od arg, to zwraca −1.
     * •Jeśli this jest większe niż arg, to zwraca 1.
     * Metoda 7. mazwracać łańcuch znakowy opisujący ten obiekt. Na przykład może to
     * być napis postaci 1/2 lub -1/1.
     */

    private Integer my_numerator;
    private Integer my_denominator;

    public C02E01_Rational() {
        setMy_numerator(0);
        setMy_denominator(1);
    }
    public C02E01_Rational(Integer numerator, Integer denominator) {
        if (denominator==0) {throw new ArithmeticException();}
        setMy_numerator(numerator);
        setMy_denominator(denominator);
    }
    public C02E01_Rational(String ration) {
        String[] numbers=ration.split("/");
        setMy_numerator(Integer.parseInt(numbers[0]));
        setMy_denominator(Integer.parseInt(numbers[1]));
    }
    public C02E01_Rational(C02E01_Rational arg){
        setMy_numerator(arg.getMy_numerator());
        setMy_denominator(arg.getMy_denominator());
    }

    public Integer getMy_numerator() {
        return my_numerator;
    }
    public Integer getMy_denominator() {
        return my_denominator;
    }
    public void setMy_numerator(int my_numerator) {
        this.my_numerator = my_numerator;
    }
    public void setMy_denominator(int my_denominator) {
        this.my_denominator = my_denominator;
    }

    public C02E01_Rational add(C02E01_Rational arg){
        Integer numerator=(this.getMy_numerator()*arg.getMy_denominator())+(arg.getMy_numerator()*this.getMy_denominator());
        Integer denominator=this.getMy_denominator()*arg.getMy_denominator();
        return new C02E01_Rational(numerator, denominator);
    }
    public C02E01_Rational sub(C02E01_Rational arg){
        Integer numerator=(this.getMy_numerator()*arg.getMy_denominator())-(arg.getMy_numerator()*this.getMy_denominator());
        Integer denominator=this.getMy_denominator()*arg.getMy_denominator();
        return new C02E01_Rational(numerator, denominator);
    }
    public C02E01_Rational mul(C02E01_Rational arg){
        return new C02E01_Rational(this.getMy_numerator()*arg.getMy_numerator(),
                this.getMy_denominator()*arg.getMy_denominator());
    }
    public C02E01_Rational div(C02E01_Rational arg){
        return this.mul(new C02E01_Rational(arg.getMy_denominator(),arg.getMy_numerator()));
    }

    @Override
    public boolean equals(Object obj) {
        //https://www.sitepoint.com/implement-javas-equals-method-correctly/
        if(this==obj) return TRUE;
        if(obj==null) return FALSE;
        //subtypes will never be equal, but obj instanceof classname breaks transitive rule
        if(getClass()!=obj.getClass()) return FALSE;
        C02E01_Rational arg = (C02E01_Rational) obj;

        C02E01_Rational num_arg = arg.mul(new C02E01_Rational(this.getMy_denominator(),this.getMy_denominator()));
        C02E01_Rational num_this = this.mul(new C02E01_Rational(arg.getMy_denominator(),arg.getMy_denominator()));

        //Primitive types use ==, objects use Object.compare
        return ((num_arg.getMy_numerator()==num_this.getMy_numerator())
                && (num_arg.getMy_denominator()==num_this.getMy_denominator()));
    }
    @Override
    public int compareTo(C02E01_Rational arg){
        if (this.equals(arg)) return 0;
        C02E01_Rational num_arg = arg.mul(new C02E01_Rational(this.getMy_denominator(),this.getMy_denominator()));
        C02E01_Rational num_this = this.mul(new C02E01_Rational(arg.getMy_denominator(),arg.getMy_denominator()));

        if (num_this.getMy_numerator() > num_arg.getMy_numerator()) return 1;
        return -1;
    }
    @Override
    public String toString(){
        return this.getMy_numerator()+"/"+this.getMy_denominator();
    }
}
