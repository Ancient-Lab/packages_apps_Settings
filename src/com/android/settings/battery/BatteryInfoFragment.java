/*
 * Copyright (C) 2018 The Android Open Source Project
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

package com.android.settings.battery;


import android.app.Activity;
import android.content.Context;

import com.android.internal.logging.nano.MetricsProto.MetricsEvent;
import com.android.settings.R;
import com.android.settings.dashboard.DashboardFragment;
import com.android.settings.battery.BatteryHealthPreferenceController;
import com.android.settings.battery.BatteryStatusPreferenceController;
import com.android.settings.battery.BatteryTechPreferenceController;
import com.android.settings.battery.ChargeCyclePreferenceController;
import com.android.settings.battery.CapacityPreferenceController;
import com.android.settings.battery.ChargeFullDesignPreferenceController;
import com.android.settings.battery.ChargeFullPreferenceController;
import com.android.settings.battery.ChargeTypePreferenceController;
import com.android.settings.battery.CurrentMaxPreferenceController;
import com.android.settings.battery.CurrentPreferenceController;
import com.android.settings.battery.OriginalBatteryCapacityPreferenceController;
import com.android.settings.battery.QcomBatteryVersionPreferenceController;
import com.android.settings.battery.SysTempLevelPreferenceController;
import com.android.settings.battery.VoltageMaxPreferenceController;
import com.android.settings.battery.VoltagePreferenceController;

import com.android.settingslib.core.AbstractPreferenceController;

import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BatteryInfoFragment extends DashboardFragment {

    private static final String LOG_TAG = "BatteryInfoFragment";

    @Override
    public int getMetricsCategory() {
        return MetricsEvent.ANCIENT_SETTINGS;
    }

    @Override
    protected String getLogTag() {
        return LOG_TAG;
    }

    @Override
    protected int getPreferenceScreenResId() {
        return R.xml.battery_info;
    }

    @Override
    protected List<AbstractPreferenceController> createPreferenceControllers(Context context) {
        return buildPreferenceControllers(context, getActivity(), this /* fragment */,
                getLifecycle());
    }

    private static List<AbstractPreferenceController> buildPreferenceControllers(
            Context context,
            Activity activity,
            BatteryInfoFragment fragment,
            Lifecycle lifecycle) {
        final List<AbstractPreferenceController> controllers = new ArrayList<>();
        controllers.add(new BatteryHealthPreferenceController(context));
        controllers.add(new BatteryStatusPreferenceController(context));
        controllers.add(new BatteryTechPreferenceController(context));
        controllers.add(new ChargeCyclePreferenceController(context));
        controllers.add(new ChargeFullDesignPreferenceController(context));
        controllers.add(new ChargeFullPreferenceController(context));
        controllers.add(new ChargeTypePreferenceController(context));
        controllers.add(new CapacityPreferenceController(context));
        controllers.add(new CurrentMaxPreferenceController(context));
        controllers.add(new CurrentPreferenceController(context));
        controllers.add(new OriginalBatteryCapacityPreferenceController(context));
        controllers.add(new QcomBatteryVersionPreferenceController(context));
        controllers.add(new SysTempLevelPreferenceController(context));
        controllers.add(new VoltageMaxPreferenceController(context));
        controllers.add(new VoltagePreferenceController(context));
        return controllers;
    }

}
