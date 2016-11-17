package com.anwesome.uilibs.collapseviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.anwesome.apps.collapseview.CollapseView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CollapseView collapseView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        collapseView = (CollapseView)findViewById(R.id.c_view);
        collapseView.setX(200);
        collapseView.setY(200);
    }
}
