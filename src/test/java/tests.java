
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
    @Test
    public void rightPin(){
        bankautomat bA = new bankautomat();
        bA.inputString("e1234");
        Assertions.assertEquals(1, bA.getState());
    }

    @Test
    public void correctPin(){
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e125k34b");
        Assertions.assertEquals(2, bankautomat.getState());
    }
    @Test
    public void correctPintoolong(){
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1235k4b");
        Assertions.assertEquals(2, bankautomat.getState());
    }
    @Test
    public void longPin(){
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1235k445678b");
        Assertions.assertEquals(2, bankautomat.getState());
    }
    @Test
    public void strangePin(){
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1235k441234b");
        Assertions.assertEquals(1, bankautomat.getState());
    }
    @Test
    void strangeString(){
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("ffffffe1234b");
        Assertions.assertEquals(2, bankautomat.getState());
    }
    @Test
    void strangeString2(){
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("ffffffe12346843528561234b");
        Assertions.assertEquals(1, bankautomat.getState());
    }

    @Test
    void dailyLimit(){
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1234b20000000bg");
        Assertions.assertEquals(2, bankautomat.getState());
    }

    @Test
    void amountkorrekt(){
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1234b20000000kkkkkkkk50bg");
        Assertions.assertEquals(0, bankautomat.getState());
    }
    @Test
    void strangePin3(){
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("eabcdb");
        Assertions.assertEquals(1, bankautomat.getState());
    }
    @Test
    void toomanycards(){
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        Assertions.assertEquals(1, bankautomat.getState());
    }
    @Test
    void toomanycardspluspin(){
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee1234b");
        Assertions.assertEquals(2, bankautomat.getState());
    }
    @Test
    void toomanyparkcardspluspin(){
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("eeeeeeeeeffffffffffffffffffffffffffffffffffffffffff1234b");
        Assertions.assertEquals(2, bankautomat.getState());
    }

    @Test
    void multibleCorrections(){
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1234b2000kk50kk10bg");
        Assertions.assertEquals(0, bankautomat.getState());
    }


    //TODO Äquivalenzklassen

}
