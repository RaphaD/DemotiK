package raspberry.pi.DemotiK.activities;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import raspberry.pi.DemotiK.utilities.Network;
import raspberry.pi.DemotiK.utilities.Preferences;

/**
 * Created by fums on 06.12.14.
 */
public abstract class AbstractActivity extends Activity {

    protected static Network mSocket;
    protected final String FLAG_RAW_COMMAND = "[raw_command]";
    protected final String FLAG_GET_STATE = "[get_state]";
    protected Button mMenuButton, mResetConnectionButton;
    protected Preferences mPrefs;

    protected abstract void initKeys();

    protected abstract void connectToInit();

    protected abstract void switchToMenu();

    protected void addListeners() {
        mMenuButton.setOnClickListener(new MenuButtonListener());
        mResetConnectionButton.setOnClickListener(new ResetConnectionButtonListener());
    }

    public void initSocket() {
        mPrefs = new Preferences(this);
        String ipAddress = (String) mPrefs.getValueAt(String.class, "IP_ADDRESS", mPrefs.getDEFAULT_IP());
        int port = (Integer) mPrefs.getValueAt(Integer.class, "PORT", mPrefs.getDEFAULT_PORT());
        mSocket = new Network(ipAddress, port);
    }

    protected class MenuButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switchToMenu();
        }
    }

    protected class ResetConnectionButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            mSocket.resetConnection();
        }
    }
}
