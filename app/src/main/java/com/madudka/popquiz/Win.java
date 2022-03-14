package com.madudka.popquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.Task;
import com.madudka.popquiz.databinding.WinBinding;

public class Win extends AppCompatActivity {

    private WinBinding binding;

    private ReviewManager reviewManager;
    private ReviewInfo reviewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Убираем статусную строку
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = WinBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnOk.setOnClickListener(v -> ok());

        reviewManager = ReviewManagerFactory.create(this);
        Task<ReviewInfo> request = reviewManager.requestReviewFlow();
        request.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // We can get the ReviewInfo object
                reviewInfo = task.getResult();
                Task<Void> flow = reviewManager.launchReviewFlow(this, reviewInfo);

                flow.addOnSuccessListener(v -> {

                });
            }
        });
    }

    @Override
    public void onBackPressed() {
        ok();
    }

    private void ok(){
        try {
            Intent intent = new Intent(Win.this, LevelsActivity.class);
            startActivity(intent);
            finish();
        }
        catch (Exception ex){
            //Log.d("startBtn", ex.getMessage());
        }
    }
}