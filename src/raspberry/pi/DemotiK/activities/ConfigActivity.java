package raspberry.pi.DemotiK.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import raspberry.pi.DemotiK.MainActivity;
import raspberry.pi.DemotiK.R;

/**
 * Created by fums on 06.12.14.
 */
public class ConfigActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {

        System.out.println("onCreate");

        super.onCreate(savedInstance);
        setContentView(R.layout.configactivity_layout);

        initKeys();
        addListeners();
    }

    @Override
    protected void initKeys() {
        this.mMenuButton = (Button) findViewById(R.id.menuConfig);
    }

    @Override
    protected void addListeners() {
        this.mMenuButton.setOnClickListener(new MenuButtonListener());
    }

    @Override
    protected void switchToMenu() {
        System.out.println("switchToMenu");
        Intent mainActivity = new Intent(ConfigActivity.this, MainActivity.class);
        startActivity(mainActivity);
    }
}
