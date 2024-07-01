package com.lesson.revision;

public class Employee
{
    //declare variables based on how the design going to look like, we have 3 views for name and age and career in the design.
    //we make the constructor receive them all
    //we use a getter method for each variable so we can use it later to add data inside each view in the recyclerview adapter.
    private String name;
    private String age;
    private String career;

    public Employee(String name, String age, String career) {
        this.name = name;
        this.age = age;
        this.career = career;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCareer() {
        return career;
    }
}
