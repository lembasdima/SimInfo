package org.aspins.siminfo;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class BatteryInfo extends Fragment {

    private TextView batteryLevelTxtView;
    private TextView batteryTechnologyTxtView;
    private TextView batteryPluggedTxtView;
    private TextView batteryHealthTxtView;
    private TextView batteryStatusTxtView;
    private TextView batteryVoltageTxtView;
    private TextView batteryTemperatureTxtView;

    public BatteryInfo() {
        // Required empty public constructor
    }

    private BroadcastReceiver batInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int bLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            int bVoltage = intent.getIntExtra("voltage", 0);
            int bTemperature = intent.getIntExtra("temperature", 0);
            double bTemps = (double)bTemperature / 10;

            int bStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            boolean isCharging = bStatus == BatteryManager.BATTERY_STATUS_CHARGING ||
                                 bStatus == BatteryManager.BATTERY_STATUS_FULL;
            if(isCharging == true){
                batteryStatusTxtView.setText("Charging");
            } else {
                batteryStatusTxtView.setText("Discharging");
            }

            int bPlugged = intent.getIntExtra("plugged", 0);
            setPluggerValue(bPlugged);

            String bTechnology = intent.getExtras().getString(BatteryManager.EXTRA_TECHNOLOGY);

            int bHealth = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);
            setBatteryHealthValue(bHealth);

            batteryLevelTxtView.setText(String.valueOf(bLevel) + "%");
            batteryVoltageTxtView.setText(String.valueOf(bVoltage));
            batteryTemperatureTxtView.setText(String.valueOf(bTemps));
            batteryHealthTxtView.setText(getBatteryHealthValue());
            batteryPluggedTxtView.setText(getPluggerValue());
            batteryTechnologyTxtView.setText(bTechnology);
        }
    };

    private String pluggerValue = null;
    public void setPluggerValue(int value){
        String bSetPluggerValue = null;

        switch (value){
            case 1 :
                bSetPluggerValue = "PLUGGED AC";
                break;
            case 2 :
                bSetPluggerValue = "PLUGGED USB";
                break;
            case 4 :
                bSetPluggerValue = "PLUGGED WIRELESS";
                break;
        }
        pluggerValue = bSetPluggerValue;
    }

    public String getPluggerValue(){
        return pluggerValue;
    }

    private String healthStatusValue = null;
    public void setBatteryHealthValue(int status){
        String bHealthStatusValue = null;

        switch (status){
            case 1 :
                bHealthStatusValue = "UNKNOWN";
                break;
            case 2 :
                bHealthStatusValue = "GOOD";
                break;
            case 3 :
                bHealthStatusValue = "OVERHEAT";
                break;
            case 4 :
                bHealthStatusValue = "DEAD";
                break;
            case 5 :
                bHealthStatusValue = "OVER VOLTAGE";
                break;
            case 6 :
                bHealthStatusValue = "UNSPECIFIED FAILURE";
                break;
            case 7 :
                bHealthStatusValue = "COLD";
                break;
        }

        healthStatusValue = bHealthStatusValue;
    }

    public String getBatteryHealthValue(){
        return healthStatusValue;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Context cont = inflater.getContext();
        View rootView = inflater.inflate(R.layout.fragment_battery_info, container, false);

        batteryLevelTxtView = (TextView)rootView.findViewById(R.id.battery_Level_Value);
        cont.registerReceiver(this.batInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        batteryVoltageTxtView = (TextView)rootView.findViewById(R.id.battery_Voltage_Value);
        batteryStatusTxtView = (TextView)rootView.findViewById(R.id.battery_Status_Value);
        batteryTemperatureTxtView = (TextView)rootView.findViewById(R.id.battery_Temperature_Value);
        batteryHealthTxtView = (TextView)rootView.findViewById(R.id.battery_Health_Value);
        batteryPluggedTxtView = (TextView)rootView.findViewById(R.id.battery_Plugged_Value);
        batteryTechnologyTxtView = (TextView)rootView.findViewById(R.id.battery_Technology_Value);

        //return inflater.inflate(R.layout.fragment_battery_info, container, false);
        return rootView;
    }

}
