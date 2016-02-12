package raspberry.pi.DemotiK.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;
import raspberry.pi.DemotiK.MainActivity;
import raspberry.pi.DemotiK.R;

import java.io.IOException;

/**
 * Created by fums on 06.12.14.
 */
public class LedActivity extends AbstractActivity {

    SeekBar mRedSeekBar, mGreenSeekBar, mBlueSeekBar;
    ToggleButton mWaveToggle, mAllToggle;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.ledactivity_layout);

        initKeys();
        connectToInit();
        addListeners();
    }

    @Override
    protected void initKeys() {
        mMenuButton = (Button) findViewById(R.id.menu_button);
        mResetConnectionButton = (Button) findViewById(R.id.ledResetConnectionButton);
        mRedSeekBar = (SeekBar) findViewById(R.id.red_bar);
        mRedSeekBar.setMax(255);
        mGreenSeekBar = (SeekBar) findViewById(R.id.green_bar);
        mGreenSeekBar.setMax(255);
        mBlueSeekBar = (SeekBar) findViewById(R.id.blue_bar);
        mBlueSeekBar.setMax(255);

        mWaveToggle = (ToggleButton) findViewById(R.id.wave_toggle);
        mAllToggle = (ToggleButton) findViewById(R.id.all_toggle);
    }

    @Override
    protected void connectToInit() {
        try {
            mSocket.writeInSocket(FLAG_GET_STATE + " red");
            int redValue = Integer.parseInt(mSocket.readFromSocket());
            mRedSeekBar.setProgress(redValue);

            mSocket.writeInSocket(FLAG_GET_STATE + " green");
            int greenValue = Integer.parseInt(mSocket.readFromSocket());
            mGreenSeekBar.setProgress(greenValue);

            mSocket.writeInSocket(FLAG_GET_STATE + " blue");
            int blueValue = Integer.parseInt(mSocket.readFromSocket());
            mBlueSeekBar.setProgress(blueValue);

            mSocket.writeInSocket(FLAG_GET_STATE + " all");
            String allValue = mSocket.readFromSocket();
            if (allValue.equals("1"))
                mAllToggle.setChecked(true);
            else
                mAllToggle.setChecked(false);

            mSocket.writeInSocket((FLAG_GET_STATE + " wave"));
            String waveValue = mSocket.readFromSocket();
            if (waveValue.equals("1"))
                mWaveToggle.setChecked(true);
            else
                mWaveToggle.setChecked(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void addListeners() {
        mRedSeekBar.setOnSeekBarChangeListener(new RedBarSeekListener());
        mGreenSeekBar.setOnSeekBarChangeListener(new GreenBarSeekListener());
        mBlueSeekBar.setOnSeekBarChangeListener(new BlueBarSeekListener());

        mWaveToggle.setOnCheckedChangeListener(new WaveClickListener());
        mAllToggle.setOnCheckedChangeListener(new AllClickListener());

        mMenuButton.setOnClickListener(new MenuButtonListener());
        mResetConnectionButton.setOnClickListener(new ResetConnectionButtonListener());
    }

    @Override
    protected void switchToMenu() {
        Intent mainActivity = new Intent(LedActivity.this, MainActivity.class);
        startActivity(mainActivity);
    }

    private class RedBarSeekListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            String toWrite = FLAG_RAW_COMMAND + " red " + Integer.toString(progress);
            try {
                mSocket.writeInSocket(toWrite);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            if(! mSocket.isInitialized()){
                Log.d("[Error - Network - writeInSocket]", "RED socket used uninitialized");
            } else {
                String toSave = FLAG_SET_STATE_RAW_COMMAND + " red " + Integer.toString(seekBar.getProgress());
                try {
                    mSocket.writeInSocket(toSave);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class GreenBarSeekListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            String toWrite = FLAG_RAW_COMMAND + " green " + Integer.toString(progress);
            try {
                mSocket.writeInSocket(toWrite);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            if(! mSocket.isInitialized()){
                Log.d("[Error - Network - writeInSocket]", "GREEN socket used uninitialized");
            } else {
                String toSave = FLAG_SET_STATE_RAW_COMMAND + " green " + Integer.toString(seekBar.getProgress());
                try {
                    mSocket.writeInSocket(toSave);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class BlueBarSeekListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            String toWrite = FLAG_RAW_COMMAND + " blue " + Integer.toString(progress);
            try {
                mSocket.writeInSocket(toWrite);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            if(! mSocket.isInitialized()){
                Log.d("[Error - Network - writeInSocket]", "BLUE socket used uninitialized");
            } else {
                String toSave = FLAG_SET_STATE_RAW_COMMAND + " blue " + Integer.toString(seekBar.getProgress());
                try {
                    mSocket.writeInSocket(toSave);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class WaveClickListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String toWrite = FLAG_SET_STATE_RAW_COMMAND + " wave ";
            if(isChecked)
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

    private class AllClickListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String toWrite = FLAG_SET_STATE_RAW_COMMAND + " all ";
            if(isChecked)
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
