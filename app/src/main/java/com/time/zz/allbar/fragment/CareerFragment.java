package com.time.zz.allbar.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.time.zz.allbar.R;

/**
 * Created by admin on 2017/3/28.
 */
public class CareerFragment extends android.support.v4.app.Fragment {
    private Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context=getActivity();
        View view= View.inflate(context, R.layout.career_activity,null);
        return view;
    }
}
