package raspberry.pi.DemotiK.controller;

import raspberry.pi.DemotiK.model.AbstractModel;
import raspberry.pi.DemotiK.view.AbstractView;

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
