import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

// this class uses the FireBase rest api to get and post data to the database

public class FireDB {

    public FireDB(){

    }

    // functie voor het krijgen van de X positie van de robot
    public static int getLocX() throws Exception {
        StringBuilder result = new StringBuilder();
        String url = "https://lijnvolger-20778.firebaseio.com/Position/Current/X.json";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null){
            result.append(line);
        }
        rd.close();
        return Integer.parseInt(result.toString());
    }

    // functie voor het krijgen van de Y positie van de robot
    public static int getLocY() throws Exception {
        StringBuilder result = new StringBuilder();
        String url = "https://lijnvolger-20778.firebaseio.com/Position/Current/Y.json";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null){
            result.append(line);
        }
        rd.close();
        return Integer.parseInt(result.toString());
    }

    // functie voor het updaten van de positie van de robot
    public static void updateLoc(int x, int y) throws Exception {

        String url = "https://lijnvolger-20778.firebaseio.com/Position/Current.json";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("PUT");
        OutputStreamWriter out = new OutputStreamWriter(
                con.getOutputStream());
        String put = "{\"X\" : "+x+", \"Y\" : "+y+"}";
        out.write(put);
        out.close();
        con.getInputStream();
        System.out.println("Location Updated");

    }

    //functie voor het opslaan van obstakels in de database
    public static void addObjectOn(int x, int y) throws Exception {
        String url = "https://lijnvolger-20778.firebaseio.com/ObstacleOnXY.json";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        OutputStreamWriter out = new OutputStreamWriter(
                con.getOutputStream());
        String put = "{\"X\" : "+x+", \"Y\" : "+y+"}";
        out.write(put);
        out.close();
        con.getInputStream();
        System.out.println("Object On Added");
    }

     //functie voor het opslaan van obstakels in de database als de obstakel tussen twee coordinaten zit
    public static void addObjectBetween(int fromx, int fromy, int tox, int toy) throws Exception {

        String url = "https://lijnvolger-20778.firebaseio.com/ObstacleBetweenXY.json";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        OutputStreamWriter out = new OutputStreamWriter(
                con.getOutputStream());
        String put = "{\"FromX\" : "+fromx+", \"FromY\" : "+fromy+", \"ToX\" : "+tox+", \"ToY\" : "+toy+"}";
        out.write(put);
        out.close();
        con.getInputStream();
        System.out.println("Object Between Added");

    }

}
