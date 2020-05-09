package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //cái này là cách để lưu dữ liệu khi tắt app
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private void initPreferences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }

    EditText input_text;
    TextView last_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPreferences();//khởi tạo mới xài đc bộ nhớ Preferences

        input_text = findViewById(R.id.editText);
        last_update = findViewById(R.id.last_update);

        //Phục hồi dữ liệu từ bộ nhớ
        String text = sharedPreferences.getString("input_text","");
        String time = sharedPreferences.getString("last_update", String.valueOf(Calendar.getInstance().getTime()));
        input_text.setText(text);
        last_update.setText("Last update: "+time);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        input_text = findViewById(R.id.editText);

        //Lưu lại dữ liệu trong Preferences
        String save_text = input_text.getText().toString();
        editor.putString("input_text", save_text);

        Date currentTime = Calendar.getInstance().getTime();
        editor.putString("last_update", String.valueOf(currentTime));

        //commit rồi cái preferences mới thực sự lưu
        editor.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        input_text = findViewById(R.id.editText);

        //Lưu lại dữ liệu trong Preferences
        String save_text = input_text.getText().toString();
        editor.putString("input_text", save_text);

        Date currentTime = Calendar.getInstance().getTime();
        editor.putString("last_update", String.valueOf(currentTime));

        //commit rồi cái preferences mới thực sự lưu
        editor.commit();
    }
}
