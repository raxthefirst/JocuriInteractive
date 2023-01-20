package com.radustan.jocuriinteractive;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class activity_quiz1 extends AppCompatActivity implements View.OnClickListener {


    TextView totalQuestionTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    RelativeLayout relativeLayout;
    int[] rasp;
    int totalQuestion = QuestionAnswer.question.length;
    int scor = 0;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_quiz1);

            totalQuestionTextView = findViewById(R.id.total_question);
            questionTextView = findViewById(R.id.question);
            ansA = findViewById(R.id.ans_A);
            ansB = findViewById(R.id.ans_B);
            ansC = findViewById(R.id.ans_C);
            ansD = findViewById(R.id.ans_D);
            submitBtn = findViewById(R.id.submit_btn);
            ImageView imgMic = findViewById(R.id.imgMic);


            ansA.setOnClickListener(this);
            ansB.setOnClickListener(this);
            ansC.setOnClickListener(this);
            ansD.setOnClickListener(this);
            submitBtn.setOnClickListener(this);

             ///fac butonul sa isi schimbe dimensiunile dupa rezolutia device-ului
             //-----------------

                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int heightbtn = displayMetrics.heightPixels;
                int widthbtn = displayMetrics.widthPixels;

                ansA.getLayoutParams().width=widthbtn / (25/10);
                ansA.getLayoutParams().height=heightbtn / 20;
                ansB.getLayoutParams().width=widthbtn / (25/10);
                ansB.getLayoutParams().height=heightbtn / 20;
                ansC.getLayoutParams().width=widthbtn / (25/10);
                ansC.getLayoutParams().height=heightbtn / 20;
                ansD.getLayoutParams().width=widthbtn / (25/10);
                ansD.getLayoutParams().height=heightbtn / 20;


                imgMic.getLayoutParams().width=widthbtn / 10;
                imgMic.getLayoutParams().height=widthbtn / 10;


                submitBtn.getLayoutParams().width=widthbtn / (25/10);
                submitBtn.getLayoutParams().height=heightbtn / 20;
                submitBtn.setTextSize(widthbtn/35);

                totalQuestionTextView.setTextSize(widthbtn/30);
                questionTextView.setTextSize(widthbtn/20);

                 ansA.setTextSize(widthbtn/35);
                 ansB.setTextSize(widthbtn/35);
                 ansC.setTextSize(widthbtn/35);
                 ansD.setTextSize(widthbtn/35);










                //----------

            int intrCurenta = currentQuestionIndex + 1;
            totalQuestionTextView.setText("Întrebarea " + intrCurenta + "/" + totalQuestion);

            loadNewQuestion();

        }

    void loadNewQuestion(){
        if(currentQuestionIndex == totalQuestion)
        {
            finishQuiz();
            return;
        }

        int intrCurenta = currentQuestionIndex + 1;
        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
                    ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
                    ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
                    ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
                    ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
                    totalQuestionTextView.setText("Întrebarea: " + intrCurenta + "/" + totalQuestion);

    }


    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.parseColor("#064594"));
        ansB.setBackgroundColor(Color.parseColor("#064594"));
        ansC.setBackgroundColor(Color.parseColor("#064594"));
        ansD.setBackgroundColor(Color.parseColor("#064594"));


        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn)
        {
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex]))
            {
                scor++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        }
        else
        {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.rgb(1,45,99));
        }

    }

    void finishQuiz(){
        String passStatus = "";
        String passMsg = "";
        if(scor > totalQuestion * 0.60)
        {
            passMsg = "Ai terminat jocul. Felicitări! (" + scor + "/" + currentQuestionIndex + " puncte)";
        }
        else
        {
            passMsg = "Mai încearcă, vei reuși! (" + scor + "/" + currentQuestionIndex + " puncte)";
        }

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage(passMsg)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .setNegativeButton("Înapoi", (dialogInterface, i) -> closeQuiz() )
                .show();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightbtn = displayMetrics.heightPixels;
        int widthbtn = displayMetrics.widthPixels;

        TextView textView = dialog.findViewById(android.R.id.message);
        textView.setTextSize(widthbtn/30);
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextSize(widthbtn/30);
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextSize(widthbtn/30);
    }



    void closeQuiz(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    void restartQuiz(){
        scor = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
        restarted();
    }

    public static boolean da = false;
    boolean restarted(){
        boolean da;
        da = true;
        return da;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
