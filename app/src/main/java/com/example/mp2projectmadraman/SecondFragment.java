package com.example.mp2projectmadraman;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class SecondFragment extends Fragment {


    ImageView imgv;
    TextView txt_pname,txt_ftr,txt_habit,txt_exposure,txt_water,txt_lifespan, txt_species;

    private NavController navController;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
        Plants_ p = getArguments().getParcelable("data");

        imgv = view.findViewById(R.id.pkd_imgv);
        txt_pname = view.findViewById(R.id.pkd_txtpname);
        txt_ftr = view.findViewById(R.id.pkd_txtpdesc);
        txt_lifespan = view.findViewById(R.id.pkd_txtpability);
        txt_habit = view.findViewById(R.id.pkd_txtptype);
        txt_exposure = view.findViewById(R.id.pkd_txtpheight);
        txt_water = view.findViewById(R.id.pkd_txtpweight);
        txt_species = view.findViewById(R.id.pkd_txtpspecies);

        genView(p);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
    public void genView(Plants_ p)
    {
        Picasso.get().load(p.getImage()).into(imgv);
        txt_pname.setText(p.getName());
        txt_ftr.setText(p.getFeatures());
        txt_habit.setText("Habit : "+p.getHabit());
        txt_lifespan.setText("Lifespan : "+p.getLifespan());
        txt_exposure.setText("Exposure : "+p.getExposure());
        txt_water.setText("Water : "+p.getWater());
        txt_species.setText("Species : "+p.getSpecies());

    }



}
