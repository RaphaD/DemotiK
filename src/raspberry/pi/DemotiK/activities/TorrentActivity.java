package raspberry.pi.DemotiK.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import raspberry.pi.DemotiK.MainActivity;
import raspberry.pi.DemotiK.R;

/**
 * Created by fums on 06.12.14.
 */
public class TorrentActivity extends AbstractActivity {

    public TorrentActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.torrentactivity_layout);

        initKeys();
        addListeners();
    }

    @Override
    protected void initKeys() {
        mMenuButton = (Button) findViewById(R.id.menuTorrent);
    }

    @Override
    protected void addListeners() {
        mMenuButton.setOnClickListener(new MenuButtonListener());
    }

    @Override
    protected void switchToMenu() {
        Intent mainActivity = new Intent(TorrentActivity.this, MainActivity.class);
        startActivity(mainActivity);
    }
}
