package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    BroadcastReceiver reciver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        /*
            广播测试：发送自定义动态广播与动态绑定广播接受事件
         */
        Button broadcast_button=findViewById(R.id.boradcast_button);
        broadcast_button.setOnClickListener(this);
        IntentFilter filter=new IntentFilter();
        filter.addAction("com.example.myapplication");
        reciver=new MyBroadcastReciver();
        registerReceiver(reciver,filter);
        /*
            页面跳转、传值测试 intent传值
         */
        Button activityButton=findViewById(R.id.intent_test_button);
        activityButton.setOnClickListener(this);
        findViewById(R.id.listview_button).setOnClickListener(this);
        findViewById(R.id.recyclerview_button).setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(reciver);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10086:
                if(resultCode==RESULT_OK){
                    Log.d("跨界面取值","请求号：10086 请求返回");
                    Log.d("跨界面取值","name:"+data.getStringExtra("name"));
                    Log.d("跨界面取值","password:"+data.getStringExtra("password"));
                }else{
                    Toast.makeText(this,"遇到未知问题",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //广播测试
            case R.id.boradcast_button:
                Log.d("测试","点击了广播按钮");
                Intent intent=new Intent("com.example.myapplication");
                sendBroadcast(intent);
                break;
            case R.id.intent_test_button:
                Log.d("测试","点击了页面传值按钮");
                Intent intentActivity1=new Intent(MainActivity.this,Login.class);
                intentActivity1.putExtra("name","张三丰");
                intentActivity1.putExtra("password","aaaaabbbbbcccccddddd");
                startActivityForResult(intentActivity1,10086);
                break;
            case R.id.listview_button:
                Log.d("测试","点击了listView按钮");
                Intent intentforListview=new Intent(MainActivity.this,ListViewActivity.class);
                startActivity(intentforListview);
                break;
            case R.id.recyclerview_button:
                Log.d("测试","点击了recyclerview按钮");
                Intent intentforRecyclerview=new Intent(MainActivity.this,RecyclerViewActivity.class);
                startActivity(intentforRecyclerview);
                break;
        }
    }
    public class MyBroadcastReciver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"接收到自定义广播",Toast.LENGTH_SHORT).show();
        }
    }

}