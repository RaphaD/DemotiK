package raspberry.pi.DemotiK.mainactivity;

import android.view.View;
import raspberry.pi.DemotiK.MainActivity;
import raspberry.pi.DemotiK.abstractclass.AbstractController;
import raspberry.pi.DemotiK.abstractclass.AbstractModel;
import raspberry.pi.DemotiK.abstractclass.AbstractView;

/**
 * Created by fums on 05.12.14.
 */
public class MainActivityController extends AbstractController {

    public MainActivityController(AbstractView view, AbstractModel model) {
        super(view, model);
    }

    @Override
    public void initKeys() {
        ((MainActivity) mView).addOnClickListenerSwitchLed(new SwitchLedClickListener());
        ((MainActivity) mView).addOnClickListenerSwitchDevices(new SwitchRelayClickListener());
        ((MainActivity) mView).addOnClickListenerSwitchTorrent(new SwitchTorrentClickListener());
        ((MainActivity) mView).addOnClickListenerSwitchConfig(new SwitchConfigClickListener());
    }

    private class SwitchLedClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }

    private class SwitchRelayClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }

    private class SwitchTorrentClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }

    private class SwitchConfigClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
