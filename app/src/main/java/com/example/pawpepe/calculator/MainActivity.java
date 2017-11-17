package com.example.pawpepe.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.*;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private Button dot, b1,b2,b3,b4,b5,b6,b7,b8,b9,b0, bplus,bminus, bdiv, beq, bmul,bac, bpow,  blog,bsqr;
    TextView disp;
    String display="";
    String a = null;
    Stack<Double> st = new Stack<Double>();
    int sign = 1;
    int flag = 0;// flag == 1 multiplication, flag==2 division, flag=3 fat, flag=4 square root, flag=5 log
    String numberIn ="";
    String aux="";
    double number, auxNum, result;
    int i;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Setting buttons to their UI id
        initButtonId();
        //adding listeners and action to the buttons
        buttonsListeners();

    }



    private void initButtonId(){

        disp = (TextView)  findViewById(R.id.disp);
        bac = (Button) findViewById(R.id.ac);
        b0 = (Button) findViewById(R.id.n0);
        b1 = (Button) findViewById(R.id.n1);
        b2 = (Button) findViewById(R.id.n2);
        b3 = (Button) findViewById(R.id.n3);
        b4 = (Button) findViewById(R.id.n4);
        b5 = (Button) findViewById(R.id.n5);
        b6 = (Button) findViewById(R.id.n6);
        b7 = (Button) findViewById(R.id.n7);
        b8 = (Button) findViewById(R.id.n8);
        b9 = (Button) findViewById(R.id.n9);

        bminus = (Button) findViewById(R.id.minus);
        bplus = (Button) findViewById(R.id.plus);
        bdiv = (Button) findViewById(R.id.div);
        bmul = (Button) findViewById(R.id.mul);
        beq = (Button) findViewById(R.id.equal);
        dot = (Button) findViewById(R.id.dot);
        bpow = (Button) findViewById(R.id.pow);
        bsqr = (Button) findViewById(R.id.sqr);
        blog = (Button) findViewById(R.id.log);

    }


    private void buttonsListeners(){
        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st.clear();
                display="";
                numberIn="";
                result = 0;
                sign = 1;
                flag=0;
                disp.setText(display);
                enableButtons();
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberIn.isEmpty()==false){
                    numberIn += b0.getText().toString();
                    display+=b0.getText().toString();
                    disp.setText(display);
                }

            }

        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberIn += b1.getText().toString();
                display+=b1.getText().toString();
                disp.setText(display);
            }

        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberIn += b2.getText().toString();
                display+=b2.getText().toString();
                disp.setText(display);
            }

        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberIn += b3.getText().toString();
                display+=b3.getText().toString();
                disp.setText(display);

            }

        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberIn += b4.getText().toString();
                display+=b4.getText().toString();
                disp.setText(display);
            }

        });


        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberIn += b5.getText().toString();
                display+=b5.getText().toString();
                disp.setText(display);
            }

        });


        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberIn += b6.getText().toString();
                display+=b6.getText().toString();
                disp.setText(display);
            }

        });


        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberIn += b7.getText().toString();
                display+=b7.getText().toString();
                disp.setText(display);
            }

        });


        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberIn += b8.getText().toString();
                display+=b8.getText().toString();
                disp.setText(display);
            }

        });


        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberIn += b9.getText().toString();
                display+=b9.getText().toString();
                disp.setText(display);
            }

        });


        bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display+=bminus.getText().toString();
                disp.setText(display);
                addStack();
                enableButtons();
                sign = -1;
            }
        });


        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display+=bplus.getText().toString();
                disp.setText(display);
                addStack();
                enableButtons();
                sign = 1;
            }
        });


        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display+=bdiv.getText().toString();
                disp.setText(display);
                addStack();
                enableButtons();
                flag = 2;
            }
        });


        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display+=bmul.getText().toString();
                disp.setText(display);
                addStack();
                enableButtons();
                flag = 1;
            }
        });



        beq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStack();
                //sum all the values on the stack and display result
                if(st.empty()==false){
                    while(!st.empty()){
                        result += st.pop();
                    }
                    display = Double.toString(result);
                    disp.setText(display);

                    // saving the result(display) on the var 'numberIn' guarantees ir will be add to the stack for future operations
                    numberIn = display;
                    disableButtons();
                    result=0;

                }
            }
        });


        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aux = dot.getText().toString();
                //check if there isnt  a dot on the string already
                if(!numberIn.contains(aux)){
                    numberIn+=aux;
                    display+=aux;
                    disp.setText(display);
                }
            }
        });


        bpow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag =3;
                addStack();
                display+="^2";
                numberIn="";
                disp.setText(display);
            }
        });


        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display+="log";
                disp.setText(display);
                flag=5;
            }
        });


        bsqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display+="sqr";
                disp.setText(display);
                flag=4;
            }
        });

    }

    // Adding operation values to the stack
    void addStack() {
        if(numberIn.compareTo("") != 0) {
            try {
                number = Double.parseDouble(numberIn);
            } catch (NumberFormatException e) {

            }
        }

        if(flag!=0){

            switch (flag){
                case 1:
                    auxNum = st.pop();
                    number = auxNum*number;
                    break;
                case 2:
                    auxNum = st.pop();
                    number = auxNum/number;
                    break;
                case 3:
                    number = Math.pow(number,2);
                    break;
                case 4:
                    number = Math.sqrt(number);
                    break;
                case 5:
                    number = Math.log(number);
                    break;
            }

            flag = 0;
        }

        number =  number *sign;
        st.push(number);
        numberIn = " ";
        //tryin
        number = 0;
    }

    //For the operand buttons check if the last char of the "display" is an operand or a number
    Boolean checkLastChar(String s){

        return true;

       // return false;
    }


    //Function to disable all numbers and operations that the attributes comes after
    void disableButtons(){
        b0.setEnabled(false);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
        blog.setEnabled(false);
        bpow.setEnabled(false);
        bsqr.setEnabled(false);
        dot.setEnabled(false);
        beq.setEnabled(false);

    }
    
    void enableButtons(){
        b0.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        blog.setEnabled(true);
        bpow.setEnabled(true);
        bsqr.setEnabled(true);
        dot.setEnabled(true);
        beq.setEnabled(true);
    }

    void disableOperations(){
        bmul.setEnabled(false);
        bplus.setEnabled(false);
        bminus.setEnabled(false);
        beq.setEnabled(false);
        bsqr.setEnabled(false);
    }

    void enableOperations(){
        bmul.setEnabled(true);
        bplus.setEnabled(true);
        bminus.setEnabled(true);
        beq.setEnabled(true);
        bsqr.setEnabled(true);
    }


    // Guarantee that:

    // Cannot input zero if there is no number previously
        //Ex: 02 + 4,  looks better if it's 2 + 4 , design call. Works the same either way
    // Cannot have a dot on a number if one already exists a dot
        //Ex: 1.0.1
    // Cannot input more numbers right after the result, guarantee that there is a operand (+,-,*,/) right after
        // Ex:  result: 50.0  Dont allow: 50.023 typing more numbers should be blocked. Allowed cases: 50.0 + 23 or 50.0 / 23
    // Don't allow division by zero or let it be "Infinity"
    //


    //Improve:
    // It is accepting + . + or +++ or ---- or

    //Possible Solution:
    // 1.Check the last char of the string "display"
    // 2. Once an operand button has been clicked it disables all the other operands and dot( +,-, /, *,.)
        // 2.1 Once a number has been clicked it enables again the operands buttons and the dot button (+,/,*,)



}