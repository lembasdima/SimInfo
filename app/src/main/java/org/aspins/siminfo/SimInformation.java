package org.aspins.siminfo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.widget.TextView;

/**
 * Created by Tateeda on 12/19/2016.
 */

public class SimInformation extends AppCompatActivity{

    private TextView phoneNumberTxtView;
    private TextView countryCodeTxtView;
    private TextView simStateTxtView;
    private TextView simSeriaNumberTxtView;
    private TextView simOperatorCodeTxtView;
    private TextView simIMSI;
    private TextView simOperatorNetworkTxtView;
    private TextView voiceMailTextIDTxtView;
    private TextView voiceMailNumberTxtView;
    private TextView phoneTypeTxtView;
    private TextView deviceIMEITxtView;

    private int pID;
    private String pPT;

    public SimInformation(){

    }

    public void getSimInformation(Context contect){
        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        String phoneNumber = tm.getLine1Number();
        phoneNumberTxtView = (TextView)findViewById(R.id.phone_Number_Digital);
        phoneNumberTxtView.setText(phoneNumber);

        String simSerialNumber = tm.getSimSerialNumber();
        simSeriaNumberTxtView = (TextView)findViewById(R.id.sim_Serial_Number_Digital);
        simSeriaNumberTxtView.setText(simSerialNumber);

        String countryCode = tm.getSimCountryIso();
        countryCodeTxtView = (TextView)findViewById(R.id.sim_Country_Code_Text);
        countryCodeTxtView.setText(countryCode);

        int simState = tm.getSimState();

        simStateTxtView = (TextView)findViewById(R.id.sim_State_Digital);
        simStateTxtView.setText(String.valueOf(simState));

        String simOperatorCode = tm.getSimOperator();
        simOperatorCodeTxtView = (TextView)findViewById(R.id.sim_Operator_Code_Text);
        simOperatorCodeTxtView.setText(simOperatorCode);

        String simOperatorName = tm.getNetworkOperatorName();
        simOperatorNetworkTxtView = (TextView)findViewById(R.id.sim_Operator_Name_Text);
        simOperatorNetworkTxtView.setText(simOperatorName);

        simIMSI = (TextView)findViewById(R.id.sim_IMSI_Digital);
        simIMSI.setText(String.valueOf(tm.getSubscriberId()));

        voiceMailTextIDTxtView = (TextView)findViewById(R.id.voice_Mail_Text_ID_Digital);
        voiceMailTextIDTxtView.setText(tm.getVoiceMailAlphaTag());

        voiceMailNumberTxtView = (TextView)findViewById(R.id.voice_Mail_Number_Digital);
        voiceMailNumberTxtView.setText(tm.getVoiceMailNumber());

        phoneTypeTxtView = (TextView)findViewById(R.id.phone_Type_Text);
        setPhoneTypeName(tm.getPhoneType());
        phoneTypeTxtView.setText(getPhoneTypeName());

        deviceIMEITxtView = (TextView)findViewById(R.id.device_IMEI_Digital);
        deviceIMEITxtView.setText(String.valueOf(tm.getDeviceId()));
    }

    public void setPhoneTypeName(int id){
        this.pID = id;

        switch (pID) {
            case 0:
                pPT = "UNKNOWN";
                break;
            case 1:
                pPT = "GSM";
                break;
            case 2:
                pPT = "CDMA";
                break;
            case 3:
                pPT = "SIP";
                break;
        }
    }

    public String getPhoneTypeName(){
        return pPT;
    }

}
