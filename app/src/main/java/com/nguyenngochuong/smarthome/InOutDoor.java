package com.nguyenngochuong.smarthome;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InOutDoor extends Fragment {

    //API key của tài khoản OpenWeatherMap: df53dbdf5c8245804bec842f52c7e3c1

    View view;
    TextView txtTempIndoor, txtHumIndoor, txtGasIndoor, txtDustIndoor;
    TextView txtTempOutdoor, txtHumOutdoor, txtCloudOutdoor, txtWindOutdoor, txtPressureOutdoor;

    //Khai báo đường truyền dữ liệu với Firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference temperatureIndoor = database.getReference("indoor/temperature");
    DatabaseReference humidityIndoor = database.getReference("indoor/humidity");
    DatabaseReference gasIndoor = database.getReference("indoor/gas");
    DatabaseReference dustIndoor = database.getReference("indoor/dust");

    public InOutDoor() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.inoutdoor, container, false);

        //Ánh xạ
        txtTempIndoor =  (TextView) view.findViewById(R.id.txtTempIndoor);
        txtHumIndoor =  (TextView) view.findViewById(R.id.txtHumIndoor);
        txtGasIndoor = (TextView) view.findViewById(R.id.txtGasIndoor);
        txtDustIndoor =  (TextView) view.findViewById(R.id.txtDustIndoor);
        txtTempOutdoor =  (TextView) view.findViewById(R.id.txtTempOutdoor);
        txtHumOutdoor =  (TextView) view.findViewById(R.id.txtHumOutdoor);
        txtCloudOutdoor =  (TextView) view.findViewById(R.id.txtCloudOutdoor);
        txtWindOutdoor =  (TextView) view.findViewById(R.id.txtWindOutdoor);
        txtPressureOutdoor =  (TextView) view.findViewById(R.id.txtPressureOutdoor);

        //Đọc thông số Indoor từ Firebase
        temperatureIndoor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtTempIndoor.setText(dataSnapshot.getValue(String.class) + "°C");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Read indoor temperature is failed", Toast.LENGTH_SHORT).show();
            }
        });

        humidityIndoor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtHumIndoor.setText(dataSnapshot.getValue(String.class) + "%");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Read indoor humidity is failed", Toast.LENGTH_SHORT).show();
            }
        });

        gasIndoor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtGasIndoor.setText("GAS: " + dataSnapshot.getValue(String.class) + "ppm");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Read indoor gas is failed", Toast.LENGTH_SHORT).show();
            }
        });

        dustIndoor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtDustIndoor.setText("DUST: " + dataSnapshot.getValue(String.class) + "mg/m3");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Read indoor temperature is failed", Toast.LENGTH_SHORT).show();
            }
        });

        GetCurrentWeatherData();

        return view;
    }

    //Hàm đọc dữ liệu thời tiết hiện tại
    public void GetCurrentWeatherData(){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        String url = "https://api.openweathermap.org/data/2.5/weather?q=Danang&units=metric&appid=df53dbdf5c8245804bec842f52c7e3c1";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject jsonObjectMain = jsonObject.getJSONObject("main");
                            String temp = jsonObjectMain.getString("temp");
                            String humidity = jsonObjectMain.getString("humidity");
                            String pressure = jsonObjectMain.getString("pressure");

                            JSONObject jsonObjectCloud = jsonObject.getJSONObject("clouds");
                            String cloud = jsonObjectCloud.getString("all");

                            JSONObject jsonObjectWind = jsonObject.getJSONObject("wind");
                            String wind = jsonObjectWind.getString("speed");

                            //Đẩy dữ liệu thời tiết ra màn hình
                            txtTempOutdoor.setText(temp + "°C");
                            txtHumOutdoor.setText(humidity + "%");
                            txtCloudOutdoor.setText(cloud + "%");
                            txtWindOutdoor.setText(wind + "m/s");
                            txtPressureOutdoor.setText(pressure + "hpa");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Error when read current weather data", Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(stringRequest);
    }
}
