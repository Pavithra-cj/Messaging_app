package com.aavaros.whatsup.utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {

    private final SharedPreferences sharedPrefernce;

    public PreferenceManager(Context context)
    {

        sharedPrefernce = context.getSharedPreferences(Constants.KEY_PREFERENCE_NAME, Context.MODE_PRIVATE);

    }

    public void putBoolean(String key, Boolean value)
    {

        SharedPreferences.Editor editor = sharedPrefernce.edit();
        editor.putBoolean(key, value);
        editor.apply();

    }

    public Boolean getBoolean(String key)
    {

        return sharedPrefernce.getBoolean(key, false);

    }

    public void putString(String key, String value)
    {

        SharedPreferences.Editor editor = sharedPrefernce.edit();
        editor.putString(key, value);
        editor.apply();

    }

    public String getString(String key)
    {

        return sharedPrefernce.getString(key, null);

    }

    public void clear()
    {

        SharedPreferences.Editor editor = sharedPrefernce.edit();
        editor.clear();
        editor.apply();

    }

}
