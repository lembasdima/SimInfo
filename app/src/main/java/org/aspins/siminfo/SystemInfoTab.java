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


/**
 * A simple {@link Fragment} subclass.
 */
public class SystemInfoTab extends Fragment {

    private TextView osVersionTxtView;
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
        //return inflater.inflate(R.layout.fragment_system_info_tab, container, false);
        String myDeviceModel = Build.BOARD;
        osVersionTxtView = (TextView)rootView.findViewById(R.id.os_version);
        osVersionTxtView.setText(myDeviceModel);

        return rootView;
    }


}
