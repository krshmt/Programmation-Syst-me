package Exo1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) {
        Calculatrice calculatrice = new Calculatrice();
        try {
            ServerSocket socketServer = new ServerSocket(4445);
            while (true) {
                Socket socketClient = socketServer.accept();
                InputStreamReader stream = new InputStreamReader(socketClient.getInputStream());
                BufferedReader reader = new BufferedReader(stream);
                String message = reader.readLine();

                String[] messageSplit = message.split(" ");
                System.out.println(messageSplit[1]);
                int a = Integer.parseInt(messageSplit[0]);
                String valeurOperation = messageSplit[1];
                int b = Integer.parseInt(messageSplit[2]);
                int res = 0;
                switch (valeurOperation) {
                    case "+":
                        res = calculatrice.addition(a, b);
                        break;
                    case "-":
                        res = calculatrice.soustraction(a, b);
                        break;
                    case "*":
                        res = calculatrice.multiplication(a, b);
                        break;
                    case "/":
                        res = calculatrice.division(a, b);
                        break;                
                    default:
                        break;
                }
                System.out.println(res);
                PrintWriter writer = new PrintWriter(socketClient.getOutputStream(), true);
                writer.println("Le résultat de l'opération : " + res);
                socketClient.close();
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}