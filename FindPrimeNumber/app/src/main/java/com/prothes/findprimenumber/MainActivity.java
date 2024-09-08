package com.prothes.findprimenumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText inputField1,inputField2,inputField3;
    private AppCompatButton btn1,btn2;
    private TextView display1,display2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setStatusBarColor(getColor(R.color.sky));
        this.getWindow().setNavigationBarColor(getColor(R.color.sky));
        setContentView(R.layout.activity_main);

        inputField1 = findViewById(R.id.inputField1);
        inputField2 = findViewById(R.id.inputField2);
        inputField3 = findViewById(R.id.inputField3);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        display1 = findViewById(R.id.display1);
        display2 = findViewById(R.id.display2);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getData = inputField1.getText().toString();
                if (getData.length()>0){
                    int num1,count=0;
                    num1 = Integer.parseInt(getData);
                    for (int i=2; i<num1; i++){
                        if (num1%i == 0) {
                            count++;
                            break;
                        }
                    }

                    if (count == 0){
                        display1.setText(num1+" : is Prime Number");
                    }else {
                        display1.setText(num1+" : is Not Prime Number");
                    }

                }else{
                    display1.setText(null);
                    inputField1.setError("Empty");
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getData2 = inputField2.getText().toString();
                String getData3 = inputField3.getText().toString();
                if (getData2.length()>0 && getData3.length()>0){
                    int minNum,maxNum;
                    minNum = Integer.parseInt(getData2);
                    maxNum = Integer.parseInt(getData3);
                    StringBuilder stringBuilder = new StringBuilder();


                    if (minNum<maxNum){
                        for (int i=minNum; i<=maxNum; i++){
                            int count = 0;
                            for (int j=2; j<i; j++){
                                if (i%j == 0){
                                    count++;
                                    break;
                                }
                            }
                            if (count ==0 && i != 1){
                                stringBuilder.append(i+" ");
                            }
                        }
                        display2.setText(""+stringBuilder);
                    }else{
                        Toast.makeText(MainActivity.this, "2nd input must be big than 1st input", Toast.LENGTH_SHORT).show();
                        display2.setText(null);
                        inputField2.setText(null);
                        inputField3.setText(null);
                    }

                } else if (getData2.length()>0) {
                    inputField2.setError(null);
                    if (getData3.length()>0){
                        inputField3.setError(null);
                    }else{
                        inputField3.setError("Empty");
                        display2.setText(null);
                    }

                } else if (getData3.length()>0) {
                    inputField3.setError(null);
                    if (getData2.length()>0){
                        inputField2.setError(null);
                    }else{
                        inputField2.setError("Empty");
                        display2.setText(null);
                    }
                } else{
                    display2.setText(null);
                    inputField2.setError("Empty");
                    inputField3.setError("Empty");
                }
            }
        });


    }
}