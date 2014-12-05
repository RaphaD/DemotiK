package raspberry.pi.DemotiK.view;

import android.os.Bundle;
import raspberry.pi.DemotiK.R;
import raspberry.pi.DemotiK.controller.DeviceController;
import raspberry.pi.DemotiK.model.DeviceModel;

import java.util.Observable;

/**
 * Created by fums on 05.12.14.
 */
public class DeviceView extends AbstractView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deviceactivity_layout);

        DeviceController ctrl = new DeviceController(this, new DeviceModel());

        initUIFromR();
    }

    @Override
    protected void initUIFromR() {

    }

    @Override
    public void update(Observable observable, Object data) {

    }
}
