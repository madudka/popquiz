package com.madudka.popquiz;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.madudka.popquiz.databinding.TemplateLevelBinding;
import com.madudka.popquiz.question.Question;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

public class Level3Activity extends AppCompatActivity {

    private Dialog dialogPreview;
    private Dialog dialogEnd;
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

        binding.templateLlvBg.setImageResource(R.drawable.history_background);
        binding.textLevels.setText(R.string.level3);

        setPreviewDialog();
        setDialogEnd();
        dialogPreview.show();

        binding.btnBack.setOnClickListener(v -> {
            back();
        });

        final TextView[] progress = {binding.point1, binding.point2, binding.point3, binding.point4, binding.point5,
                binding.point6, binding.point7, binding.point8, binding.point9, binding.point10};

        questionArray = Question.getQuestionList(getApplicationContext(), 3);
        if (questionArray != null) {
            if (questionArray.size() > 0) {

                //Цикл начинается с 1, т.к. questionNum по-умолчанию 0
                //Первый элемент этого списка всегда будет в начале 0, и удаляться после присвоения
                for (int i = 1; i < 10; i++) {
                    idArrayDeque.addLast(i);
                }

                binding.textViewQuestion.setText(questionArray.get(questionNum).getQuestion());

                setRandomChoices(binding.textViewChoice1, binding.textViewChoice2);
            }
        }

        //нажатие на первый вариант
        binding.textViewChoice1.setOnTouchListener((v, event) -> {
            choiceClick(event, binding.textViewChoice1, progress);
            return true;
        });


        //нажатие на второй вариант
        binding.textViewChoice2.setOnTouchListener((v, event) -> {
            choiceClick(event, binding.textViewChoice2, progress);
            return true;
        });


        binding.textViewHint.setOnClickListener(v -> {
            if (binding.textViewHint.getText() == getString(R.string.show_hint)){
                binding.textViewHint.setText(questionArray.get(questionNum).getInfo());
                binding.textViewHint.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
                binding.textViewHint.setTextAppearance(R.style.TextHintAppearanceShow);
            }
        });

    }

    @Override
    public void onBackPressed() {
        back();
    }

    private void back(){
        try{
            Intent intent = new Intent(Level3Activity.this, LevelsActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception ex){

        }
    }

    private void setPreviewDialog(){
        dialogPreview = new Dialog(this);
        dialogPreview.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogPreview.setContentView(R.layout.preview_dialog);
        dialogPreview.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачность сзади диалога
        dialogPreview.setCancelable(false); //отмена закрытия кнопкной "назад"

        ImageView imgPrev = (ImageView)dialogPreview.findViewById(R.id.prevImg);
        imgPrev.setImageResource(R.drawable.preview_image_three);
        TextView tv = (TextView)dialogPreview.findViewById(R.id.textDescr);
        tv.setText(R.string.lvl_three);

        dialogPreview.findViewById(R.id.btnClose).setOnClickListener(v -> {
            back();
            dialogPreview.dismiss();
        });

        dialogPreview.findViewById(R.id.btnContinue).setOnClickListener(v -> {
            dialogPreview.dismiss();
        });
    }

    private void setDialogEnd(){
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.end_dialog);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачность сзади диалога
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false); //отмена закрытия кнопкной "назад"

        TextView tv = (TextView)dialogEnd.findViewById(R.id.textDescrEnd);
        tv.setText(R.string.lvl_three_end);

        dialogEnd.findViewById(R.id.btnClose).setOnClickListener(v -> {
            back();
            dialogEnd.dismiss();
        });

        dialogEnd.findViewById(R.id.btnContinue).setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Level3Activity.this, Level4Activity.class);
                startActivity(intent);
                finish();
            } catch (Exception ex){

            }
            dialogEnd.dismiss();
        });
    }

    private void setRandomChoices(TextView tv1, TextView tv2){
        if (tv1 != null && tv2 != null) {
            r = random.nextInt(99);
            if (r > 49) {
                tv1.setText(questionArray.get(questionNum).getAnswerTrue());
                tv2.setText(questionArray.get(questionNum).getAnswerFalse());
            } else {
                tv1.setText(questionArray.get(questionNum).getAnswerFalse());
                tv2.setText(questionArray.get(questionNum).getAnswerTrue());
            }
        }
    }

    private void choiceClick(MotionEvent event, TextView tv, TextView[] progress){
        TextView otv = (tv == binding.textViewChoice1) ? binding.textViewChoice2 : binding.textViewChoice1;

        if (event.getAction() == MotionEvent.ACTION_DOWN){

            otv.setEnabled(false);
            binding.textViewHint.setEnabled(false);
            if (tv.getText() == questionArray.get(questionNum).getAnswerTrue())
            {
                tv.setBackground(getDrawable(R.drawable.style_true));
            } else {
                tv.setBackground(getDrawable(R.drawable.style_false));

                //При неправильно ответе добавляем id вопроса в конец очереди
                idArrayDeque.offerLast(questionNum);
            }

        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            if (tv.getText() == questionArray.get(questionNum).getAnswerTrue()) {

                progress[countTrue].setBackground(getDrawable(R.drawable.style_point_checked));
                countTrue++;
            }

            Handler handler = new Handler();
            handler.postDelayed(() -> {
                if (idArrayDeque.size() == 0) {
                    //Выход из уровня
                    dialogEnd.show();
                } else {
                    questionNum = idArrayDeque.pop();

                    binding.textViewHint.setTextAppearance(R.style.TextHintAppearance);
                    binding.textViewHint.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    binding.textViewHint.setText(R.string.show_hint);

                    tv.setBackground(getDrawable(R.drawable.style_choice));
                    otv.setEnabled(true);
                    binding.textViewHint.setEnabled(true);
                    binding.textViewQuestion.setText(questionArray.get(questionNum).getQuestion());

                    setRandomChoices(tv, otv);
                }
            }, 500);
        }
    }
}