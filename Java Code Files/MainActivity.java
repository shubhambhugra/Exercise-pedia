package com.example.exercisepedia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button CONVERSION,chest,back,shoulder,bisceps,triceps,legs,dietbutton,homeworkout;
    EditText WeightKG,HEIGHTCM;
    TextView SHOWbmi,diet;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeightKG = findViewById(R.id.WeightKG);
        HEIGHTCM = findViewById(R.id.HEIGHTCM);
        CONVERSION = findViewById(R.id.CONVERSION);
        SHOWbmi = findViewById(R.id.SHOWbmi);
        chest = findViewById(R.id.CHEST);
        back = findViewById(R.id.BACK);
        shoulder = findViewById(R.id.SHOULDER);
        bisceps = findViewById(R.id.BISCEPS);
        triceps = findViewById(R.id.TRICEPS);
        legs = findViewById(R.id.LEGS);
        dietbutton = findViewById(R.id.diet);
        diet = findViewById(R.id.dietbox);
        homeworkout = findViewById(R.id.homeWorkout);



        //    HomeWorkout:-
        homeworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHomeWorkout = new Intent(MainActivity.this,HomeWorkout.class);
                startActivity(intentHomeWorkout);
            }
        });


        //        BMI conversion:-
        CONVERSION.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String strWeight = WeightKG.getText().toString();
                String strHeight = HEIGHTCM.getText().toString();

                if(strHeight.length() ==0 || strWeight.length()==0){
                    Toast.makeText(MainActivity.this, "Fill The Details", Toast.LENGTH_SHORT).show();
                }
                else {
                    double FinalWeight = Double.parseDouble(strWeight);
                    double FinalHeight = Double.parseDouble(strHeight) / 100;

                    double result = FinalWeight / (FinalHeight * FinalHeight);
                    String resultStr = String.format("%.2f", result);

                    if (result < 18.5) {
                        SHOWbmi.setText(resultStr+" (Undernourished)");
                    } else if (result > 18.5 && result < 24.9) {
                        SHOWbmi.setText(resultStr+" (Normal)");
                    } else if (result > 25 && result < 29.9) {
                        SHOWbmi.setText(resultStr+" (Overweight)");
                    } else if (result > 30) {
                        SHOWbmi.setText(resultStr+" (Obesity)");
                    }
                    Toast.makeText(MainActivity.this, "BMI Updated", Toast.LENGTH_SHORT).show();

                    //    Diet button
                    dietbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (result < 18.5) {
                                String food = "As You are Unernourished,Do follow this:-\n" +
                                        "1.) Do Exercise at least 45min Daily.\n" +
                                        "2.) You can eat 2 bananas,1 apple at a time.\n" +
                                        "3.) Focus on Carbs along with protien,Drink Milk regularly.\n" +
                                        "4.) You Can use Peanut Butter over bread to become Protien rich, and can have oats meal.\n" +
                                        "5.) For more Gains and Muscles eat Chicken,SoyaBean,Paneer.";
                                diet.setText(food);
                            } else if (result > 18.5 && result < 24.9) {
                                String food = "As You are Normal Do follow this:-\n" +
                                        "1.) Do Exercise at least 30min Daily.\n" +
                                        "2.) You can eat 2 bananas,1 apple at a time.\n" +
                                        "3.) Avoid Junk Food , Focus on Boiled Egg!\n" +
                                        "4.) You Can use Peanut Butter over bread to become Protien rich.\n" +
                                        "5.) For more Gains and Muscles eat Chicken,SoyaBean,Paneer.";
                                diet.setText(food);
                            } else if (result > 25 && result < 29.9) {
                                String food = "As You are OverWeight Do follow this:-\n" +
                                        "1.) Do Exercise at least 1hour Daily.\n" +
                                        "2.) You can eat 2 bananas,1 apple,papaya at a time.\n" +
                                        "3.) Avoid Junk Food , Focus on Boiled Egg,Salad etc.!\n" +
                                        "4.) Avoid Butter,softdrinks prefer Fresh Juice\n" +
                                        "5.) Avoid SweetDishes it contains unsaturated sugar.";
                                diet.setText(food);
                            } else if (result > 30) {
                                String food = "As You come under Obesity,Do follow this:-\n" +
                                        "1.) Do Exercise at least 90mins Daily.\n" +
                                        "2.) In case of obesity,you need to avoid excessive sugar dish or items.\n" +
                                        "3.) Delete Junk Food From your List compltely.\n" +
                                        "4.) Focus on protien items and avoid Carbs.\n" +
                                        "5.) Be positive , Happy Eating.";
                                diet.setText(food);
                            }
                        }

                    });
                }

            }
        });


//        Chest Onclick:-
         chest.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intentchest = new Intent(MainActivity.this,ChestActivity.class);
                 startActivity(intentchest);
             }
         });
//         Back Onclick:-
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentback = new Intent(MainActivity.this,BackActivity.class);
                startActivity(intentback);
            }
        });
//        Shoulder Onclick:-
        shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentshoulder = new Intent(MainActivity.this,ShoulderActivity.class);
                startActivity(intentshoulder);
            }
        });
//        Bisceps Onclick:-
        bisceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBisceps = new Intent(MainActivity.this,BiscepsActivity.class);
                startActivity(intentBisceps);
            }
        });

//        Triceps Onclick:-
        triceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTriceps = new Intent(MainActivity.this,TricepActivity.class);
                startActivity(intentTriceps);
            }
        });

//         leg Activity:-
        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLegs = new Intent(MainActivity.this,LegActivity.class);
                startActivity(intentLegs);
            }
        });
    }





}