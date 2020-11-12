package com.example.caculatorv5a;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity    implements View.OnClickListener
{


    public static final String HISTORY_EXTRA ="com.example.caculatorv5a.History" ;
    TextView resulDisplay;
    TextView inputDiplay;
    double answer;
    String currentText, sign,   strAnswer, value1, value2;
    ArrayList<String> history = new ArrayList<>();  //    Store results
    private Button btnAC, btnEq,btnMin, btnAdd, btnMult, btnDiv;
    //creating an array of buttons
    String btnText;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._land);
        inputDiplay = findViewById(R.id.userInput);
        inputDiplay.setText("");


        //automatically create button for the digit
        for (int i = 0; i <=9; i++)
        {
            String digitValue = "btn"+i ;
            int resID = getResources().getIdentifier(digitValue,"id", getPackageName()) ;

            final Button button = findViewById(resID);   //pass the int value of the UI element passes

            button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    currentText =  inputDiplay.getText().toString();
                    btnText = button.getText().toString();

                    //double results = calculator(btnText);

                    // stringResult = String.valueOf(results) ;
                    currentText += btnText;

                    //double results = calculator(stringResult);
                    removeTrailingZero(currentText);
                    inputDiplay.setText(currentText);
                   // inputView.setText(stringResult + btnText);
                   // currentText = "";

                }


            });


            // AC button
            btnAC = findViewById(R.id.btnAC );
            btnAdd =    findViewById(R.id.btnAdd );
            btnDiv = (Button) findViewById(R.id.btnDiv );
            btnMin  = (Button) findViewById(R.id.btnSub );
            btnMult  = (Button) findViewById(R.id.btnMult );
            btnEq = (Button) findViewById(R.id.btnEq );

            //

            btnAC.setOnClickListener(this);
            btnAdd.setOnClickListener(this);
            btnDiv.setOnClickListener(this);
            btnMin.setOnClickListener(this);
            btnMult.setOnClickListener(this);
            btnEq.setOnClickListener(this);



        }

        //creating the menu that contain the history and the clear buttons


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();//menu creator
        inflater.inflate(R.menu.main_menu, menu);  //precise the layout of the meu
        return true; //
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)   //work in a similar way as clickONlistener
    {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.men_history:
               Log.d("Menu","History Menu call");
               //create the funtion that display the memory
                Intent intent  = new Intent(MainActivity.this, History.class);
                intent.putStringArrayListExtra(HISTORY_EXTRA, history);
                startActivity(intent);
                return true;
            case R.id.men_clear:
                Log.d("Menu","clear Menu call");
                //call funtion that delete memory content.
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public  void addToHistory(View viw)
    {
        String record = inputDiplay.getText().toString();
        if(!record.isEmpty())
        {
            history.add(record);
            inputDiplay.setText("");
            Log.d("history", "saved " + record);

        }
    }

    
    /***********************************************************/
    //OUTSIDE OF ONCREATE
    //public void
    /***********************************************************/



    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view)
    {
        Button button = (Button)view;
        String data = button.getText().toString();
        switch(data)
        {
            case "AC"  :

                  //call clear();
                currentText ="";
                inputDiplay.setText(currentText);

                break;

            case "+" :
                sign = "+";
                Log.d("Add", "the add was pressedd" + data);
                value1 =   currentText;
                inputDiplay.setText("");
                    

                break;

            case "×"  :
                //currentText ="";
                sign = "*";
                value1 = currentText;
                inputDiplay.setText("");

                break;

            case "÷" :
               
                sign = "/";
                value1 = currentText ;
                inputDiplay.setText("");

                break;

            case "%"  :

                sign = "%";
                value1 = currentText;
                inputDiplay.setText("");

                break;

            case "-" :

                sign = "-";
                value1 = currentText;
                inputDiplay.setText("");

                break;
            case "=":
            {
                if(sign == null)
                {
                    inputDiplay.setText("Sign value is null");
                }
                else if(inputDiplay.getText().equals(""))
                {
                    inputDiplay.setText("Error");  //to be checked
                }
                else
                    switch (sign)
                    {
                        case "+":

                            value2 = currentText;
                                    //inputDiplay.getText().toString();
                            String strAnswer = value1 + sign + value2;
                            Log.d("String", "String value1 is"+ value1);
                            Log.d("String", "String value2 is"+ value2);
                            Log.d("String", "String strAnswer is"+ strAnswer);
                            double answer = calculator(strAnswer);
                            inputDiplay.setText( removeTrailingZero(String.valueOf(answer)));
                        case "*":
                            value2 = currentText;
                            //inputDiplay.getText().toString();
                             strAnswer = value1 + sign + value2;
                            Log.d("String", "String value1 is"+ value1);
                            Log.d("String", "String value2 is"+ value2);
                            Log.d("String", "String strAnswer is"+ strAnswer);
                            answer = calculator(strAnswer);
                            inputDiplay.setText( removeTrailingZero(String.valueOf(answer)));

                            break;
                        case "/":

                            value2 = currentText;
                            //inputDiplay.getText().toString();
                            strAnswer = value1 + sign + value2;
                            Log.d("String", "String value1 is"+ value1);
                            Log.d("String", "String value2 is"+ value2);
                            Log.d("String", "String strAnswer is"+ strAnswer);
                            answer = calculator(strAnswer);
                            inputDiplay.setText( removeTrailingZero(String.valueOf(answer)));

                            break;

                            
                        case "-":
                            value2 = currentText;
                            //inputDiplay.getText().toString();
                            strAnswer = value1 + sign + value2;
                            answer = calculator(strAnswer);
                            inputDiplay.setText( removeTrailingZero(String.valueOf(answer)));
                            break;

                        default:
                            inputDiplay.setText("Wrong sign");

                    }
            }
            break;


            default  :
                Log.d("Data", "the data value is " + data);
                currentText = "Holy Shit!";
                inputDiplay.setText(currentText);

        }
        // stringResult += currentText;


    }

   


    private String removeTrailingZero(String formattingInput)
    {
        if(!formattingInput.contains("."))
        {
            return formattingInput;
        }
        int dotPosition = formattingInput.indexOf(".");
        String newValue = formattingInput.substring(dotPosition);
        if(newValue.equals(".0"))
        {
            return formattingInput.substring(0, dotPosition);
        }
        return formattingInput;
    }




    /***********************************************************/
    //calculator function
    //handle the operation
    /***********************************************************/

    public static double calculator(final String stringOpp)
    {


        return new Object()
        {


            int initialPos = -1;//position before the zero index
            int mChar;//hold individual char of the string

            void nextChar() //extract each char along as the initial position is less than length of the string
            {
                if (++initialPos < stringOpp.length())
                    mChar = stringOpp.charAt(initialPos);
                else mChar = -1;
                //if initial index is less that lenth(;)
            }

            boolean whiteSkipper(int charToExtract)//prevent to have any operation on a white space
            {
                while(mChar ==' ')
                    nextChar();


                if (mChar ==charToExtract)
                {
                    nextChar();
                    return true;
                }

                return false;
            }

            double parse()
            {
                nextChar();
                double x = opperation();
                return  x;
            }


            double opperation()
            {
                double input = operator();
                while(true)
                {
                    if(whiteSkipper('+'))
                        input += operator();
                    else if (whiteSkipper('-'))
                        input -= operator();
                    else if(whiteSkipper('*'))
                        input *= operator();
                    else if (whiteSkipper('/'))
                        input/= operator();
                    else
                        return input;

                }
            }





            //
            double operator()
            {
                if (whiteSkipper('+')) return operator();
                if (whiteSkipper('-')) return -operator();
                if (whiteSkipper('*')) return operator();
                if (whiteSkipper('/')) return -operator();
                double input;
                int startPos = this.initialPos;
                if ((mChar >= '0' && mChar <= '9') || mChar == '.')
                    while ((mChar >= '0' && mChar <= '9') || mChar == '.')
                        nextChar();
                input = Double.parseDouble(stringOpp.substring(startPos,this.initialPos));//




                return input;
            }



        }.parse();




    }
    

}
