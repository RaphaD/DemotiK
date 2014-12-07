package raspberry.pi.DemotiK.activities;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import raspberry.pi.DemotiK.utilities.Network;

/**
 * Created by fums on 06.12.14.
 */
public abstract class AbstractActivity extends Activity {

    protected Button mMenuButton;
    protected static Network mSocket = new Network();

    protected abstract void initKeys();

    protected abstract void addListeners();

    protected abstract void switchToMenu();

    public class MenuButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            System.out.println("onClickListener MenuButtonListener");
            switchToMenu();
        }
    }
}
