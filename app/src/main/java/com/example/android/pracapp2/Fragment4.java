package com.example.android.pracapp2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Fragment4 extends Fragment {
    public Fragment4() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        container.removeAllViewsInLayout();
        View view = inflater.inflate(R.layout.fragment_fragment4, container, false);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
