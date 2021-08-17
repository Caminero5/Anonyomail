package Backend;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Session {
    public String login(String username, String password) throws IOException {
        APIInfo apiInfo = new APIInfo();

        String host = apiInfo.getHost();
        String url = host + "/login";
        String json = "{\"username\": \""+username+"\", \"password\": \""+password+"\"}";
        System.out.println(json);

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

        in.close();
        conn.disconnect();

        return(results);
    }

    public String register(String email, String invite_code, String password) throws IOException {
        APIInfo apiInfo = new APIInfo();

        String host = apiInfo.getHost();
        String url = host + "/register";
        String json = "{\"email\": \""+email+"\", \"invite_code\": \""+invite_code+"\", \"password\": \""+password+"\"}";
        System.out.println(json);

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

        in.close();
        conn.disconnect();

        return(results);
    }

    public String logout(String sessionID) throws IOException {
        APIInfo apiInfo = new APIInfo();

        String host = apiInfo.getHost();
        String url = host + "/logout";
        String json = "{\"sessionID\": \""+sessionID+"\"}";
        System.out.println(json);

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

        in.close();
        conn.disconnect();

        return(results);
    }

}
