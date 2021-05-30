import org.junit.jupiter.api.function.Executable;

public class bankautomat {
    private String storage = "";
    private String secretPin = "1234";
    private int dailyMaximum = 5000;
    private int state = 0;
    private int numCOunt = 0;
    private int tryCount = 0;
    //0 idle- 1 waiting for pin - 2 waiting for amount  3-cash out

    bankautomat() {


    }

    public void run(char c) {

        storage += c;
        storage = storage.toLowerCase();
        analyseChar(c);
        //checkStringForNumbers(state);
        print(storage);


    }

    public void print(String s) {
        System.out.println(s);
    }

    private void checkStringForNumbers(int state) {
        String temp = "";
        if (storage.length() >6){
        }
        try {
            temp = storage.substring(storage.length() - 5, storage.length()-1);
        } catch (StringIndexOutOfBoundsException e){print("ERRROR: illegal iput, pin too short");}


        System.out.println("temp="+temp);
        if (state == 1) {
                //was wenn der user einen vierstelligen betrag abheben will
                if (temp.matches("\\d{4}")) {
                    print("found 4 ");
                    try {
                        //temp = storage.substring(storage.length() - 4, storage.length() - 1);
                        confirmPin(temp);
                    } catch (StringIndexOutOfBoundsException e) {
                        print("tried to remove letter from zero-length string");
                    }
                }
        }
    }

    public inputString(String a){
        String[] parsed = a.split("");
        for (String s:parsed){
            this.run(s.charAt(0));
        }
    }

    private void confirmPin(String temp) {
        if (temp.equals(secretPin) && storage.length() <= 6) {
            state = 2;
            print("Pin entry successful, pls enter amount ");
            print(state + "");
            tryCount = 0;
        } else {
            state = 1;
            tryCount++;
            storage = "e";
            if (tryCount < 2) {
                print("wrong pin, pls try again");
            } else if (tryCount == 2) {
                print("you are a criminal sir!");
                //state = 0;
            }
            else if (tryCount==3){
                print("i am calling the police!");
                state = 0;
                tryCount = 0;
            }
        }
    }


    private void analyseChar(char c) {
        switch (c) {
            case 'e':
                if(state==0) {
                    state = 1;
                    print("state is now 1. ready for code");
                }
                else {
                    print("you already have a card inserted");
                    storage = storage.substring(0,storage.length()-1);
                }
                break;
            case 'f':
                if (state==0) {
                    state = 0;
                    print("invalid card inserted");
                    storage = "";
                    //ungültige Ec Karte
                }
                else{
                    print("There is already a card in the slot");
                    storage = "";
                }
                break;
            case 'g':
                //geldentnahmne
                if (state == 3) {
                    state = 0;
                    print("you received your money, state is now idle ");
                    storage = "";
                }

                break;


            case 'a':
                //abbruch
                state = 0;
                storage = "";
                break;

            case 'b':
                //bestätigung
                if (state==1){
                    checkStringForNumbers(state);
                    storage="";
                }
                else if(state==2){
                confirmEntry();}

                break;
            case 'k':
                try {
                    storage = storage.substring(0, storage.length() - 2);
                    System.out.println("DEBUG: Korrektur " +storage);
                } catch (StringIndexOutOfBoundsException e) {
                    print("tried to remove letter from zero-length string");
                }

                break;

        }



    }

    public int getState() {
        return state;
    }

    private void confirmEntry(
    ) {
        if (state == 2) {
            String temp = "";
            try {
                temp = storage.substring(0, storage.length()-1);
            } catch (StringIndexOutOfBoundsException e) {
                print("tried to remove letter from zero-length string");
            }
            if (temp.length() !=0 &&Integer.parseInt(temp) > dailyMaximum) {
                print("you dont have that much money, get a job! ");
                print(state + "");
            } else {
                state = 3;
                try {
                    temp = storage.substring(0, storage.length() - 1);
                } catch (StringIndexOutOfBoundsException e) {
                    print("tried to remove letter from zero-length string");
                }

                print("Take these " + temp + " monies, have a nice day.");
                print(state+"");

            }
        }
    }
}

