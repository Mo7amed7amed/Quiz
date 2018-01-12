package com.example.mohamed.quiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.text;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Check Question1's Answers
    final private int Answer1 = R.id.Buttun1_2;
      private boolean Question_1() {
        RadioGroup result = (RadioGroup) findViewById(R.id.RadioGroup1);
        return result.getCheckedRadioButtonId() == Answer1;
    }
    //Check Question2's Answers
    final private int Answer2 = R.id.Buttun2_1;
    private boolean Question_2() {
        RadioGroup result = (RadioGroup) findViewById(R.id.RadioGroup2);
        return result.getCheckedRadioButtonId() == Answer2;
    }
    //Check Question3's Answers
    private boolean Question_3() {
        CheckBox result1 = (CheckBox) findViewById(R.id.checkbox_3_1);
        CheckBox result2 = (CheckBox) findViewById(R.id.checkbox_3_2);
        CheckBox result3 = (CheckBox) findViewById(R.id.checkbox_3_3);
        CheckBox result4 = (CheckBox) findViewById(R.id.checkbox_3_4);

        return result1.isChecked() && !result2.isChecked() && result3.isChecked() && !result4.isChecked();
    }
    //Check Question4's Answers
    private boolean Question_4() {
        CheckBox result1 = (CheckBox) findViewById(R.id.checkbox_4_1);
        CheckBox result2 = (CheckBox) findViewById(R.id.checkbox_4_2);
        CheckBox result3 = (CheckBox) findViewById(R.id.checkbox_4_3);
        CheckBox result4 = (CheckBox) findViewById(R.id.checkbox_4_4);

        return !result1.isChecked() && result2.isChecked() && !result3.isChecked() && result4.isChecked();
    }
    //Check Question5's Answers
    private boolean Question_5(){
        EditText editText=(EditText)findViewById(R.id.editText);
        String Ans =editText.getText().toString();
        if(Ans.toLowerCase().equals("mohamed")) {
                 }
        return editText.getText().toString().equalsIgnoreCase("mohamed");}
    public void clickSubmit(View view) {
        ArrayList<String> Wrong = new ArrayList<>();
        int Score=0;
        if (Question_1()) {
            Score += 20;
        } else {
            Wrong.add(" Question_1 is Wrong or Not Answered ");
        }

        if (Question_2()) {
            Score+= 20 ;
        } else {
            Wrong.add(" Question_2 is Wrong or Not Answered ");
        }

        if (Question_3()) {
            Score+= 20;
        } else {
            Wrong.add(" Question_3 is Wrong or Not Answered ");
        }

        if (Question_4()) {
            Score+= 20;
        } else {
            Wrong.add(" Question_4 is Wrong or Not Answered ");
        }

        if (Question_5()) {
            Score+= 20;
        } else {
            Wrong.add(" Question_5 is Wrong or Not Answered ");
        }
        CharSequence Message = "Congratulations  !! \n Your Score Is :" + Score + "\n Please Check The Following Question: \n" +  Wrong.toString();

        Toast toast = Toast.makeText(MainActivity.this, Message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
