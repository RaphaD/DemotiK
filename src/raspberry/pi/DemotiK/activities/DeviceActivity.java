package raspberry.pi.DemotiK.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import raspberry.pi.DemotiK.MainActivity;
import raspberry.pi.DemotiK.R;

/**
 * Created by fums on 06.12.14.
 */
public class DeviceActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.deviceactivity_layout);

        initKeys();
        addListeners();
    }

    @Override
    protected void initKeys() {
        mMenuButton = (Button) findViewById(R.id.menuDevice);
    }

    @Override
    protected void addListeners() {
        mMenuButton.setOnClickListener(new MenuButtonListener());
    }

    @Override
    protected void switchToMenu() {
        Intent mainActivity = new Intent(DeviceActivity.this, MainActivity.class);
        startActivity(mainActivity);
    }
}
