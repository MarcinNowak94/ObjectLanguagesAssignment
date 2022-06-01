package ObjectLanguagesAssignment;

import static java.lang.Math.sqrt;

/**
 * C02E03_Class_Hierarchy()
 */
public class FunkcjaKwadratowa implements Wielomian {
    private Integer xquadraticconstant;
    private Integer xconstant;
    private Integer constant;
    private Integer delta;

    public FunkcjaKwadratowa(Integer xqcon, Integer xcon, Integer con){
        xquadraticconstant=xqcon;
        xconstant=xcon;
        constant=con;
        delta=(xcon*xcon)-(4*xqcon*con);
    }
    public void wypiszMiejscaZerowe(){
        String solution="";
        if (delta<0) {
            solution="brak";
        }
        if (delta==0){
            solution=Double.toString(((-xconstant)-sqrt(delta))/2*xquadraticconstant);
        }
        if (delta>0) {
            solution=Double.toString(((-xconstant)-sqrt(delta))/2*xquadraticconstant)
                    + " "
                    + Double.toString(((-xconstant)+sqrt(delta))/2*xquadraticconstant);
        };
        System.out.println(solution);
    }
}
