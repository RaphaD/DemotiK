package raspberry.pi.DemotiK;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import raspberry.pi.DemotiK.activities.*;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AbstractActivity {

    static final int check = 69;
    Button mVoiceButton, mLedButton, mConfigButton, mTorrentButton, mDeviceButton, mAskButton;
    EditText mAskEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity_layout);

        super.initSocket();

        initKeys();
        addListeners();
    }

    @Override
    protected void initKeys() {
        mLedButton = (Button) findViewById(R.id.led);
        mConfigButton = (Button) findViewById(R.id.config);
        mTorrentButton = (Button) findViewById(R.id.torrent);
        mDeviceButton = (Button) findViewById(R.id.device);
        mMenuButton = (Button) findViewById(R.id.menuMenu);
        mResetConnectionButton = (Button) findViewById(R.id.resetConnectionButton);
//        mVoiceButton = (Button) findViewById(R.id.voice);
        mAskEditText = (EditText) findViewById(R.id.viaacInput_editText);
        mAskButton = (Button) findViewById(R.id.askViaac_button);
    }

    @Override
    protected void addListeners() {
        super.addListeners();
//        mVoiceButton.setOnClickListener(new VoiceButtonListener());
        mLedButton.setOnClickListener(new LedButtonListener());
        mConfigButton.setOnClickListener(new ConfigButtonListener());
        mTorrentButton.setOnClickListener(new TorrentButtonListener());
        mDeviceButton.setOnClickListener(new DeviceButtonListener());
        mAskButton.setOnClickListener(new AskButtonListener());
    }

    @Override
    protected void switchToMenu() {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == check) && (resultCode == RESULT_OK)) {
            ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            try {
                mSocket.writeInSocket(results.get(0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class VoiceButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Listenning");
            startActivityForResult(i, check);
        }
    }

    private class LedButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent ledActivityIntent = new Intent(MainActivity.this, LedActivity.class);
            startActivity(ledActivityIntent);
        }
    }

    private class ConfigButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent configActivity = new Intent(MainActivity.this, ConfigActivity.class);
            startActivity(configActivity);
        }
    }

    private class TorrentButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent torrentActivity = new Intent(MainActivity.this, TorrentActivity.class);
            startActivity(torrentActivity);
        }
    }

    private class DeviceButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent deviceActivity = new Intent(MainActivity.this, DeviceActivity.class);
            startActivity(deviceActivity);
        }
    }

    private class AskButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String asked = String.valueOf(mAskEditText.getText());
            try {
                mSocket.writeInSocket(asked);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
