/*
 * Copyright (C) 2019 Rebellion-OS
 * Copyright (C) 2019 Ancient-OS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;

import androidx.annotation.VisibleForTesting;

import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.core.BasePreferenceController;

public class AncientBuildTypePreferenceController extends BasePreferenceController {

    @VisibleForTesting
    static final String ANCIENT_BUILD_TYPE_PROPERTY = "ro.ancient.build_type";

    public AncientBuildTypePreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return !TextUtils.isEmpty(SystemProperties.get(ANCIENT_BUILD_TYPE_PROPERTY)) ? AVAILABLE : UNSUPPORTED_ON_DEVICE;
    }

    @Override
    public CharSequence getSummary() {
        return SystemProperties.get(ANCIENT_BUILD_TYPE_PROPERTY,
                mContext.getString(R.string.device_info_default));
    }
}
