package com.aaa.LoginFacebook.CalculatorApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import  com.aaa.LoginFacebook.CalculatorApp.StackCalculator;
import com.aaa.LoginFacebook.R;

public class Calculator extends AppCompatActivity {
    TextView ShownTextView;
    TextView ResultTextView;
    char PreviosClickedButtonText='+';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        ShownTextView=findViewById(R.id.Shown_Text_View);
        ResultTextView=findViewById(R.id.Text_View2);
        Button xButtonDelete = findViewById(R.id.XButtonDelete);
        xButtonDelete.setOnClickListener(
                v -> {
                    this.DeleteLastCharacter();
                }
        );
        Button equalButton= findViewById(R.id.EqualButton);
        equalButton.setOnClickListener(
                v -> {
                    this.CalcSum(equalButton);

                });
    }
    public void onDigitClick(View v){
        CharSequence CurrentClickedButtonText=  ((Button) v).getText();

        if (StackCalculator.isOperator(PreviosClickedButtonText)&&  StackCalculator.isOperator(CurrentClickedButtonText.charAt(0))){
            this.DeleteLastCharacter();
            ShownTextView.append( CurrentClickedButtonText);
        }
        else {
            ShownTextView.append(CurrentClickedButtonText);

        }
        PreviosClickedButtonText=CurrentClickedButtonText.charAt(0);

    }
    public void DeleteLastCharacter(){
        String OriginalText= ShownTextView.getText().toString();
        if(!OriginalText.isEmpty())ShownTextView.setText(OriginalText.substring(0, OriginalText.length() - 1));

    }
    public void EmptyTheTextView(View v){
        ShownTextView.setText("");
    }
    public void CalcSum(View v) {
        try {
            double result = StackCalculator.evaluateExpression(ShownTextView.getText().toString());
            ResultTextView.setText(Double.toString(result));
        } catch (Exception e) {
            ResultTextView.setText("Error");
            e.printStackTrace();
        }
    }
}
