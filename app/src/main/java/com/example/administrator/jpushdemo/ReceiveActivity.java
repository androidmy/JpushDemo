package com.example.administrator.jpushdemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import cn.jpush.android.api.JPushInterface;


public class ReceiveActivity extends ActionBarActivity {

    public TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        text = ((TextView) findViewById(R.id.text));
        Intent intent = getIntent();
        String extra = intent.getStringExtra(JPushInterface.EXTRA_ALERT);
        if(!TextUtils.isEmpty(extra))
        {
            text.setText("收到消息: " + extra);
        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        JPushInterface.onResume(getApplicationContext());
    }
}
