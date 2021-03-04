package com.example.urbanfresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.example.urbanfresh.network.MainActivityModel;
import com.example.urbanfresh.network.ModelCategoryData;
import com.example.urbanfresh.network.VollyNetwork;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView banner_name;
    RecyclerView recView;
    ArrayList<MainActivityModel> mainActivityModel;
    ArrayList<ModelCategoryData> modelCategoryData;

    String image,text;
    ImageButton backbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.banner_im);
        banner_name = findViewById(R.id.banner_name);
        recView = findViewById(R.id.recView);

        backbtn = findViewById(R.id.backBtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recView.setLayoutManager(layoutManager);
        recView.setNestedScrollingEnabled(false);

//        getAllMarketPlace();
        getData();
    }

    public void getData(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://139.59.83.144:9050/api/home_test_section", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("responseData", "onResponse: " + response);

                JSONObject jsonObject = null;
                JSONArray jsonArray;
                modelCategoryData = new ArrayList<ModelCategoryData>();
                try{
                    jsonObject = new JSONObject(response);
                    jsonArray = jsonObject.getJSONArray("components");

                        JSONObject object = jsonArray.getJSONObject(0);
                       JSONArray jsonarray = object.getJSONArray("StaticBanner");
                    for (int i=0; i<jsonarray.length(); i++) {
                        JSONObject obj1 = jsonarray.getJSONObject(i);
                        banner_name.setText(obj1.getString("banner_name"));
                        Log.d("staticBanner", "onResponse: " + object.get("StaticBanner"));
                    }

                    JSONObject obj = jsonArray.getJSONObject(1);
                    JSONArray jsonArray1 = obj.getJSONArray("categorydata");

                    for (int i=0; i<jsonArray1.length(); i++){
                        JSONObject obj1 = jsonArray1.getJSONObject(i);
                        modelCategoryData.add(new ModelCategoryData(
                                obj1.getString("category_id"),
                                obj1.getString("category_name"),
                                obj1.getString("category_description"),
                                obj1.getString("category_picture")));
                    }
                    MainActivityAdapter mainActivityAdapter = new MainActivityAdapter(MainActivity.this,modelCategoryData);
                    recView.setAdapter(mainActivityAdapter);
                    Log.d("categoryData", "onResponse: " + obj.get("categorydata"));
                    Log.d("TAG", "onResponse: test");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("category_id","2");
                return params;
            }
        };
        VollyNetwork.getInstance().addToRequestQueue(stringRequest);
    }
}