package raspberry.pi.DemotiK.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by fums on 07.12.14.
 */
public class Network {

    private final static int mPort = 9003;
    private final static String mIpAdress = "10.0.0.65";
    private Socket socket = null;

    public Network() {
        InetAddress server = null;
        try {
            server = InetAddress.getByName(mIpAdress);
            System.out.println("server " + server);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            socket = new Socket(server, mPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeInSocket(String toWrite) throws IOException {
        System.out.println("socket " + socket);
        PrintStream outputStream = new PrintStream(socket.getOutputStream());
        outputStream.print(toWrite);
    }

    public String readFromSocket() throws IOException {
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return inputStream.readLine();
    }

    public void resetConnection() {
        InetAddress server = null;
        try {
            server = InetAddress.getByName(mIpAdress);
            System.out.println("server " + server);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            socket = new Socket(server, mPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
