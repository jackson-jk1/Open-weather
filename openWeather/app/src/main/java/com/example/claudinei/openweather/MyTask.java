package com.example.claudinei.openweather;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

public class MyTask extends AsyncTask<String, Void, String> {

    TextView output;

    public MyTask(TextView output) {
        this.output = output;
    }

    @Override
    protected String doInBackground(String... strings) {
        String stringURL = strings[0];
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        StringBuffer buffer = null;
        try{
            URL url = new URL(stringURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            inputStream = connection.getInputStream();

            inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            buffer = new StringBuffer();
            String line = "";
            while((line = reader.readLine()) != null) {
                buffer.append(line);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Weather weather = new Weather();
        System.out.println("\n\n"+s+"\n\n");

        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONObject jsonObject2 = jsonObject.getJSONObject("main");

            weather.setTempAtual(jsonObject2.getString("temp"));
            weather.setTempMax(jsonObject2.getString("temp_max"));
            weather.setTempMin(jsonObject2.getString("temp_min"));
            weather.setUmidade(jsonObject2.getString("humidity"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        output.setText(weather.toString());
    }
}
