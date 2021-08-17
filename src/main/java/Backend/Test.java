package Backend;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Session session = new Session();

        String response = session.logout("906883030004071936");
//        String response = session.login("j51784j", "BETA");
//        String response = session.register("d432d@anonyomail.com", "2468", "BETA");
        System.out.println(response);
    }
}
