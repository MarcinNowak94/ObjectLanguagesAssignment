package ObjectLanguagesAssignment;

import java.lang.Math;
import java.util.Arrays;
import java.util.Vector;

import static java.lang.Math.sqrt;

public class C02E02_Quadratic_formula {
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
    private Double a;
    private Double b;
    private Double c;
    private Double delta;

    public C02E02_Quadratic_formula(String formula){
        //parse input
        int x2=formula.indexOf("x2");
        int x=formula.indexOf("x",x2+2/*length of x2*/);
        if (x2==-1 || x==-1) throw new IllegalArgumentException("No x2 or x");
        //formulas such as x2+nx+m, -x2+nx+m or 2x2+x+m
        if (x2==1 && formula.charAt(x2-1)=='-') {
            formula=formula.substring(0,x2)+'1'+formula.substring(x2,formula.length());
            x2++;
            x++;
        };
        if (x2==0) {
            formula='1'+formula;
            x2++;
            x++;
        };
        if (formula.charAt(x-1)=='+' || formula.charAt(x-1)=='-') {
            formula=formula.substring(0,x)+'1'+formula.substring(x,formula.length());
            x++;
        };
        if (formula.length()==x+1) {
            formula=formula+"+0";
        }

        String[] component=formula.replaceAll("x(2*)","").split("((?<=[+-])|(?=[+-]))");
        if (component[0].equals("-")) {
            a=Double.parseDouble(component[0]+component[1]);
            b=Double.parseDouble(component[2]+component[3]);
            c=Double.parseDouble(component[4]+component[5]);
        } else {
            a=Double.parseDouble(component[0]);
            b=Double.parseDouble(component[1]+component[2]);
            c=Double.parseDouble(component[3]+component[4]);
        }
        if (a==0) throw new ArithmeticException("Not quadratic equation, Parameter a equal to 0");
        this.setDelta();
    }

    public void setA(Double a) {
        this.a = a;
        this.setDelta();
    }
    public void setB(Double b) {
        this.b = b;
        this.setDelta();
    }
    public void setC(Double c) {
        this.c = c;
        this.setDelta();
    }
    private void setDelta(){
        delta=(b*b)-(4*a*c);
    }

    public Double getA() {
        return a;
    }
    public Double getB() {
        return b;
    }
    public Double getC() {
        return c;
    }
    public Double getDelta() {
        //compute delta
        return delta;
    }
    /**
     * Returns solution for given X
     * @param x get y for given X
     * @return
     */
    public Double solveY(Double x) {
        return a*(x*x)+b*x+c;
    }
    public int solutions(){
        if (delta>0) return 2;
        if (delta==0) return 1;
        return 0;
    }

    /**
     * Solve for places where y=0
     * @return returns null if delta is negative
     */
    public Double[] solveX0() {
        Double solution[] = new Double[2];
        if (this.solutions()==0) {
            //throw new ArithmeticException("Delta="+getDelta()+". No real solution");
            solution[0]=null;
            solution[1]=null;
        }
        solution[0]=((-b)-sqrt(delta))/2*a;
        solution[1]=((-b)+sqrt(delta))/2*a;
        return solution;
    }

}
