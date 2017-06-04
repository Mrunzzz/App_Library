package com.example.android.pracapp2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.plus.PlusOneButton;


public class Fragment2 extends Fragment {
    Button changeButton;


    public Fragment2() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    container.removeAllViews();
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);


        changeButton = (Button) view.findViewById(R.id.button);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment3 fragment3 = new Fragment3();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.layout, fragment3);
                ft.addToBackStack("new");
                ft.commit();
            }
        });

        return view;
    }


}
