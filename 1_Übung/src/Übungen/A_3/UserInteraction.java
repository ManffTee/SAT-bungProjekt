package Übungen.A_3;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UserInteraction {

    private final Scanner input;
    private final PrintStream output;

    public UserInteraction(InputStream in, PrintStream out) {
        this.input = new Scanner(in);
        this.output = out;
    }

    public int inputInt(String text, int minValue){
        int result = 0;
        do{
            try{
                this.output.println(text);
                result = this.input.nextInt();
            } catch (Exception ex){
                result = 0;
                System.out.println("Please select a number only");
                this.input.next();
            }
        } while (result < minValue);
        return result;
    }

    public Integer inputIntMinMaxError(String text, int minValue, int maxValue, String errorText){
        int result = 0;

        this.output.println(text);
        result = this.input.nextInt();

        if(result > maxValue || result < minValue){
            this.output.println(errorText);
            return null;
        }
        else{
            return result;
        }
    }

    public String inputString(String text){
        this.output.println(text);
        return this.input.next();
    }

    public void outputString(String text){
        this.output.println(text);
    }
}
