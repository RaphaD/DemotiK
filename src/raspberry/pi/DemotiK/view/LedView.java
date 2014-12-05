package raspberry.pi.DemotiK.view;

import android.os.Bundle;
import raspberry.pi.DemotiK.R;
import raspberry.pi.DemotiK.controller.LedController;
import raspberry.pi.DemotiK.model.LedModel;

import java.util.Observable;

/**
 * Created by fums on 05.12.14.
 */
public class LedView extends AbstractView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ledactivity_layout);

        initUIFromR();

        LedController ctrl = new LedController(this, new LedModel());
    }

    @Override
    protected void initUIFromR() {

    }

    @Override
    public void update(Observable observable, Object data) {

    }
}
