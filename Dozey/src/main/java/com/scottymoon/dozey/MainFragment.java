package com.scottymoon.dozey;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment implements View.OnClickListener {
    private static String TAG = "Nap";

    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnShortNap = (Button) view.findViewById(R.id.btn_short_nap);
        btnShortNap.setOnClickListener(this);

        Button btnMediumNap = (Button) view.findViewById(R.id.btn_medium_nap);
        btnMediumNap.setOnClickListener(this);

        Button btnLongNap = (Button) view.findViewById(R.id.btn_long_nap);
        btnLongNap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_short_nap:
                loadFragment(new NapFragment(new Nap(Nap.Duration.SHORT)));
                break;
            case R.id.btn_medium_nap:
                loadFragment(new NapFragment(new Nap(Nap.Duration.MEDIUM)));
                break;
            case R.id.btn_long_nap:
                loadFragment(new NapFragment(new Nap(Nap.Duration.LONG)));
                break;
        }
    }

    private void loadFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(TAG)
                .commit();
    }
}
