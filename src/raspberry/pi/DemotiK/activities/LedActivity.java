package raspberry.pi.DemotiK.activities;

import android.content.Intent;
import android.os.Bundle;
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
        addListeners();
    }

    @Override
    protected void initKeys() {
        mMenuButton = (Button) findViewById(R.id.menu_button);
        mResetConnectionButton = (Button) findViewById(R.id.ledResetConnectionButton);
        mRedSeekBar = (SeekBar) findViewById(R.id.red_bar);
        mGreenSeekBar = (SeekBar) findViewById(R.id.green_bar);
        mBlueSeekBar = (SeekBar) findViewById(R.id.blue_bar);

        mWaveToggle = (ToggleButton) findViewById(R.id.wave_toggle);
        mAllToggle = (ToggleButton) findViewById(R.id.all_toggle);
    }

    @Override
    protected void addListeners() {
        mRedSeekBar.setOnSeekBarChangeListener(new RedBarSeekListener());
        mRedSeekBar.setMax(255);
        mGreenSeekBar.setOnSeekBarChangeListener(new GreenBarSeekListener());
        mGreenSeekBar.setMax(255);
        mBlueSeekBar.setOnSeekBarChangeListener(new BlueBarSeekListener());
        mBlueSeekBar.setMax(255);

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
            String toWrite = "red " + Integer.toString(progress);
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
        }
    }

    private class GreenBarSeekListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            String toWrite = "green " + Integer.toString(progress);
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
        }
    }

    private class BlueBarSeekListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            String toWrite = "blue " + Integer.toString(progress);
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
        }
    }

    private class WaveClickListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String toWrite = "wave ";
            if(isChecked)
                toWrite += "on";
            else
                toWrite += "off";
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
            String toWrite = "all ";
            if(isChecked)
                toWrite += "on";
            else
                toWrite += "off";
            try {
                mSocket.writeInSocket(toWrite);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
