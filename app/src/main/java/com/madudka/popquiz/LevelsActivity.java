package com.madudka.popquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.madudka.popquiz.databinding.LevelsBinding;

public class LevelsActivity extends AppCompatActivity {

    private LevelsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Убираем статусную строку
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.levels);

        binding = LevelsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnBack.setOnClickListener(v -> {
            back();
        });

        binding.textView1.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(LevelsActivity.this, Level1Activity.class);
                startActivity(intent);
                finish();
            } catch (Exception ex){

            }
        });

        binding.textView2.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(LevelsActivity.this, Level2Activity.class);
                startActivity(intent);
                finish();
            } catch (Exception ex){

            }
        });

        binding.textView3.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(LevelsActivity.this, Level3Activity.class);
                startActivity(intent);
                finish();
            } catch (Exception ex){

            }
        });
    }

    @Override
    public void onBackPressed() {
        back();
        super.onBackPressed();
    }

    private void back(){
        try {
            Intent intent = new Intent(LevelsActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception ex) {

        }
    }
}