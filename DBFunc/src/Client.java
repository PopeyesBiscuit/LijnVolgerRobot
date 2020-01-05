import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {

    static Socket s;

    public Client(String host, int port) throws IOException {

         s = new Socket(host, port);
        System.out.println("Connected to host");

    }

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
