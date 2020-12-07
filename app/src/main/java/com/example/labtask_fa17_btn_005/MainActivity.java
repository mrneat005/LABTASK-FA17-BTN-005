package com.example.labtask_fa17_btn_005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
private TextView display;
   private String[] Questions;
   private Button check;
   public boolean watch = true;
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               //maketoast(String.valueOf(position));
                if(position==0)
                {
                    watch =true;
                }
                else
                {
                    //Toast.makeText(this,"Wrong Answer",Toast.LENGTH_LONG).show();
                    //displayQuestion(getRandomNumberInRange(0,2));
                        watch=false;
                }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private String[] Answers;
   private Spinner spinner;
   private int Qno=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Getting Resource
        Resources res = getResources();
        Questions = res.getStringArray(R.array.Questions);
        Answers = res.getStringArray(R.array.Answers);
        display =findViewById(R.id.Ques_display);
        spinner = findViewById(R.id.spinner);
        displayQuestion(Qno);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.bool,android.R.layout.simple_spinner_item);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
check = findViewById(R.id.check);
check.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        maketoast("Your Answer :"+String.valueOf(watch)+"\n Right Answer :"+Answers[Qno]);
  /*      if(String.valueOf(watch)==Answers[Qno])
        {
            maketoast("Right Answer...!");
        }
        else
        {
            maketoast("Wrong Answer...!");

        }
        */

        Qno = getRandomNumberInRange(0,2);
        displayQuestion(Qno);
    }
});

    }

    private void displayQuestion(int id)
    {
        //just clearing the field if there is a Question already..
        display.setText("");
        //setting up the field...
        display.setText(Questions[id]);

    }
    //Random Integer
    private int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void maketoast(String s)
    {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }



}