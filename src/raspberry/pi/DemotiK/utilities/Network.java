package raspberry.pi.DemotiK.utilities;

import android.util.Log;

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

    private int mPort;
    private String mIpAddress;
    private Socket mSocket = null;

    public Network(String IpAddress, int port) {
        mIpAddress = IpAddress;
        mPort = port;
        InetAddress server = null;
        try {
            server = InetAddress.getByName(mIpAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            mSocket = new Socket(server, mPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (mSocket == null)
            Log.d(null, "[Error - Network - Network] Socket not initialized !");
    }

    public void writeInSocket(String toWrite) throws IOException, NullPointerException {
        if (mSocket != null) {
            PrintStream outputStream = new PrintStream(mSocket.getOutputStream());
            outputStream.print(toWrite);
        } else {
            Log.d("[Error - Network - writeInSocket]", "socket not initialized !");
        }
    }

    public String readFromSocket() throws IOException {
        String toReturn = "";
        if (mSocket != null) {
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
            toReturn = inputStream.readLine();
        } else {
            Log.d("[Error - Network - readInSocket]", "socket not initialized !");
        }
        return toReturn;
    }

    public void resetConnection() {
        InetAddress server = null;
        try {
            server = InetAddress.getByName(mIpAddress);
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
