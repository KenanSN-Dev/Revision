package com.lesson.revision;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
/*step 8 : after extending, we create the viewHolder innerclass and make the generic type.
* step 9 : create the layout for the item design
* step 10 : inflate layout in onCreateViewHolder
* step 11 : inflate views  on the design in the innerclass
* step 12 : after inflating we send the inflated layout to the new object of our viewHolder innerclass
* The ViewHolder pattern is used to improve the performance of RecyclerView by recycling views as they go off-screen, rather than inflating new views each time.
* step 13 : in employee profile
* Step 16 : after setting the adapter in EmployeeProfile, in onBindViewHolder, we take the data from the list we made, and we put it inside the views
* step 17 : we make the count the same size as the list. */
//after we created the recyclerview, we need to make the RecyclerAdapter
//we make the adapter inherit the adapter class as a first step, the adapter class take a generic type of ViewHolder.
//after we make inherit the adapter class, we don't fill in the generic type until we make our inner class that inherits ViewHolder.
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.EmployeeViewHolder>
{
    private ArrayList<Employee> list;
    //the parameter for our adapter constructor is the list we have made.
    public RecyclerAdapter(ArrayList<Employee> list)
    {
        this.list = list;
    }

    // after we make the inner class, we inflate the item design, then we create and object of the inner class to be able to handle it in the onBindViewHolder.
    @Override
    public EmployeeViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_design, parent,false);
        EmployeeViewHolder employeeViewHolder = new EmployeeViewHolder(view);
        return employeeViewHolder;
    }
    //we need to go EmployeeProfile to create an arraylist, so we can put data inside the recycler view, and handle it inside onBindViewHolder
    //onBindViewHolder is used like a for loop where it takes each item represented by int position, and places the values inside the views.
    @Override
    public void onBindViewHolder( EmployeeViewHolder holder, int position)
    {
        // we made an object of the data class Employee and gave it the value of one of the elements of the arraylist, which is going to be an object of Employee
        Employee employee = list.get(position);
        //we used the methods setText, to enter text into each view.
        holder.tv_name.setText(employee.getName());
        holder.tv_age.setText(employee.getAge());
        holder.tv_career.setText((employee.getCareer()));
    }
    //the count is the same size of the list.
    @Override
    public int getItemCount() {
        return list.size();
    }

    //we make the inner class inherit ViewHolder, we make an item design for the recyclerview.
    //we inflate the elements in the item design.
    //we use the innerclass object to be able to handle the data inserted in the field by the user.
    class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_age;
        TextView tv_career;
        public EmployeeViewHolder( View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_age = itemView.findViewById(R.id.tv_age);
            tv_career = itemView.findViewById(R.id.tv_career);

        }
    }
}
