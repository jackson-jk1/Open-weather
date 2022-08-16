package com.example.claudinei.openweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    String apiKey = "8470a6bf842def7013940ede4aacd226";
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = findViewById(R.id.output);
    }

    public void getData(View view){
        EditText cityName = findViewById(R.id.input);
        EditText country = findViewById(R.id.input2);

        String urlCityWeather =  "https://api.openweathermap.org/data/2.5/weather?q=" + cityName.getText().toString()
                + "," + country.getText().toString() + "&lang=it&appid=8470a6bf842def7013940ede4aacd226&units=metric";

        MyTask task = new MyTask(output);
        task.execute(urlCityWeather);
    }
}