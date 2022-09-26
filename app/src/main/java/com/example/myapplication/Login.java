package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private String name;
    private String password;
    private EditText editname;
    private EditText editpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editname=findViewById(R.id.edittext_name);
        editpassword=findViewById(R.id.edittext_password);
        Intent intent=getIntent();
        name=intent.getStringExtra("name");
        password=intent.getStringExtra("password");
        if(!name.isEmpty())
            editname.setText(name);
        if(!password.isEmpty())
            editpassword.setText(password);
        //绑定监听
        findViewById(R.id.login_result_button).setOnClickListener(this);
        findViewById(R.id.login_cancel_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_result_button:
                name=editname.getText().toString();
                password=editpassword.getText().toString();
                Intent intentResult=new Intent();
                intentResult.putExtra("name",name);
                intentResult.putExtra("password",password);
                setResult(RESULT_OK,intentResult);
                Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.login_cancel_button:
                Intent intentResult2=new Intent();
                intentResult2.putExtra("name","用户取消登录");
                intentResult2.putExtra("password","用户取消登录");
                setResult(RESULT_OK,intentResult2);
                finish();
                break;
        }
    }
}