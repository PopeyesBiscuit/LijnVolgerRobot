import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

// Client class for connecting the robot to the laptop.

public class Client {

    // Static variable for socket init
    static Socket s;

    //Client contructor for creating a client. The hostname  and port number are given through parameters
    public Client(String host, int port) throws IOException {

         s = new Socket(host, port);
        System.out.println("Connected to host");

    }
     
    // Code voor het verkrijgen van de X coordinaat via de Server-Client connectie
    public static int getDestX() {
        try{

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            int[] endpoints = (int[]) in.readObject();

            return endpoints[0];

        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e1){
            e1.printStackTrace();
        }

        System.out.println("X Received");
        return 0;
    }

     // Code voor het verkrijgen van de Y coordinaat via de Server-Client connectie
    public static int getDestY(){

        try{

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            int[] endpoints = (int[]) in.readObject();

            return endpoints[1];

        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e1){
            e1.printStackTrace();
        }

        System.out.println("Y Received");
        return 0;
    }

}
