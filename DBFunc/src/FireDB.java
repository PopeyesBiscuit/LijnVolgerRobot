import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

public class FireDB {

    public FireDB(){

    }

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
