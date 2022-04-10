package Übungen.A_2A;

/**
 * @author Manuel Weid
 * @version 1.0
 *
 * <p />Aufgabe2A.Calculator
 * <p />SDK 14
 * <p />JUnit 5.8.2
 *
 */

public class Calculator{

    //Addition von 2 Zahlen
    public double add(double summand1, double summand2){
        return summand1 + summand2;
    }

    //Addition von einem Array von Zahlen
    public double addList(double[] summandArr){
        double result = 0;

        for(double elem : summandArr){
            result += elem;
        }

        return result;
    }

}