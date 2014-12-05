package raspberry.pi.DemotiK.configactivity;

import android.os.Bundle;
import raspberry.pi.DemotiK.R;
import raspberry.pi.DemotiK.abstractclass.AbstractView;

import java.util.Observable;

/**
 * Created by fums on 05.12.14.
 */
public class ConfigView extends AbstractView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configactivity_layout);

        initUIFromR();

        ConfigController ctrl = new ConfigController(this, new ConfigModel());
    }

    @Override
    protected void initUIFromR() {

    }

    @Override
    public void update(Observable observable, Object data) {

    }
}
