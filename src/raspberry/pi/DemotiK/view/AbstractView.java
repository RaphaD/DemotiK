package raspberry.pi.DemotiK.view;

import android.app.Activity;

import java.util.Observer;

/**
 * Created by fums on 05.12.14.
 */
public abstract class AbstractView extends Activity implements Observer {

    protected abstract void initUIFromR();

}
