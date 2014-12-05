package raspberry.pi.DemotiK.deviceactivity;

import raspberry.pi.DemotiK.abstractclass.AbstractController;
import raspberry.pi.DemotiK.abstractclass.AbstractModel;
import raspberry.pi.DemotiK.abstractclass.AbstractView;

/**
 * Created by fums on 05.12.14.
 */
public class DeviceController extends AbstractController {

    public DeviceController(AbstractView view, AbstractModel model) {
        super(view, model);
    }

    @Override
    public void initKeys() {

    }
}
