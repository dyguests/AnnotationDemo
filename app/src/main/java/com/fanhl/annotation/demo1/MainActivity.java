package com.fanhl.annotation.demo1;

import android.os.Bundle;
import android.renderscript.Int2;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.fanhl.annotation.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();


    @Cache("2333")
    public String id;
    @Cache
    public String name;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        textView = ((TextView) findViewById(R.id.text_view));

        int i = getAnInt();
        String s = getString();
        Int2 i2 = getInt2();

        CacheProvider.bind(this);

        String msg = "id:" + id + " name:" + name;
        Log.e(TAG, msg);
        textView.setText(msg);
    }

    private int getAnInt() {
        return 123;
    }

    @NonNull
    private String getString() {
        return "2333";
    }

    @Nullable
    private Int2 getInt2() {
        return null;
    }
}

class A {
    void a() {
    }

    @CallSuper
    void b() {
    }
}

class B extends A {
    @Override
    void a() {
    }

    @Override
    void b() {
        super.b();
    }
}