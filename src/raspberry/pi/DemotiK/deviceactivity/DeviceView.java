package raspberry.pi.DemotiK.deviceactivity;

import android.os.Bundle;
import raspberry.pi.DemotiK.R;
import raspberry.pi.DemotiK.abstractclass.AbstractView;

import java.util.Observable;

/**
 * Created by fums on 05.12.14.
 */
public class DeviceView extends AbstractView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deviceactivity_layout);

        initUIFromR();

        DeviceController ctrl = new DeviceController(this, new DeviceModel());
    }

    @Override
    protected void initUIFromR() {

    }

    @Override
    public void update(Observable observable, Object data) {

    }
}