package com.haqqnuru.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

// Global Variables
    RadioGroup radioGroup;
    CheckBox checkBox, checkBox2, checkBox3, checkBox4;
    EditText candidateName, editText, editText2;
    RadioGroup radioGroup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        candidateName = findViewById(R.id.candidateName);
        radioGroup= findViewById(R.id.radionqroup1);
        checkBox = findViewById(R.id.checkboxanswer2);
        checkBox2 = findViewById(R.id.checkboxanswer3);
        checkBox3 = findViewById(R.id.checkboxanswer1);
        checkBox4 = findViewById(R.id.checkboxanswer4);
        editText = findViewById(R.id.editTextAnswerToQ3);
        editText2 = findViewById(R.id.editTextAnswerToQ4);
        radioGroup1 = findViewById(R.id.radionqroup2);
    }


    // called when submit is clicked
    public void submit(View view) {
        // candidateName of person taking the quiz
        String name = candidateName.getText().toString();

        // sum of correct answers
        calculateAnswers();

        // Toast the results
        Toast.makeText(this, getResources().getString(R.string.toast1) +" "+ name +"\n"
                + getResources().getString(R.string.toast2) +" "+ calculateAnswers()+" "+ getResources()
                .getString(R.string.toast3), Toast.LENGTH_SHORT).show();

    }


   // calculates results
    private int calculateAnswers() {

        int answer =0;

        // Question 1: radio buttons, Correct answer = 1957
        if (radioGroup.getCheckedRadioButtonId() == R.id.radionAnswerToQ1) {
            answer += 1;}


        //Question 2: checkBox, Correct answer = John Agykum Kuffour & John Dramani Mahama
        boolean hasBeenChecked = checkBox.isChecked();
        boolean hasBeenChecked1 = checkBox2.isChecked();
        boolean hasBeenChecked2 = checkBox3.isChecked();
        boolean hasBeenChecked3 = checkBox4.isChecked();

        if (hasBeenChecked && hasBeenChecked1 &&!hasBeenChecked2 && !hasBeenChecked3) {
            answer += 1;
        }


        // Question 3: editText, Correct answer = Gold Coast
        if (editText.getText().toString().equalsIgnoreCase(getString(R.string.gold_coast))) {
            answer += 1;
        }

        // Question 4: editText, Correct answer = Cedi
        if (editText2.getText().toString().equalsIgnoreCase(getString(R.string.cedi))){
            answer += 1;
        }

        // Question 5: radio button, Correct answer = Lake Volta
        if (radioGroup1.getCheckedRadioButtonId() == R.id.radionAnswerToQ5) {
            answer += 1;
        }

        // returns the sum of calculateAnswers()
               return answer;
    }




    // resets Quiz
    public void reset(View view) {

        // reset radioGroups
        radioGroup.clearCheck();
        radioGroup1.clearCheck();

        // reset check boxes
        checkBox.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);

        // reset editText
        editText.setText("");
        editText2.setText("");
        candidateName.setText("");

        // Displays a message that Quiz has been cleared
        Toast.makeText(this, R.string.reset_questions, Toast.LENGTH_SHORT).show();
    }
}
