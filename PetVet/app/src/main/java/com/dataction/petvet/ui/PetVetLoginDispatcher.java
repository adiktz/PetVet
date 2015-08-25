package com.dataction.petvet.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.dataction.petvet.LoginActivity;
import com.parse.Parse;

/**
 * Created by GRavi on 25-08-2015.
 */
public abstract class PetVetLoginDispatcher extends Activity {

    protected abstract Class<?> getTargetClass();

    private static final int LOGIN_REQUEST = 0;
    private static final int TARGET_REQUEST = 1;

    private static final String LOG_TAG = "ParseLoginDispatch";

    @Override
    final protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        runDispatch();
    }

    @Override
    final protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        setResult(resultCode);
        if (requestCode == LOGIN_REQUEST && resultCode == RESULT_OK) {
            runDispatch();
        } else {
            finish();
        }
    }

    /**
     * Override this to generate a customized intent for starting ParseLoginActivity.
     * However, the preferred method for configuring Parse Login UI components is by
     * specifying activity options in AndroidManifest.xml, not by overriding this.
     *
     * @return Intent that can be used to start ParseLoginActivity
     */
    protected Intent getLoginIntent() {
        Intent intent = new Intent(this, LoginActivity.class);
    //    intent.putExtras(config.toBundle());
        return intent;
    }

    private void runDispatch() {
        //TODO : Implement logic to check if the user is logged in or not.
        if (1 != 2) {

            startActivityForResult(new Intent(this, getTargetClass()), TARGET_REQUEST);
        } else {

            startActivityForResult(getLoginIntent(), LOGIN_REQUEST);
        }
    }

    private void debugLog(String message) {
        if (Parse.getLogLevel() <= Parse.LOG_LEVEL_DEBUG &&
                Log.isLoggable(LOG_TAG, Log.DEBUG)) {
            Log.d(LOG_TAG, message);
        }
    }
}