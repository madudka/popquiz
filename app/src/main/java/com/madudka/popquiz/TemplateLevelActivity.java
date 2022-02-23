package com.madudka.popquiz;

import static com.madudka.popquiz.LevelsActivity.LEVEL_NUM;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.madudka.popquiz.adv.AdvHelper;
import com.madudka.popquiz.databinding.TemplateLevelBinding;
import com.madudka.popquiz.preference.PreferencesHelper;
import com.madudka.popquiz.question.Question;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

public class TemplateLevelActivity extends AppCompatActivity {

    public static TemplateLevelActivity instance;

    private Dialog dialogPreview;
    private Dialog dialogEnd;
    private TemplateLevelBinding binding;

    private ILevel level;
    private int lvlNum = 1;

    private int questionNum = 0;
    //Массив вопросов всегда - остается фиксированным
    public ArrayList<Question> questionArray;
    //Массив id вопросов - используется для управления актуальным списком вопросов
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

        instance = this;

        AdvHelper.init(this);
        AdvHelper.loadInterstitial(this);

        //Получение номера уровня и объекта уровня
        Intent intent = getIntent();
        lvlNum = intent.getIntExtra(LEVEL_NUM, 1);
        level = LevelHelper.getLevelObject(lvlNum);

        initQuestions();

        binding.templateLlvBg.setImageResource(R.drawable.history_background);
        binding.textLevels.setText(level.getTextLevel());

        setPreviewDialog();
        setDialogEnd();
        dialogPreview.show();

        binding.btnBack.setOnClickListener(v -> back());

        final TextView[] progress = {binding.point1, binding.point2, binding.point3, binding.point4, binding.point5,
                binding.point6, binding.point7, binding.point8, binding.point9, binding.point10};

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

    private void initQuestions() {
        questionArray = Question.getQuestionList(getApplicationContext(), level);
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
    }

    @Override
    public void onBackPressed() {
        back();
    }

    public void back() {
        AdvHelper.typeOperation = 1;
        if (!AdvHelper.showInterstitialAd(this, this)) {
            try {
                Intent intent = new Intent(TemplateLevelActivity.this, LevelsActivity.class);
                startActivity(intent);
                finish();
            } catch (Exception ex) {
                //Log.d("back", ex.getMessage());
            }
        }
    }

    public void gameContinue(){
        AdvHelper.typeOperation = 2;
        if (!AdvHelper.showInterstitialAd(this,this)) {
            try {
                Intent intent = new Intent(TemplateLevelActivity.this, TemplateLevelActivity.class);
                intent.putExtra(LEVEL_NUM, ++lvlNum);
                startActivity(intent);
                finish();
            } catch (Exception ex) {
                //Log.d("back", ex.getMessage());
            }
        }
    }

    private void setPreviewDialog(){
        dialogPreview = new Dialog(this);
        dialogPreview.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogPreview.setContentView(R.layout.preview_dialog);
        dialogPreview.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачность сзади диалога
        dialogPreview.setCancelable(false); //отмена закрытия кнопкной "назад"

        ImageView imgPrev = (ImageView)dialogPreview.findViewById(R.id.prevImg);
        imgPrev.setImageResource(level.getPrevImgId());
        TextView tvDescr = (TextView)dialogPreview.findViewById(R.id.textDescr);
        tvDescr.setText(level.getPrevTextLvl());
        TextView tvTheme = (TextView)dialogPreview.findViewById(R.id.textTheme);
        tvTheme.setText(level.getPrevTextTheme());


        dialogPreview.findViewById(R.id.btnClose).setOnClickListener(v -> {
            back();
            dialogPreview.dismiss();
        });

        dialogPreview.findViewById(R.id.btnContinue).setOnClickListener(v -> dialogPreview.dismiss());
    }

    private void setDialogEnd(){
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.end_dialog);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачность сзади диалога
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false); //отмена закрытия кнопкной "назад"

        TextView tv = (TextView)dialogEnd.findViewById(R.id.textDescrEnd);
        tv.setText(level.getEndTextLvl());

        dialogEnd.findViewById(R.id.btnClose).setOnClickListener(v -> {
            back();
            dialogEnd.dismiss();
        });

        //Добавить условие для последнего уровня
        dialogEnd.findViewById(R.id.btnContinue).setOnClickListener(v -> {
            if (lvlNum < 30) gameContinue(); else back();
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
                    updatePreferences();

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
            }, 250);
        }
    }

    private void updatePreferences() {
        SharedPreferences preferences = PreferencesHelper.getCustomPreferences(
                getApplicationContext(), PreferencesHelper.SAVE);
        final int numLevel = PreferencesHelper.getLevel(preferences);
        if (numLevel < 30) {
            PreferencesHelper.setLevel(preferences, numLevel + 1);
        }
    }
}