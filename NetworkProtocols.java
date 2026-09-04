import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class NetworkProtocols {
    public static void main(String[] args) throws IOException {
     
        HttpServer server = HttpServer.create(new InetSocketAddress(3000), 0);

   
        server.createContext("/Sup", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
          
                System.out.println("--- New Request Received ---");
                System.out.println("Method: " + exchange.getRequestMethod());
                System.out.println("Path: " + exchange.getRequestURI());

             
                String response = "Welcome to my first server ever!\n";

            
                exchange.sendResponseHeaders(200, response.length());

          
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

    
        System.out.println("Server running on http://localhost:3000/hello");
        server.start();
    }
}