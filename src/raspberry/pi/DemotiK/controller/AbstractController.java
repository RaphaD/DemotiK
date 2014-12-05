package raspberry.pi.DemotiK.controller;

import raspberry.pi.DemotiK.model.AbstractModel;
import raspberry.pi.DemotiK.view.AbstractView;

/**
 * Created by fums on 05.12.14.
 */
public abstract class AbstractController {

    protected AbstractView mView;
    protected AbstractModel mModel;

    public AbstractController(AbstractView view, AbstractModel model) {
        mView = view;
        mModel = model;
    }

    public abstract void initKeys();
}
