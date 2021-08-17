package Backend;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Session {
    
    //sends data to server to make a login session
    public String login(String username, String password) throws IOException {
        APIInfo apiInfo = new APIInfo();

       //grabs host URL from the APIInfo class
        String host = apiInfo.getHost();
        String url = host + "/login";
        //converts strings into a json format for server to use
        String json = "{\"username\": \""+username+"\", \"password\": \""+password+"\"}";
        System.out.println(json);

        //makes connecttion to database
        URL Url = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) Url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST"); //makes method POST for inserting data

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();

        //reads response from server
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String results = IOUtils.toString(in, "UTF-8");

        //disconnects everything
        in.close();
        conn.disconnect();

        return(results);
    }

    //sends data to server to register
    public String register(String email, String invite_code, String password) throws IOException {
        APIInfo apiInfo = new APIInfo();

        //grabs host from APIInfo class
        String host = apiInfo.getHost();
        String url = host + "/register";
        //converts string data to json format for server
        String json = "{\"email\": \""+email+"\", \"invite_code\": \""+invite_code+"\", \"password\": \""+password+"\"}";
        System.out.println(json);

        //connects to database
        URL Url = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) Url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();

        //reads response from server
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String results = IOUtils.toString(in, "UTF-8");

        //disconnects all
        in.close();
        conn.disconnect();

        //returns the results to user
        return(results);
    }

    
    //loggs the user out
    public String logout(String sessionID) throws IOException {
        APIInfo apiInfo = new APIInfo();

        //grabs host from APIInfo class
        String host = apiInfo.getHost();
        String url = host + "/logout";
        //converts session ID string into json format for server
        String json = "{\"sessionID\": \""+sessionID+"\"}";
        System.out.println(json);

        //creates connection
        URL Url = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) Url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();

        //reads response from server
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String results = IOUtils.toString(in, "UTF-8");

        //closes connection
        in.close();
        conn.disconnect();

        return(results);
    }

}
