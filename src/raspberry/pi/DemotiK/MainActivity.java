package raspberry.pi.DemotiK;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import raspberry.pi.DemotiK.vue.CustomMenu;

public class MainActivity extends Activity {
    ListView m_list;
    String[] m_web = null;
    Integer[] m_imageId = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity_layout);

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
    }
}
