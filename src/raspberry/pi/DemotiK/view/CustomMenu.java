package raspberry.pi.DemotiK.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import raspberry.pi.DemotiK.R;

/**
 * Created by fums on 23.11.14.
 */
public class CustomMenu extends ArrayAdapter<String> {

    private final Activity m_context;
    private final String[] m_web;
    private final Integer[] m_imageId;

    public CustomMenu(Activity context,
                      String[] web, Integer[] imageId) {
        super(context, R.layout.menu_layout, web);
        this.m_context = context;
        this.m_web = web;
        this.m_imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = m_context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.menu_layout, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(m_web[position]);
        imageView.setImageResource(m_imageId[position]);

        return rowView;
    }
}
