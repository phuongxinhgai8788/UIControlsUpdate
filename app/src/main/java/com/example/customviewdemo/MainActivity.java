package com.example.customviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    SeekBar seekBar;
    Switch switchView;
    ImageView imageView;
    TextView textView;
    RadioGroup radioGroup;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        seekBar = findViewById(R.id.seek_bar);
        imageView = findViewById(R.id.image_view);
        switchView = findViewById(R.id.switch_view);
        textView = findViewById(R.id.text_view);
        radioGroup = findViewById(R.id.radio_group);
        checkBox = findViewById(R.id.checkbox);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                displayProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        button.setOnClickListener(v -> {
            int checkedIndex = radioGroup.getCheckedRadioButtonId();

            if (checkedIndex == -1) {
                Toast toast = Toast.makeText(this, R.string.not_checked, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

            } else if (checkedIndex == R.id.right_answer) {
                Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show();
            }
        });

        switchView.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (switchView.isChecked()) {
                imageView.setImageResource(R.drawable.ic_baseline_wifi_on);
            } else {
                imageView.setImageResource(R.drawable.ic_baseline_wifi_off);
            }
        });

        checkBox.setChecked(false);
        checkBox.setOnClickListener(v -> {
            if (checkBox.isChecked()) {
                Intent intent = new Intent(this, CodeLayoutActivity.class);
                startActivity(intent);
            }
        });
    }

    private void displayProgress(int progress) {
        String progressString = String.valueOf(progress);
        textView.setText(progressString);
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkBox.setChecked(false);
    }
}