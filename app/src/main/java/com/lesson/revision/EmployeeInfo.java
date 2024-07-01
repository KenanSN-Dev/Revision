package com.lesson.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/*step 3 : prepare method getInput to get the data from user's input
* step 4 : create the save file where the user's data will be saved
* step 5 : create saveData method that puts the user's data inside the save file when we press the button save
* step 6 : there is no code for going back to the EmployeeProfile activity we use the back button on the phone*/
//this is the class where we handle the code in the employee info activity
public class EmployeeInfo extends AppCompatActivity {
    //first step here is to inflate all of the elements in the activity
    //we declare them as new properties first
    EditText et_name;
    EditText et_age;
    EditText et_career;

    String name;
    String age;
    String career;

    Button bt_save;
    SharedPreferences.Editor edit;

    //we use the inflate methods in the onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_info);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_career = findViewById(R.id.et_career);
        bt_save = findViewById(R.id.bt_save);
        sharedPreference();
    }
    //to save when we click on button "save", we have to create a save file first
    //we declare the object edit of SharedPreferences.Editor class in the beginning of the class so we can use it anywhere we would like.
    private void sharedPreference() {
        SharedPreferences sp = getSharedPreferences("employeeinfo", MODE_PRIVATE);
        edit = sp.edit();
        saveData();


    }

    //saveData method here handles what happens when we click the button. in this case, save the data.
    //we call on method getData so we can reach the prepared data
    //putString methods puts them inside the saved file
    //method apply applies all changes.
    private void saveData() {
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInput();
                edit.putString("name", name);
                edit.putString("age", age);
                edit.putString("career", career);
                edit.apply();
            }
        });
    }

    //to be able to use the data that are going to be entered into the fields, we need to prepare them by turning them into strings.
    //we declare new variables in the beginning of the class so we can use the prepared data anywhere in the class.
    //Example:
    private void getInput() {
        name = et_name.getText().toString();
        age = et_age.getText().toString();
        career = et_career.getText().toString();

    }

}