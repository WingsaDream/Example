package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private  List<Item> listItems=new ArrayList<>();
    //列表数据
    private String[] namedata={"网络和互联网","已连接的设备","应用","通知","电池","存储","提示音和震动",
            "显示","壁纸和样式","无障碍","安全","隐私","位置信息","Goole","关于设备"};
    //列表数据
    private int[] imgdata={R.drawable.car,R.drawable.cart,R.drawable.clock,R.drawable.close,R.drawable.up,R.drawable.down,R.drawable.gift,
            R.drawable.history,R.drawable.mail,R.drawable.phone,R.drawable.charge,R.drawable.fenlei,R.drawable.time,R.drawable.change,R.drawable.ktv};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initdata();
        RecyclerView recyclerView=findViewById(R.id.my_recyclerview);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(listItems);
        recyclerView.setAdapter(adapter);
    }
    private void initdata(){
        for(int i=0;i<namedata.length;i++){
            Item temp=new Item(namedata[i],imgdata[i]);
            listItems.add(temp);
        }
    }

}