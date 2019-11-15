
package com.android.settings.deviceinfo;

import android.os.SystemProperties;

public class VersionUtils {
    public static String getAncientVersion(){
        return SystemProperties.get("ro.ancient.version.display","");
    }
}
