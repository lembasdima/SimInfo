package org.aspins.siminfo;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 */
public class SystemInfoTab extends Fragment {

    private TextView androidOSNameTxtValue;
    private TextView androidVersionTxtView;
    private TextView apiLevelTxtView;
    private TextView bootLoaderTxtView;
    private TextView buildIDTxtView;
    private TextView javaVMTxtView;
    private TextView openGLESTxtView;
    private TextView kernelArchitectureTxtView;
    private TextView kernelVersionTxtView;
    private TextView rootAccessTxtView;


    public SystemInfoTab() {
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
        View rootView = inflater.inflate(R.layout.fragment_system_info_tab, container, false);

        //getAndroidVersion(Build.VERSION.SDK_INT);

        androidOSNameTxtValue = (TextView)rootView.findViewById(R.id.android_OS_Name_Value);
        androidOSNameTxtValue.setText(getAndroidVersion(Build.VERSION.SDK_INT));

        androidVersionTxtView = (TextView)rootView.findViewById(R.id.android_Version_Value);
        androidVersionTxtView.setText(Build.VERSION.RELEASE);

        apiLevelTxtView = (TextView)rootView.findViewById(R.id.api_Level_Value);
        apiLevelTxtView.setText(String.valueOf(Build.VERSION.SDK_INT));

        bootLoaderTxtView = (TextView)rootView.findViewById(R.id.boot_Loader_Value);
        //bootLoaderTxtView.setText();

        buildIDTxtView = (TextView)rootView.findViewById(R.id.build_ID_Value);
        buildIDTxtView.setText(System.getProperty("os.version"));

        javaVMTxtView = (TextView)rootView.findViewById(R.id.java_VM_Value);
        javaVMTxtView.setText(System.getProperty("java.vm.name") + " " + System.getProperty("java.vm.version"));

        openGLESTxtView = (TextView)rootView.findViewById(R.id.open_GL_ES_Value);
        //openGLESTxtView.setText();

        kernelArchitectureTxtView = (TextView)rootView.findViewById(R.id.kernel_Architecture_Value);
        //kernelArchitectureTxtView.setText();


        kernelVersionTxtView = (TextView)rootView.findViewById(R.id.kernel_Version_Value);
        //kernelVersionTxtView.setText();

        rootAccessTxtView = (TextView)rootView.findViewById(R.id.root_Access_Value);
        if (isRooted() == true ){
            rootAccessTxtView.setText("Device Rooted");
        }
        else{
            rootAccessTxtView.setText("Device Unrooted");
        }

        return rootView;
    }

    private static boolean isRooted() {
        return findBinary("su");
    }

    public static boolean findBinary(String binaryName) {
        boolean found = false;
        if (!found) {
            String[] places = { "/sbin/", "/system/bin/", "/system/xbin/",
                    "/data/local/xbin/", "/data/local/bin/",
                    "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/" };
            for (String where : places) {
                if (new File(where + binaryName).exists()) {
                    found = true;

                    break;
                }
            }
        }
        return found;
    }

    /*Get Android Version Name*/
    private String getAndroidVersion(int sdk) {
        switch (sdk) {
            case 1: return "Android 1.0";
            case 2: return "Petit Four (Android 1.1)";
            case 3: return "Cupcake (Android 1.5)";
            case 4: return "Donut (Android 1.6)";
            case 5: return "Eclair (Android 2.0)";
            case 6: return "Eclair (Android 2.0.1)";
            case 7: return "Eclair (Android 2.1)";
            case 8: return "Froyo (Android 2.2)";
            case 9: return "Gingerbread (Android 2.3)";
            case 10: return "Gingerbread (Android 2.3.3)";
            case 11: return "Honeycomb (Android 3.0)";
            case 12: return "Honeycomb (Android 3.1)";
            case 13: return "Honeycomb (Android 3.2)";
            case 14: return "Ice Cream Sandwich (Android 4.0)";
            case 15: return "Ice Cream Sandwich (Android 4.0.3)";
            case 16: return "Jelly Bean (Android 4.1)";
            case 17: return "Jelly Bean (Android 4.2)";
            case 18: return "Jelly Bean (Android 4.3)";
            case 19: return "KitKat (Android 4.4)";
            case 20: return "KitKat Watch (Android 4.4)";
            case 21: return "Lollipop (Android 5.0)";
            case 22: return "Lollipop (Android 5.1)";
            case 23: return "Marshmallow (Android 6.0)";
            case 24: return "Nougat (Android 7.0)";
            case 25: return "Nougat (Android 7.1.1)";
            default: return "";
        }
    }


}
