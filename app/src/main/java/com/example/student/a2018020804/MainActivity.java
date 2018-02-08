package com.example.student.a2018020804;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new MyReceiver();
    }
    public void click1(View v)
    {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);//放入要執行的動作
        // 有些特殊的广播，必须使用动态注册的BroadcastReceiver来接收，
        // 比如：屏幕开关电量改变耳机插拔
        //filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.setPriority(500);
        registerReceiver(receiver, filter);
    }
    public void click2(View v)
    {
        unregisterReceiver(receiver);
    }
    public void click3(View v)
    {
        Intent intent = new Intent("myaction");
        sendBroadcast(intent);
    }
}

