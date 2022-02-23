package com.madudka.popquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.madudka.popquiz.adv.AdvHelper;
import com.madudka.popquiz.databinding.LevelsBinding;
import com.madudka.popquiz.preference.PreferencesHelper;

import java.util.Arrays;

public class LevelsActivity extends AppCompatActivity {

    private LevelsBinding binding;
    public final static String LEVEL_NUM = "numLevel";

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

        AdvHelper.init(this);
        AdvHelper.loadBanner(findViewById(R.id.adView));

        SharedPreferences preferences = PreferencesHelper.getCustomPreferences(
                getApplicationContext(), PreferencesHelper.SAVE);
        final int level = PreferencesHelper.getLevel(preferences);

        binding.btnBack.setOnClickListener(v -> back());

         final TextView[] textViews = new TextView[] {
                binding.textView1, binding.textView2, binding.textView3, binding.textView4, binding.textView5
            , binding.textView6, binding.textView7, binding.textView8, binding.textView9, binding.textView10
            , binding.textView11, binding.textView12, binding.textView13, binding.textView14, binding.textView15
            , binding.textView16, binding.textView17, binding.textView18, binding.textView19, binding.textView20
            , binding.textView21, binding.textView22, binding.textView23, binding.textView24, binding.textView25
            , binding.textView26, binding.textView27, binding.textView28, binding.textView29, binding.textView30
        };

        for (TextView textView : textViews) {
            textView.setOnClickListener(v -> {
                int index = Arrays.asList(textViews).indexOf(v) + 1;
                if (level >= index && index != 0) {
                    startLevel(index);
                }
            });
        }

        for (int i = 0; i < level; i++){
            textViews[i].setBackgroundResource(R.drawable.style_btn_lvl);
            textViews[i].setTextColor(getColor(R.color.black95));
        }
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
            //Log.d("back", ex.getMessage());
        }
    }

    private void startLevel(int numLevel){
        try {
            Intent intent = new Intent(LevelsActivity.this, TemplateLevelActivity.class);
            intent.putExtra(LEVEL_NUM, numLevel);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            finish();
        } catch (Exception ex){
            //Log.d("startLevel", ex.getMessage());
        }
    }
}