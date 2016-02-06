package raspberry.pi.DemotiK.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import raspberry.pi.DemotiK.MainActivity;
import raspberry.pi.DemotiK.R;

/**
 * Created by fums on 06.12.14.
 */
public class StatisticsActivity extends AbstractActivity {

    public StatisticsActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.statisticsactivity_layout);

        initKeys();
        addListeners();
    }

    @Override
    protected void initKeys() {
        mMenuButton = (Button) findViewById(R.id.statisticsMenuButton);
    }

    @Override
    protected void addListeners() {
        mMenuButton.setOnClickListener(new MenuButtonListener());
    }

    @Override
    protected void switchToMenu() {
        Intent mainActivity = new Intent(StatisticsActivity.this, MainActivity.class);
        startActivity(mainActivity);
    }
}
