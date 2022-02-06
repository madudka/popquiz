package com.madudka.popquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.madudka.popquiz.databinding.TemplateLevelBinding;
import com.madudka.popquiz.question.JsonHelper;
import com.madudka.popquiz.question.Question;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Level1Activity extends AppCompatActivity {

    private Dialog dialog;
    private TemplateLevelBinding binding;

    private int questionNum = 0;
    //Массив вопросов всегда - остается фиксированным
    public ArrayList<Question> questionArray;
    //Массив id вопросов - используется для управления актуальынм списком вопросов
    public ArrayDeque<Integer> idArrayDeque = new ArrayDeque<>(10);
    private Random random = new Random();
    private int r = 0;
    public int countTrue = 0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.template_level);
        binding = TemplateLevelBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.textLevels.setText(R.string.level1);

        setPreviewDialog();

        binding.btnBack.setOnClickListener(v -> {
            back();
        });

        final TextView[] progress = {binding.point1, binding.point2, binding.point3, binding.point4, binding.point5,
                binding.point6, binding.point7, binding.point8, binding.point9, binding.point10};

        String jsonQuestions = JsonHelper.getJsonFromAssets(getApplicationContext(), JsonHelper.FILE_QUESTION);
        questionArray = JsonHelper.importFromJSON(jsonQuestions);
        if (questionArray != null)
            if (questionArray.size() > 0) {

                //Цикл начинается с 1, т.к. questionNum по-умолчанию 0
                //Первый элемент этого списка всегда будет в начале 0, и удаляться после присвоения
                for (int i = 1; i < 10; i++){
                    idArrayDeque.addLast(i);
                }

                binding.textViewQuestion.setText(questionArray.get(questionNum).getQuestion());

                r = random.nextInt(10);
                if (r > 4) {
                    binding.textViewChoice1.setText(questionArray.get(questionNum).getAnswerTrue());
                    binding.textViewChoice2.setText(questionArray.get(questionNum).getAnswerFalse());
                } else {
                    binding.textViewChoice1.setText(questionArray.get(questionNum).getAnswerFalse());
                    binding.textViewChoice2.setText(questionArray.get(questionNum).getAnswerTrue());
                }
            }

        //нажатие на первый вариант
        binding.textViewChoice1.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN){

                binding.textViewChoice2.setEnabled(false);
                if (binding.textViewChoice1.getText() == questionArray.get(questionNum).getAnswerTrue())
                {
                    binding.textViewChoice1.setBackground(getDrawable(R.drawable.style_true));
                } else {
                    binding.textViewChoice1.setBackground(getDrawable(R.drawable.style_false));

                    //При неправильно ответе добавляем id вопроса в конец очереди
                    idArrayDeque.offerLast(questionNum);
                }

            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                if (binding.textViewChoice1.getText() == questionArray.get(questionNum).getAnswerTrue()) {

                    progress[countTrue].setBackground(getDrawable(R.drawable.style_point_checked));
                    countTrue++;
                }

                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    if (idArrayDeque.size() == 0) {
                        //Выход из уровня
                    } else {
                        questionNum = idArrayDeque.pop();

                        binding.textViewChoice1.setBackground(getDrawable(R.drawable.style_choice));
                        binding.textViewChoice2.setEnabled(true);
                        binding.textViewQuestion.setText(questionArray.get(questionNum).getQuestion());
                        r = random.nextInt(10);
                        if (r > 4) {
                            binding.textViewChoice1.setText(questionArray.get(questionNum).getAnswerTrue());
                            binding.textViewChoice2.setText(questionArray.get(questionNum).getAnswerFalse());
                        } else {
                            binding.textViewChoice1.setText(questionArray.get(questionNum).getAnswerFalse());
                            binding.textViewChoice2.setText(questionArray.get(questionNum).getAnswerTrue());
                        }
                    }
                }, 500);
            }
            return true;
        });


        //нажатие на второй вариант
        binding.textViewChoice2.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN){

                binding.textViewChoice1.setEnabled(false);
                if (binding.textViewChoice2.getText() == questionArray.get(questionNum).getAnswerTrue())
                {
                    binding.textViewChoice2.setBackground(getDrawable(R.drawable.style_true));
                } else {
                    binding.textViewChoice2.setBackground(getDrawable(R.drawable.style_false));

                    //При неправильно ответе добавляем id вопроса в конец очереди
                    idArrayDeque.offerLast(questionNum);
                }

            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                if (binding.textViewChoice2.getText() == questionArray.get(questionNum).getAnswerTrue()) {

                    progress[countTrue].setBackground(getDrawable(R.drawable.style_point_checked));
                    countTrue++;
                }

                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    if (idArrayDeque.size() == 0) {
                        //Выход из уровня
                    } else {
                        questionNum = idArrayDeque.pop();

                        binding.textViewChoice2.setBackground(getDrawable(R.drawable.style_choice));
                        binding.textViewChoice1.setEnabled(true);
                        binding.textViewQuestion.setText(questionArray.get(questionNum).getQuestion());
                        r = random.nextInt(10);
                        if (r > 4) {
                            binding.textViewChoice2.setText(questionArray.get(questionNum).getAnswerTrue());
                            binding.textViewChoice1.setText(questionArray.get(questionNum).getAnswerFalse());
                        } else {
                            binding.textViewChoice2.setText(questionArray.get(questionNum).getAnswerFalse());
                            binding.textViewChoice1.setText(questionArray.get(questionNum).getAnswerTrue());
                        }
                    }
                }, 500);
            }
            return true;
        });

    }

    @Override
    public void onBackPressed() {
        back();
    }

    private void setPreviewDialog(){
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.preview_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачность сзади диалога
        dialog.setCancelable(false); //отмена закрытия кнопкной "назад"

        dialog.findViewById(R.id.btnClose).setOnClickListener(v -> {
            back();
            dialog.dismiss();
        });

        dialog.findViewById(R.id.btnContinue).setOnClickListener(v -> {
            dialog.dismiss();
        });

        dialog.show();
    }

    private void back(){
        try{
            Intent intent = new Intent(Level1Activity.this, LevelsActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception ex){

        }
    }
}