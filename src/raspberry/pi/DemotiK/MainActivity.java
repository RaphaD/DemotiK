package raspberry.pi.DemotiK;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import raspberry.pi.DemotiK.activities.*;

public class MainActivity extends AbstractActivity {

    Button mLedButton, mConfigButton, mTorrentButton, mDeviceButton;

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
        mMenuButton = (Button) findViewById(R.id.menu);
        mResetConnectionButton = (Button) findViewById(R.id.resetConnectionButton);
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        mLedButton.setOnClickListener(new LedButtonListener());
        mConfigButton.setOnClickListener(new ConfigButtonListener());
        mTorrentButton.setOnClickListener(new TorrentButtonListener());
        mDeviceButton.setOnClickListener(new DeviceButtonListener());
    }

    @Override
    protected void switchToMenu() {
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

}
