package com.logzero.opinionbureau.selection;

import android.os.Bundle;
import android.util.Log;

import com.logzero.opinionbureau.R;
import com.logzero.opinionbureau.utility.BaseActivity;

import org.jetbrains.annotations.Nullable;

public class Selection_Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        Log.d("", "The onCreate() event");
    }
}
