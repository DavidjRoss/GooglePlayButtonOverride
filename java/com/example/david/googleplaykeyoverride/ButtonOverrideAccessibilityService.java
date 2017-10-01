package com.example.david.googleplaykeyoverride;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;


/**
 * Created by David on 9/29/2017.
 */
public class ButtonOverrideAccessibilityService extends AccessibilityService {
    static final String plexPackage = "com.plexapp.android";

    // Do some setup stuff when the app is started.
    @Override
    protected void onServiceConnected(){
    }

    // Required override for accessibility service
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
    }

    // Required override for accessibility service
    @Override
    public void onInterrupt(){
    }

    @Override
    public boolean onKeyEvent(KeyEvent event){
        int key = event.getKeyCode();
        // This is button #195, the button that is mapped to "Google Play" on sony x900e remote
        if(key == KeyEvent.KEYCODE_BUTTON_8) {
            Intent startPlex = getPackageManager().getLaunchIntentForPackage(plexPackage);
            startPlex.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (startPlex != null) {
                this.startActivity(startPlex);
            }
            return true;
        }
        return super.onKeyEvent(event);
    }
}
