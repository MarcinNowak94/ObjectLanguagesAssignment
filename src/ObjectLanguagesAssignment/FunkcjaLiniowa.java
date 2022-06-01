package ObjectLanguagesAssignment;

import static java.lang.Math.sqrt;

/**
 * C02E03_Class_Hierarchy()
 */
public class FunkcjaLiniowa implements Wielomian {
//new FunkcjaLiniowa(2, 1); // 2x + 1
    private Integer xconstant;
    private Integer constant;

    public FunkcjaLiniowa(Integer xcon, Integer con){
        xconstant=xcon;
        constant=con;
    }
    public void wypiszMiejscaZerowe(){
        System.out.println((double)(-constant)/xconstant);
    }

}
