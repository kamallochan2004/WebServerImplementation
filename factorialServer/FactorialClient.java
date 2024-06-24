// This is the client code
// It will connect to the server and send a number
// The server will calculate the factorial of the number
// and send the result back to the client

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FactorialClient {
    public static void main(String[] args) {
        int port = 1234;
        try {
            System.out.println("Client Started");
            Socket soc = new Socket("localhost", port);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a number:");
            int number = Integer.parseInt(userInput.readLine());
            PrintWriter out=new PrintWriter (soc.getOutputStream(),true);
            out.println(number);
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            System.out.println(in.readLine());

        } catch (Exception e) {
            e.printStackTrace();
    }
}
}