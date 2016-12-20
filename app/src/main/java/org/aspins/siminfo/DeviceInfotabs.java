package org.aspins.siminfo;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeviceInfotabs extends Fragment {

    private TextView phoneManufactureTxtView;
    private TextView phoneBrandTxtView;
    private TextView phoneModelTxtView;
    private TextView phoneProductTxtView;
    private TextView phoneDisplayTxtView;
    private TextView phoneOSVersionTxtView;
    private TextView phoneHardwareTxtView;
    private TextView phoneBoardTxtView;
    private TextView phoneCPU_ABITxtView;
    private TextView phoneCPU_ABI2TxtView;
    private TextView phoneDeviceTxtView;


    public DeviceInfotabs() {
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
        View rootView = inflater.inflate(R.layout.fragment_device_infotabs, container, false);

        phoneManufactureTxtView = (TextView)rootView.findViewById(R.id.phone_Manufacture_Name);
        phoneManufactureTxtView.setText(Build.MANUFACTURER.toUpperCase());

        phoneBrandTxtView = (TextView)rootView.findViewById(R.id.phone_Brand_Name);
        phoneBrandTxtView.setText(Build.BRAND.toUpperCase());

        phoneModelTxtView = (TextView)rootView.findViewById(R.id.phone_Model_Name);
        phoneModelTxtView.setText(android.os.Build.MODEL);

        phoneProductTxtView = (TextView)rootView.findViewById(R.id.phone_Product_Name);
        phoneProductTxtView.setText(Build.PRODUCT);

        phoneDisplayTxtView = (TextView)rootView.findViewById(R.id.phone_Display_Name);
        phoneDisplayTxtView.setText(Build.DISPLAY);

        phoneOSVersionTxtView = (TextView)rootView.findViewById(R.id.phone_OS_Version_Name);
        phoneOSVersionTxtView.setText(System.getProperty("os.version"));

        phoneHardwareTxtView = (TextView)rootView.findViewById(R.id.phone_Hardware_Name);
        phoneHardwareTxtView.setText(Build.HARDWARE);

        phoneBoardTxtView = (TextView)rootView.findViewById(R.id.phone_Board_Name);
        phoneBoardTxtView.setText(Build.BOARD);

        phoneCPU_ABITxtView = (TextView)rootView.findViewById(R.id.phone_CPU_ABI_Name);
        phoneCPU_ABITxtView.setText(Build.CPU_ABI);

        phoneCPU_ABI2TxtView = (TextView)rootView.findViewById(R.id.phone_CPU_ABI_2_Name);
        phoneCPU_ABI2TxtView.setText(Build.CPU_ABI2);

        phoneDeviceTxtView = (TextView)rootView.findViewById(R.id.phone_Device_Name);
        phoneDeviceTxtView.setText(Build.SERIAL);

        //return inflater.inflate(R.layout.fragment_device_infotabs, container, false);
        return rootView;
    }

}
