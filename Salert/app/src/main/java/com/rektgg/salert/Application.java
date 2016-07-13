package com.rektgg.salert;

import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

/**
 * Created by Justin on 5/11/2016.
 */
public class Application extends android.app.Application{

    private static ConfigHelper configHelper;

    public Application() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(DealPost.class);
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("APPLICATION_ID")
                .clientKey(null)
                .server("http://10.1.92.42:1337/parse/")
                .build()
        );

        configHelper = new ConfigHelper();
        configHelper.fetchConfigIfNeeded();

/*        Log.d("here", "app");

        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("APPLICATION_ID")
                .clientKey("apple")
                .server("http://10.1.92.89:1337/parse/")


                .build()
        );*/

/*        ParseObject gameScore = new ParseObject("GameScore");
        gameScore.put("score", 1337);
        gameScore.put("playerName", "Sean Plott");
        gameScore.put("cheatMode", false);
        gameScore.saveInBackground(new SaveCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Log.i("Parse", "Save Succeeded");
                } else {
                    Log.i("Parse", "Save Failed");
                    e.getMessage();
                }
            }
        });*/
    }

    public static ConfigHelper getConfigHelper() {
        return configHelper;
    }

}
