package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class signupAct extends AppCompatActivity {

    Button check;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        check=findViewById(R.id.check);
        et = findViewById(R.id.et);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(signupAct.this, "Checking weather", Toast.LENGTH_SHORT).show();
                String s = et.getText().toString();
                Intent intent=new Intent(signupAct.this,FinalActivity2.class);
                intent.putExtra("city",s);
                startActivity(intent);
            }
        });
    }



}