package com.lesson.revision;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
/*step 1: inflate menu to create menu options
* step 2: handle settings item selection through intent
* step 3: EmployeeInfo
* step 6: we create getData method to get the data in the save file.
* step 7: we create the recyclerview and recycler adapter to display the input data in our design
* step 13 : we declare the ArrayList here, because this is the class of the EmployeeProfile activity where the recyclerview is
* step 14 : after we declare an array list we make the createList method,the create list method is called after the get data method
* so it creates the list from the data we received from the save file
* step 15 : after we the createList method, we set the adapter with the pressing of restore button
* step 16 : RecyclerAdapter*/
// after  we made the menu that takes us to employee info, we finished preparing the employee info class, we come back here to handle the restore button and recyclerview
public class EmployeeProfile extends AppCompatActivity {
   private String name;
   private String age;
   private String career;
   RecyclerView recyclerView;

   Button bt_restore;
   //we declare the arraylist in the beginning of the class so we can use it anywhere inside the class
    //we need to make teh dataclass then getData method.
    //we use the data class as the generic type.
   private ArrayList<Employee> list= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_profile);
        bt_restore = findViewById(R.id.bt_restore);
        recyclerView = findViewById(R.id.rv_list);


        setAdapter();
    }

    // after we made our createList method, we need to set the adapter, before we set the adapter we have to make an adapter constructor
    //the adapter's job is to fill in data inside the recyclerview
    // after we make the adapter constructor the setAdapter method will apply those changes when restore button is pressed.
    private void setAdapter()
    {
        bt_restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                createList();
                recyclerView.setAdapter(new RecyclerAdapter(list));
            }
        });


    }

   //after we make teh getData method we can create the createList method, this method adds data to our list using the variables handled in getData.
    private void createList() {
        list.add(new Employee(name,age,career));
    }

    //we make an object 0f SharedPreferences with the same keywords as the save file we made earlier.
    // we use getString() method to give the recyclerview variables keywords and default values.
    private void getData() {
        SharedPreferences sp = getSharedPreferences("employeeinfo", MODE_PRIVATE);
       name =  sp.getString("name","ali");
        age = sp.getString("age","30");
        career = sp.getString("career","physician");

    }
    //when creating a menu, we have to first create the xml file & design for it than we can use the onCreateOptionsMenu method.
    //we use the OnCreateOptionMethod to inflate the manu
    //Example:
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.main_manu, menu);
        return true;
    }
    //we use the method onOptionsItemSelected to execute a code when an item is clicked in the menu options
    //the item parameter represents the option we clicked on
    //Example:
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //we use the if statement for each option in the menu
        if (item.getItemId() == R.id.it_settings) {
            //intent here will take us to another activity once the option is selected
            //we have already created another activity which where we will go using this intent code.
            Intent intent = new Intent(this, EmployeeInfo.class);
            startActivity(intent);

        }
        return true;
    }
}