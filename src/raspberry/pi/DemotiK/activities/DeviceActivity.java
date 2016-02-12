package raspberry.pi.DemotiK.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import raspberry.pi.DemotiK.MainActivity;
import raspberry.pi.DemotiK.R;

import java.io.IOException;

/**
 * Created by fums on 06.12.14.
 */
public class DeviceActivity extends AbstractActivity {

    ToggleButton mSonoToggle, mScreenToggle;

    public DeviceActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.deviceactivity_layout);

        initKeys();
        connectToInit();
        addListeners();
    }

    @Override
    protected void initKeys() {
        mMenuButton = (Button) findViewById(R.id.menuDevice);
        mResetConnectionButton = (Button) findViewById(R.id.deviceResetButton);
        mSonoToggle = (ToggleButton) findViewById(R.id.toggleSono);
        mScreenToggle = (ToggleButton) findViewById(R.id.toggleScreen);
    }

    @Override
    protected void connectToInit() {
        try {
            mSocket.writeInSocket(FLAG_SET_STATE_RAW_COMMAND + " sono");
            String sonoValue = mSocket.readFromSocket();
            if (sonoValue.equals("1"))
                mSonoToggle.setChecked(true);
            else
                mSonoToggle.setChecked(false);

            mSocket.writeInSocket(FLAG_SET_STATE_RAW_COMMAND + " screen");
            String screenValue = mSocket.readFromSocket();
            if (screenValue.equals("1"))
                mScreenToggle.setChecked(true);
            else
                mScreenToggle.setChecked(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void addListeners() {
        mMenuButton.setOnClickListener(new MenuButtonListener());
        mResetConnectionButton.setOnClickListener(new ResetConnectionButtonListener());
        mSonoToggle.setOnCheckedChangeListener(new SonoToggleListener());
        mScreenToggle.setOnCheckedChangeListener(new ScreenToggleListener());
    }

    @Override
    protected void switchToMenu() {
        Intent mainActivity = new Intent(DeviceActivity.this, MainActivity.class);
        startActivity(mainActivity);
    }

    private class SonoToggleListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String toWrite = FLAG_SET_STATE_RAW_COMMAND + " sono ";
            if (isChecked)
                toWrite += "1";
            else
                toWrite += "0";
            try {
                mSocket.writeInSocket(toWrite);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ScreenToggleListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String toWrite = FLAG_SET_STATE_RAW_COMMAND + " screen ";
            if (isChecked)
                toWrite += "1";
            else
                toWrite += "0";
            try {
                mSocket.writeInSocket(toWrite);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
