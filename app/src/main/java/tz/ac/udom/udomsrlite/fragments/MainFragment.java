package tz.ac.udom.udomsrlite.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tz.ac.udom.udomsrlite.R;
import tz.ac.udom.udomsrlite.adapters.ModulesMenuAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private RecyclerView recyclerView;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = fragmentView.findViewById(R.id.recyclerView);

        // manager
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        // adapter
        ModulesMenuAdapter adapter = new ModulesMenuAdapter(getContext());
        recyclerView.setAdapter(adapter);

        return fragmentView;
    }

}
