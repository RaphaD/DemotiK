package raspberry.pi.DemotiK.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by fums on 20.02.15.
 */
public class Preferences {

    private final String DEFAULT_IP = "192.168.1.18";
    private final int DEFAULT_PORT = 9003;
    private SharedPreferences prefs;

    public Preferences(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void addPreference(String preferenceName, Object preferenceToAdd) {
        SharedPreferences.Editor editor = prefs.edit();
        if (preferenceToAdd.getClass().getName().contains("Boolean"))
            editor.putBoolean(preferenceName, (Boolean) preferenceToAdd);
        else if (preferenceToAdd.getClass().getName().contains("Integer"))
            editor.putInt(preferenceName, (Integer) preferenceToAdd);
        else if (preferenceToAdd.getClass().getName().contains("String"))
            editor.putString(preferenceName, (String) preferenceToAdd);
        else if (preferenceToAdd.getClass().getName().contains("Float"))
            editor.putFloat(preferenceName, (Float) preferenceToAdd);
        else if (preferenceToAdd.getClass().getName().contains("Float"))
            editor.putLong(preferenceName, (Long) preferenceToAdd);
        editor.commit();
    }

    public void removePreference(String key) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key);
        editor.commit();
    }

    public String getDEFAULT_IP() {
        return DEFAULT_IP;
    }

    public int getDEFAULT_PORT() {
        return DEFAULT_PORT;
    }

    public Object getValueAt(Class<?> type, String key, Object defaultValue) {
        if (type == Boolean.class) {
            return prefs.getBoolean(key, (Boolean) defaultValue);
        } else if (type == Integer.class) {
            return prefs.getInt(key, (Integer) defaultValue);
        } else if (type == String.class) {
            return prefs.getString(key, (String) defaultValue);
        } else if (type == Float.class) {
            return prefs.getFloat(key, (Float) defaultValue);
        } else if (type == Long.class) {
            return prefs.getLong(key, (Long) defaultValue);
        }
        return null;
    }
}
