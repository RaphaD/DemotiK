package raspberry.pi.DemotiK.ledactivity;

import raspberry.pi.DemotiK.abstractclass.AbstractController;
import raspberry.pi.DemotiK.abstractclass.AbstractModel;
import raspberry.pi.DemotiK.abstractclass.AbstractView;

/**
 * Created by fums on 05.12.14.
 */
public class LedController extends AbstractController {
    public LedController(AbstractView view, AbstractModel model) {
        super(view, model);
    }

    @Override
    public void initKeys() {

    }
}
