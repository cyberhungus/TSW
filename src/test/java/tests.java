
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import junit.framework.AssertionFailedError;
import org.junit.jupiter.api.Assertions;
//import org.junit.Test;
import org.junit.jupiter.api.Test;


public class tests {
    @Test
    void completeRun() {
        try {
            testCheckerSuccessfulRun();
            testCheckerWrongCard();
            testCheckerWrongCardThenRightCard();
            wrongPinTimesOne();
            wrongPinTimesTwo();
            wrongPinTimesThree();
            rightPin();
            correctPin();
            correctPintoolong();
            longPin();
            strangePin();
            toomanycards();
            toomanycardspluspin();
            toomanyparkcardspluspin();
            strangeString();
            strangeString2();
            dailyLimit();
            amountkorrekt();
            multibleCorrections();
            exceptions();
            exceptionsStatus2();
            testCancle();
            testCancel2();
            testCancle3();
            rightAmount();


        } catch (AssertionFailedError e) {
            System.out.println("Test failed" + e);
        }

    }

    //Testfall: Pin 3 mal Falsch; erwartetes Ergebnis: Status 0 - idle
    @Test
    void wrongPinTimesThree() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1233b1233b1233b");
        Assertions.assertEquals(0, bankautomat.getState());
    }

    //Testfall: Erfolgreicher durchlauf; erwatets Ergebenis: Status 0 - idle
    @Test
    void testCheckerSuccessfulRun() {
        bankautomat bA = new bankautomat();
        bA.inputString("e1234b500bg");

        Assertions.assertEquals(0, bA.getState());
    }

    //Testfall: falsche Karte; erwartetes Ergebnis: Status 0 - idle
    @Test
    void testCheckerWrongCard() {
        bankautomat bA = new bankautomat();
        bA.inputString("f1234b500bg");

        Assertions.assertEquals(0, bA.getState());
    }

    //Testfall: erst falsche Karte, dann richtige Karte und Geld abheben; erwartetes Ergebnis: Status 0 - idle
    @Test
    void testCheckerWrongCardThenRightCard() {
        bankautomat bA = new bankautomat();
        bA.inputString("fe1234b500bg");

        Assertions.assertEquals(0, bA.getState());
    }

    // Testfall: erst den falschen Pin, dann den richtigen; erwartetes Ergebnis: Status 0 - idle
    @Test
    void wrongPinTimesOne() {
        bankautomat bA = new bankautomat();
        bA.inputString("e1235b1234b");
        Assertions.assertEquals(2, bA.getState());
    }

    //Testfall: zwei mal den falschen Pin, dann den richitigen; erwartetes Ergebnis: Status 2 - warten auf Geldmenge
    @Test
    void wrongPinTimesTwo() {
        bankautomat bA = new bankautomat();
        bA.inputString("e1235b1233b1234b");
        Assertions.assertEquals(2, bA.getState());
    }

    // Testfall: richtiger Pin, erwartetes Ergebnis: Status 2 - wartem auf Geldmenge
    @Test
    void rightPin() {
        bankautomat bA = new bankautomat();
        bA.inputString("e1234b");
        Assertions.assertEquals(2, bA.getState());
    }

    // Testfall: Pin korrigieren; Erwartetes Ergebnis: Status 2 - warten auf Geldmenge
    @Test
    void correctPin() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e125k34b");
        Assertions.assertEquals(2, bankautomat.getState());
    }

    //Testfall: Pin, wenn er zu lang is korrigieren; erwartetes Ergebnis: Status 2 - Warten auf Geldmenge
    @Test
    void correctPintoolong() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1235k4b");
        Assertions.assertEquals(2, bankautomat.getState());
    }

    //Testfall: Eingegebener Pin zu lang; erwartetes Ergebnis: Status 1 - warten auf Pin
    @Test
    void longPin() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1235k445678b");
        Assertions.assertEquals(1, bankautomat.getState());
    }

    //Testfall: Eingegebener Pin zu lang, hat aber am ende die richtigen Zahlen; erwartetes Ergebnis: Status 1 - warten auf Pin
    @Test
    void strangePin() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1235k441234b");
        Assertions.assertEquals(1, bankautomat.getState());
    }

    // Testfall: erst oft versuchen eine falsche Karte eingeben, dann die richtige und den Pin; erwartetes Ergebnis: Status 2 - warten auf Geldmenge
    @Test
    void strangeString() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("ffffffe1234b");
        Assertions.assertEquals(2, bankautomat.getState());
    }

    // Testfall: erst oft die falsche Karte, dann die richtige, und dann ganz viele Zahlen für den Pin, welche auf der richtigen Sequenz enden;
// erwartetes Ergebnis: Status 1 - warten auf Pin
    @Test
    void strangeString2() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("ffffffe12346843528561234b");
        Assertions.assertEquals(1, bankautomat.getState());
    }

    //Testfall: versuch mehr als das Daily limit abzuheben; erwartetes Ergebnis: Status 2 - warten auf Geldeingabe
    @Test
    void dailyLimit() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1234b20000000bg");
        Assertions.assertEquals(2, bankautomat.getState());
    }

    //Testfall: Den eingegebene Geldbetrag korrigieren und abheben; erwartetes Ergebnis: Status 0 - idle
    @Test
    void amountkorrekt() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1234b20000000kkkkkkkk50bg");
        Assertions.assertEquals(0, bankautomat.getState());
    }

    //Testfall: es werden versucht sehr viele richtige Karten einzusetzen; erwartetes Ergebnis: Status 1 - warten auf Pin
    @Test
    void toomanycards() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        Assertions.assertEquals(1, bankautomat.getState());
    }

    //Testfall: es werden versucht sehr viele richtige Karten einzusetzen, am ende der richtige pin; erwartetes Ergebnis: Status 2 - warten auf Geldbetrag
    @Test
    void toomanycardspluspin() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee1234b");
        Assertions.assertEquals(2, bankautomat.getState());
    }

    //Testfall: erst viele richtige, dann viele falsche Karten, am Ende ein Pin eingabe; erwartetes Ergebnis: Status 2 Warten auf Geldbetrag
// -> liegt daran, dass die erste Karte eine richtige war.
    @Test
    void toomanyparkcardspluspin() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("eeeeeeeeeffffffffffffffffffffffffffffffffffffffffff1234b");
        Assertions.assertEquals(2, bankautomat.getState());
    }

    //Testfall: mehrere Korrekturen im Prozess des Geldabhebens; erwartetes Ergebnis: Status 0 - idle
    @Test
    void multibleCorrections() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1234b2000kk50kk10bg");
        Assertions.assertEquals(0, bankautomat.getState());
    }

    //Testfall: Exeption provozieren durch zu wenig Zahlen bei Pin, erwartetes Ergebnis: Programm wirft keinen Fehler aus
    @Test
    void exceptions() {
        bankautomat bankautomat = new bankautomat();
        Assertions.assertDoesNotThrow(() -> bankautomat.inputString("e12b"));
    }

    //Testfall: Exception provozieren durch keine Eingabe bei dem Geldbetrag; erwartetes Ergebnis: Programm wirft keinen Fehler
    @Test
    void exceptionsStatus2() {
        bankautomat bankautomat = new bankautomat();

        Assertions.assertDoesNotThrow(() -> bankautomat.inputString("e1234bb"));
    }

    //Testfall: Abbruch nachdem die Karte eingesteckt wurde; erwartetes Ergebnis: Status 0 - idle
    @Test
    void testCancle() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("ea");
        Assertions.assertEquals(0, bankautomat.getState());
    }

    //Testfall: Abbruch nachdem der richtige Pin eingegeben wurde, aus Status 2; erwartetes Ergebnis: Status 0 - idle
    @Test
    void testCancel2() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1234ba");
        Assertions.assertEquals(0, bankautomat.getState());
    }

    //Testfall: Abbruch nach der Geldeingabe; erwartetes Ergebnis: Status 0 - idle
    @Test
    void testCancle3() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1234b500ba");
        Assertions.assertEquals(0, bankautomat.getState());
    }

    //Testfall: es kommt der erwartete Betrag aus dem Geldautomaten; Eingabe: 500 - erwartetes Ergebnis: 500
    @Test
    void rightAmount() {
        bankautomat bankautomat = new bankautomat();
        bankautomat.inputString("e1234b500b");
        Assertions.assertEquals(500, bankautomat.getLastAmount());
    }


}
