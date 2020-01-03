import TI.BoeBot;

public class RobotMain {

    public static void main(String[] args) {

        boolean state = true;
        try{


        }catch(Exception e){
            e.printStackTrace();
        }

        while (true) {
            state = !state;
            BoeBot.digitalWrite(0, state);
            BoeBot.wait(0, 20000);
        }
    }



}
