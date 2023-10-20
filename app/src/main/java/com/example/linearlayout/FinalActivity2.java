package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class FinalActivity2 extends AppCompatActivity {
    public static final String Humidi="Humidi";
    public static final String Tempr="Tempr";
    public static final String Condit="condit";
    String Humidit;
    String Tempra;
    String Conditi;
    EditText et;
    TextView tv,tvHumidity,condition;
    Button bt;
    String city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final2);

        tv = findViewById(R.id.tv);

        tvHumidity = findViewById(R.id.tvhumidity);
        condition = findViewById(R.id.condition);

        Bundle bundle = getIntent().getExtras();
        city = bundle.getString("city");
        get();


    }
    public void get(){
        String apikey="40f302a0558574f570ea6997e90f5a77";

        String url="https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=40f302a0558574f570ea6997e90f5a77";

        RequestQueue requestQueue  = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    Double j1 = response.getJSONObject("main").getDouble("temp");
                    int j2=response.getJSONObject("main").getInt("humidity");
                    String j3 = response.getJSONArray("weather").getJSONObject(0).getString("description");
                    Double temp=j1-273.15;
                    Double humid= Double.valueOf(j2);
                    String s = "Temperature is"+Double.toString(temp).substring(0,5)+"C";
                    String t = "Humidity is"+ Double.toString(humid);
                    String l = "weather condition: "+j3;
                    tv.setText(s);
                    tvHumidity.setText(t);
                    condition.setText(l);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(FinalActivity2.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        requestQueue.add(jsonObjectRequest);
    }

}