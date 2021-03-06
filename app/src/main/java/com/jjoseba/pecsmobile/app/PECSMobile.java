package com.jjoseba.pecsmobile.app;

import android.app.Application;
import com.jjoseba.pecsmobile.R;
import com.jjoseba.pecsmobile.util.FileUtils;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

public class PECSMobile extends Application {

    public static final int DISPLAY_MODE_CARDS = 1;
    public static final int DISPLAY_MODE_TEXT = 2;
    public static final int DISPLAY_MODE_BASIC = 3;

    public static final boolean DEFAULT_SHOW_NEWCARD_BUTTON = true;
    public static final boolean DEFAULT_SHOW_TEMPTEXT_BUTTON = true;
    public static int DEFAULT_DISPLAY_MODE = DISPLAY_MODE_CARDS;

    @Override
    public void onCreate() {
        super.onCreate();

        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/billy.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());

        //We set the StoragePath
        FileUtils.initialize(getApplicationContext());
    }

}
