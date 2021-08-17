package Backend;

import java.sql.DriverManager;

public class APIInfo {
    //creates field defining host so i dont have to switch the host everywhere in the application
    private String host = "http://api.anonyomail.com";


    public String getHost() {
        return host;
    }

}
