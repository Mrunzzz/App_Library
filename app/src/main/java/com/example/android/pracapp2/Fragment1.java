package com.example.android.pracapp2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.plus.PlusOneButton;

import org.w3c.dom.Text;


public class Fragment1 extends Fragment {
    private Button changeButton;

    public Fragment1() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        container.removeAllViews();
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        TextView tv=(TextView) view.findViewById(R.id.tv);

       tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment2 fragment2=new Fragment2();
                FragmentTransaction ft=getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.layout,fragment2);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        }




}
