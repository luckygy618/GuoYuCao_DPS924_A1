package com.guoyucao.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    protected Calculator calculator = new Calculator();
    protected TextView resultView;
    protected LinearLayout advView;
    protected Button btnAdv;
    protected View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            awesomeButtonClicked(v);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultView = (TextView)findViewById(R.id.showResult);
        advView = (LinearLayout)findViewById(R.id.advView);
        advView.setVisibility(View.GONE);
        btnAdv = (Button) findViewById(R.id.advance);

        //using   android:onClick="awesomeButtonClicked" also works same as using btn1.setOnClickListener(clickListener);


        Button btnMod = (Button) findViewById(R.id.btnMod);
        Button btnMini = (Button) findViewById(R.id.btnMini);
        Button btnMax = (Button) findViewById(R.id.btnMax);
        Button btnPow = (Button) findViewById(R.id.btnPow);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9);
        Button btn0 = (Button) findViewById(R.id.btn0);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnMin = (Button) findViewById(R.id.btnMin);
        Button btnMul = (Button) findViewById(R.id.btnMul);
        Button btnDiv = (Button) findViewById(R.id.btnDiv);

        Button btnE = (Button) findViewById(R.id.btnE);

        btn4.setOnClickListener(clickListener);
        btn5.setOnClickListener(clickListener);
        btn6.setOnClickListener(clickListener);
        btn7.setOnClickListener(clickListener);
        btn8.setOnClickListener(clickListener);
        btn9.setOnClickListener(clickListener);
        btn0.setOnClickListener(clickListener);
        btnAdd.setOnClickListener(clickListener);
         btnMin.setOnClickListener(clickListener);
         btnMul.setOnClickListener(clickListener);
         btnDiv.setOnClickListener(clickListener);

         btnE.setOnClickListener(clickListener);
         btnAdv.setOnClickListener(clickListener);
         btnMod.setOnClickListener(clickListener);
         btnMini.setOnClickListener(clickListener);
         btnMax.setOnClickListener(clickListener);
         btnPow.setOnClickListener(clickListener);






    }

    public void awesomeButtonClicked(View v){
        if(resultView.getText().toString().contains("Error:")||resultView.getText().toString().contains("=")){
            resultView.setText("");
            calculator.clear();
        }

        String tag = (String)v.getTag();
        if(tag.equals("C")){
            resultView.setText("");
            calculator.clear();
        }else if(tag.equals("=")){
            String result = calculator.getResult();
            resultView.setText(result);
        }else if(tag.equals("advance")){
            v.setTag("standard");
            btnAdv.setText("STANDARD");
            advView.setVisibility(View.VISIBLE);

        }else if(tag.equals("standard")){
            v.setTag("advance");
            btnAdv.setText("ADVANCE - SCIENTIFIC");
            advView.setVisibility(View.GONE);
        }


        else{
            calculator.push(tag);
            resultView.setText(calculator.getInput());

        }

    }





}