package raspberry.pi.DemotiK.ledactivity;

import android.os.Bundle;
import raspberry.pi.DemotiK.R;
import raspberry.pi.DemotiK.abstractclass.AbstractView;

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
