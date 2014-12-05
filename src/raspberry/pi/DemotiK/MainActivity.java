package raspberry.pi.DemotiK;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import raspberry.pi.DemotiK.abstractclass.AbstractView;
import raspberry.pi.DemotiK.mainactivity.MainActivityController;
import raspberry.pi.DemotiK.mainactivity.MainActivityModel;

import java.util.Observable;

public class MainActivity extends AbstractView {

    Button switchLED, switchConfig, switchDevices, switchTorrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity_layout);

        initUIFromR();

        MainActivityController ctrl = new MainActivityController(this, new MainActivityModel());
        ctrl.initKeys();
    }

    @Override
    protected void initUIFromR() {
        switchLED = (Button) findViewById(R.id.led);
        switchDevices = (Button) findViewById(R.id.relay);
        switchTorrent = (Button) findViewById(R.id.torrent);
        switchConfig = (Button) findViewById(R.id.config);

    }

    public void addOnClickListenerSwitchLed(View.OnClickListener listener) {
        switchLED.setOnClickListener(listener);
    }

    public void addOnClickListenerSwitchDevices(View.OnClickListener listener) {
        switchDevices.setOnClickListener(listener);
    }

    public void addOnClickListenerSwitchTorrent(View.OnClickListener listener) {
        switchTorrent.setOnClickListener(listener);
    }

    public void addOnClickListenerSwitchConfig(View.OnClickListener listener) {
        switchConfig.setOnClickListener(listener);
    }

    @Override
    public void update(Observable observable, Object data) {

    }

/*
        m_web = new String[]{
                getString(R.string.app_name),
                getString(R.string.led_name),
                getString(R.string.device_name),
                getString(R.string.option_name)
        };

        m_imageId = new Integer[]{
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4
        };

        CustomMenu adapter = new CustomMenu(MainActivity.this, this.m_web, this.m_imageId);
        m_list = (ListView) findViewById(R.id.listView);
        m_list.setAdapter(adapter);
        m_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " + m_web[+position], Toast.LENGTH_SHORT).show();
            }
        });
*/
}
