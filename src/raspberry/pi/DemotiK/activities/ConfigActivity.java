package raspberry.pi.DemotiK.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import raspberry.pi.DemotiK.MainActivity;
import raspberry.pi.DemotiK.R;

/**
 * Created by fums on 06.12.14.
 */
public class ConfigActivity extends AbstractActivity {

    private EditText mIpAddressEditText, mPortEditText;
    private Button mConfigSaveButton;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.configactivity_layout);

        initSocket();

        initKeys();
        addListeners();
    }

    @Override
    protected void initKeys() {
        this.mMenuButton = (Button) findViewById(R.id.menuConfig);
        this.mIpAddressEditText = (EditText) findViewById(R.id.ipAdress_editText);
        this.mPortEditText = (EditText) findViewById(R.id.port_editText);
        this.mConfigSaveButton = (Button) findViewById(R.id.configSave_button);
        editKeys();
    }

    @Override
    protected void connectToInit() {
    }

    private void editKeys() {
        String ipAddress = (String) mPrefs.getValueAt(String.class, "IP_ADDRESS", mPrefs.getDEFAULT_IP());
        String port = Integer.toString((Integer) mPrefs.getValueAt(Integer.class, "PORT", mPrefs.getDEFAULT_PORT()));
        this.mIpAddressEditText.setText(ipAddress);
        this.mPortEditText.setText(port);
    }

    @Override
    protected void addListeners() {
        this.mConfigSaveButton.setOnClickListener(new ConfigSaveButton());
        this.mMenuButton.setOnClickListener(new MenuButtonListener());
    }

    @Override
    protected void switchToMenu() {
        Intent mainActivity = new Intent(ConfigActivity.this, MainActivity.class);
        startActivity(mainActivity);
    }

    private class ConfigSaveButton implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String IPAdress = String.valueOf(mIpAddressEditText.getText());
            int port = Integer.parseInt(String.valueOf(mPortEditText.getText()));
            mPrefs.addPreference("IP_ADDRESS", IPAdress);
            mPrefs.addPreference("PORT", port);
        }
    }
}
