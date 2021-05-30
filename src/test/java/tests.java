
import org.junit.jupiter.api.Assertions;
//import org.junit.Test;
import org.junit.jupiter.api.Test;


public class tests {
    @Test
    public void testCheckerSuccessfulRun(){
        bankautomat bA =new bankautomat();
        bA.inputString("e1234b500bg");

        Assertions.assertEquals(0,bA.getState());
    }
    @Test
    public void testCheckerWrongCard(){
        bankautomat bA =new bankautomat();
        bA.inputString("f1234b500bg");

        Assertions.assertEquals(0,bA.getState());
    }
    @Test
    public void testCheckerWrongCardThenRightCard(){
        bankautomat bA =new bankautomat();
        bA.inputString("fe1234b500bg");

        Assertions.assertEquals(0,bA.getState());
    }
    @Test
    public void wrongPinTimesOne(){
        bankautomat bA =new bankautomat();
        bA.inputString("e1235b1234b");
        Assertions.assertEquals(2,bA.getState());
    }
    @Test
    public void wrongPinTimesTwo(){
        bankautomat bA =new bankautomat();
        bA.inputString("e1235b1233b1234b");
        Assertions.assertEquals(2,bA.getState());
    }
}
