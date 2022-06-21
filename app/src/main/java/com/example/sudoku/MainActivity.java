package com.example.sudoku;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

//AppCompatActivity - base layout that support library with action button features
public class MainActivity extends AppCompatActivity {
    int selectedDifficulty = 0;

    //bundle- to pass data from one activity to another
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView as a layout from one of the xml files 
        //(setContentView(R.layout.activity_main);
    }

    //Intent - carries info about the android studio system to determine the component
    public void onStartNewGame(View view){
        //Intent intent = new Intent(location of board);
        //startActivity(intent);
    }

    public void onDifficultyRadioButtonsClicked(View view){
        /*boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radioButtonEasy:
                if (checked){
                    selectedDifficulty = 0;
                }
                break;
            case R.id.radioButtonNormal:
                if (checked){
                    selectedDifficulty = 1;
                }
                break;
            case R.id.radioButtonHard:
                if (checked){
                    selectedDifficulty = 2;
                }
                break;
        }
         */
    }

    public void onShowInstructionsButtonClicked(View view){
        //Intent intent = new Intent(location of GameDifficultyActivity)
        //startActivity(intent)
    }
}
