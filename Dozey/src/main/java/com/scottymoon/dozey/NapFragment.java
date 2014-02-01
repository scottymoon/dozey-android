package com.scottymoon.dozey;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NapFragment extends Fragment {
    private Nap mNap;

    public NapFragment(Nap nap) {
        mNap = nap;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_nap, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.setBackgroundColor(getColor());

        TextView tvTime = (TextView) view.findViewById(R.id.tv_time);
        tvTime.setText(mNap.getPrettyTime());
    }

    private int getColor() {
        int color = getResources().getColor(R.color.custom_nap);
        Nap.Duration duration = mNap.getDuration();

        if (duration != null) {
            switch (duration) {
                case SHORT:
                    color = getResources().getColor(R.color.short_nap);
                    break;
                case MEDIUM:
                    color = getResources().getColor(R.color.medium_nap);
                    break;
                case LONG:
                    color = getResources().getColor(R.color.long_nap);
                    break;
            }
        }

        return color;
    }
}
