package com.example.customviewdemo;

import static android.os.Build.VERSION_CODES.S;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ipsec.ike.IkeRfc822AddrIdentification;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CodeLayoutActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_layout);

        linearLayout = findViewById(R.id.parent_layout);

        SeekBar seekBar = new SeekBar(this);

        TextView textView = new TextView(this);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String progressString = String.valueOf(progress);
                textView.setText(progressString);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.ic_baseline_wifi_off);
        Switch switchView = new Switch(this);
        switchView.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (switchView.isChecked()) {
                imageView.setImageResource(R.drawable.ic_baseline_wifi_on);
            } else {
                imageView.setImageResource(R.drawable.ic_baseline_wifi_off);
            }
        });
        CheckBox checkBox = new CheckBox(this);
        checkBox.setText(R.string.return_to_previous_screen);
        checkBox.setOnClickListener(v -> {
            if(checkBox.isChecked()){
                finish();
            }
        });

        RadioGroup radioGroup = new RadioGroup(this);
        RadioButton radioButton01 = new RadioButton(this);
        radioButton01.setText(R.string.RightAnswer);
        radioButton01.setId(R.id.right_answer);
        RadioButton radioButton02 = new RadioButton(this);
        radioButton02.setText(R.string.wrong_answer);
        RadioButton radioButton03 = new RadioButton(this);
        radioButton03.setText(R.string.wrong_answer);
        RadioButton radioButton04 = new RadioButton(this);
        radioButton04.setText(R.string.wrong_answer);

        radioGroup.addView(radioButton01);
        radioGroup.addView(radioButton02);
        radioGroup.addView(radioButton03);
        radioGroup.addView(radioButton04);

        Button button = new Button(this);
        button.setText(R.string.button_name);

        button.setOnClickListener( v -> {
            int checkedIndex = radioGroup.getCheckedRadioButtonId();

            if(checkedIndex == -1){
                Toast toast = Toast.makeText(this, R.string.not_checked, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.makeText(this, R.string.not_checked, Toast.LENGTH_SHORT).show();

            }else if(checkedIndex == R.id.right_answer){
                Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show();
            }
        });

        TextView questionTextView = new TextView(this);
        questionTextView.setText(R.string.Question);

        linearLayout.addView(seekBar);
        linearLayout.addView(textView);
        linearLayout.addView(switchView);
        linearLayout.addView(imageView);
        linearLayout.addView(checkBox);
        linearLayout.addView(questionTextView);
        linearLayout.addView(radioGroup);
        linearLayout.addView(button);
    }
}