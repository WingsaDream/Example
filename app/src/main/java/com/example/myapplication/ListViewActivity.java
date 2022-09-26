package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListViewActivity extends AppCompatActivity {
    List<Item> listItems=new ArrayList<>();
    //列表数据
    private String[] namedata={"网络和互联网","已连接的设备","应用","通知","电池","存储","提示音和震动",
            "显示","壁纸和样式","无障碍","安全","隐私","位置信息","Goole","关于设备"};
    //列表数据
    private int[] imgdata={R.drawable.car,R.drawable.cart,R.drawable.clock,R.drawable.close,R.drawable.up,R.drawable.down,R.drawable.gift,
            R.drawable.history,R.drawable.mail,R.drawable.phone,R.drawable.charge,R.drawable.fenlei,R.drawable.time,R.drawable.change,R.drawable.ktv};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        //初始化数据
        initdata();
        MyAdapter adapter=new MyAdapter(ListViewActivity.this,R.layout.listviewitem,listItems);
        ListView listView=findViewById(R.id.my_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Item item=listItems.get(position);
                Toast.makeText(ListViewActivity.this,"点击了"+item.getItemname(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initdata(){
        for(int i=0;i<namedata.length;i++){
            Item temp=new Item(namedata[i],imgdata[i]);
            listItems.add(temp);
        }
    }
    private class MyAdapter extends ArrayAdapter<Item>{
        private int resourceId;

        public MyAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
            super(context, resource, objects);
            resourceId=resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Item item=getItem(position);
            View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            ImageView itemImage=view.findViewById(R.id.listview_image);
            TextView itemText=view.findViewById(R.id.listview_text);
            itemImage.setImageResource(item.getItemimg());
            itemText.setText(item.getItemname());

            return view;
        }
    }
}