package com.example.lab_1;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;
public class LanguageHelper {

    public static void setLanguage(Context context, String languageCode) {
        Resources resources = context.getResources();
        Configuration config = resources.getConfiguration();
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
}
