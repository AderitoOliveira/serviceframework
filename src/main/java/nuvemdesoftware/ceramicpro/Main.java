package nuvemdesoftware.ceramicpro;

import sun.net.www.http.HttpClient;

public class Main {

    public static void main(String[] args) throws Exception {
        JettyServer server = new JettyServer();
        server.start();
    }
}
