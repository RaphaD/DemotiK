package raspberry.pi.DemotiK.abstractclass;

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
