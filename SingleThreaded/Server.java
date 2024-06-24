import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run() throws IOException {
        int port =8088;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000000);
        while(true){
            try {
                System.out.println("Server is waiting for client on port " + port);
                Socket acceptedSocket = socket.accept();
                System.out.println("Just connected to " + acceptedSocket.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptedSocket.getOutputStream(), true);
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedSocket.getInputStream()));
                toClient.println("Hello, client! from the server ");
                toClient.close();
                fromClient.close();
                acceptedSocket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
