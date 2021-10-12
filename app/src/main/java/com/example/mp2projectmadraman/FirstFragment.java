package com.example.mp2projectmadraman;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FirstFragment extends Fragment {

    Button btn_go;
    private NavController navController;

    ArrayList<Plants_> parray;
    Recadapter adapter;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Dataservice service = RetrofitClientInstance.getRestrofitInstance().create(Dataservice.class);

        navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);

        Call<Plants> call = service.getAllPlants();

        call.enqueue(new Callback<Plants>() {
            @Override
            public void onResponse(Call<Plants> call, Response<Plants> response) {
                Plants plants = response.body();

                try {
                    parray = new ArrayList<>(plants.getPlants());
                    generateView(parray,view);

                }catch (NullPointerException e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Plants> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)v.getTag();
            int position = viewHolder.getAdapterPosition();

            Toast.makeText(getActivity().getApplicationContext(),parray.get(position).getName(),Toast.LENGTH_LONG).show();

            Bundle  b = new Bundle();
            b.putParcelable("data",parray.get(position));
            navController.navigate(R.id.secondFragment,b);

        }
    };

    public void generateView(ArrayList<Plants_> pary, View view)
    {
        adapter = new Recadapter(pary,getActivity().getApplicationContext());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);

        RecyclerView recyclerView = view.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(onClickListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


}
