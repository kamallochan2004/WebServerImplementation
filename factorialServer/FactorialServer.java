// This is the server code
// It will listen for incoming connections
// and calculate the factorial of the number sent by the client

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FactorialServer {
    public static void main(String[] args) {
    int port=1234;
    try{
        System.out.println("Server Started waiting for number by client.....");
        ServerSocket sos = new ServerSocket(port);
        Socket soc = sos.accept();
        System.out.println("Connection Established");
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        int number = Integer.parseInt(in.readLine());
        PrintWriter out = new PrintWriter(soc.getOutputStream(),true);
        out.println("Factorial of "+number+" is "+factorial(number));
    }
    catch (Exception e){
        e.printStackTrace();
    }
    }
    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        else{
            return(n*factorial(n-1));
        }
    }
}
