import java.io.IOException;
import java.util.Scanner;

public class main {
    static bankautomat bA =new bankautomat();





    public static void main(String[] args) {
        //System.out.println(bA.inputString("e1234b500bg"));


        while(true){

            Scanner in = new Scanner(System.in);

            String s = in.nextLine();



            try{
            char c = s.charAt(0);
                bA.run(c);}
            catch (StringIndexOutOfBoundsException e){
                System.out.println("error");
            }


       }

    }
}
