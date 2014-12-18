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
    private Socket mSocket = null;

    public Network() {
        InetAddress server = null;
        try {
            server = InetAddress.getByName(mIpAdress);
            System.out.println("server " + server);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            mSocket = new Socket(server, mPort);
            System.out.println("mSocket = ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (mSocket == null)
            System.out.println("[Error - Network - Nework] Socket not initialized !");
    }

    public void writeInSocket(String toWrite) throws IOException, NullPointerException {
        if (mSocket != null) {
            PrintStream outputStream = new PrintStream(mSocket.getOutputStream());
            outputStream.print(toWrite);
        } else {
            System.out.println("[Error - Network - writeInSocket] socket not initialized !");
        }
    }

    public String readFromSocket() throws IOException {
        String toReturn = "";
        if (mSocket != null) {
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
            toReturn = inputStream.readLine();
        } else {
            System.out.println("[Error - Network - readInSocket] socket not initialized !");
        }
        return toReturn;
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
            mSocket = new Socket(server, mPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isInitialized(){
        return (mSocket != null);
    }
}
