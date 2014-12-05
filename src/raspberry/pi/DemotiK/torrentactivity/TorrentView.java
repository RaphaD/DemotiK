package raspberry.pi.DemotiK.torrentactivity;

import android.os.Bundle;
import raspberry.pi.DemotiK.R;
import raspberry.pi.DemotiK.abstractclass.AbstractView;

import java.util.Observable;

/**
 * Created by fums on 05.12.14.
 */
public class TorrentView extends AbstractView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ledactivity_layout);

        initUIFromR();

        TorrentController ctrl = new TorrentController(this, new TorrentModel());
    }

    @Override
    protected void initUIFromR() {

    }

    @Override
    public void update(Observable observable, Object data) {

    }
}
