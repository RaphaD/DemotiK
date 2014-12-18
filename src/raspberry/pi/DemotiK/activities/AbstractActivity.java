package raspberry.pi.DemotiK.activities;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import raspberry.pi.DemotiK.utilities.Network;

/**
 * Created by fums on 06.12.14.
 */
public abstract class AbstractActivity extends Activity {

    protected Button mMenuButton, mResetConnectionButton;
    protected static Network mSocket;

    public AbstractActivity(){
        try {
            mSocket = new Network();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected abstract void initKeys();

    protected abstract void addListeners();

    protected abstract void switchToMenu();

    public class MenuButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switchToMenu();
        }
    }

    public class ResetConnectionButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            mSocket.resetConnection();
        }
    }
}
