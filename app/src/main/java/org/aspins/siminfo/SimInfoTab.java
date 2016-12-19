package org.aspins.siminfo;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimInfoTab extends Fragment {

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

    Context cont;

    public SimInfoTab() {
        // Required empty public constructor
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
        TelephonyManager tm = (TelephonyManager) cont.getSystemService(Context.TELEPHONY_SERVICE);
        String phoneNumber = tm.getLine1Number();
        String simSerialNumber = tm.getSimSerialNumber();
        String countryCode = tm.getSimCountryIso();
        int simState = tm.getSimState();
        String simOperatorCode = tm.getSimOperator();
        String simOperatorName = tm.getNetworkOperatorName();


        View rootView = inflater.inflate(R.layout.fragment_sim_info_tab, container, false);

        simSeriaNumberTxtView  = (TextView)rootView.findViewById(R.id.phone_Number_Digital);
        simSeriaNumberTxtView.setText(phoneNumber);

        simSeriaNumberTxtView = (TextView)rootView.findViewById(R.id.sim_Serial_Number_Digital);
        simSeriaNumberTxtView.setText(simSerialNumber);

        countryCodeTxtView = (TextView)rootView.findViewById(R.id.sim_Country_Code_Text);
        countryCodeTxtView.setText(countryCode);

        simStateTxtView = (TextView)rootView.findViewById(R.id.sim_State_Digital);
        simStateTxtView.setText(String.valueOf(simState));


        simOperatorCodeTxtView = (TextView)rootView.findViewById(R.id.sim_Operator_Code_Text);
        simOperatorCodeTxtView.setText(simOperatorCode);


        simOperatorNetworkTxtView = (TextView)rootView.findViewById(R.id.sim_Operator_Name_Text);
        simOperatorNetworkTxtView.setText(simOperatorName);




        simIMSI = (TextView)rootView.findViewById(R.id.sim_IMSI_Digital);
        simIMSI.setText(String.valueOf(tm.getSubscriberId()));

        voiceMailTextIDTxtView = (TextView)rootView.findViewById(R.id.voice_Mail_Text_ID_Digital);
        voiceMailTextIDTxtView.setText(tm.getVoiceMailAlphaTag());

        voiceMailNumberTxtView = (TextView)rootView.findViewById(R.id.voice_Mail_Number_Digital);
        voiceMailNumberTxtView.setText(tm.getVoiceMailNumber());

        phoneTypeTxtView = (TextView)rootView.findViewById(R.id.phone_Type_Text);
        setPhoneTypeName(tm.getPhoneType());
        phoneTypeTxtView.setText(getPhoneTypeName());

        deviceIMEITxtView = (TextView)rootView.findViewById(R.id.device_IMEI_Digital);
        deviceIMEITxtView.setText(String.valueOf(tm.getDeviceId()));


        //return inflater.inflate(R.layout.fragment_sim_info_tab, container, false);
        return rootView;
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
