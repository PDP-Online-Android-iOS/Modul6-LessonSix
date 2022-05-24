package dev.ogabek.java.model;

import com.google.gson.annotations.SerializedName;

public class EmployeeResult {

    @SerializedName("id")
    private final int id;
    @SerializedName("employee_name")
    private final int employee_name;
    @SerializedName("employee_salary")
    private final String employee_salary;
    @SerializedName("employee_age")
    private final String employee_age;
    @SerializedName("profile_image")
    private final String profile_image;

    public EmployeeResult(int id, int employee_name, String employee_salary, String employee_age, String profile_image) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

    public int getId() {
        return id;
    }

    public int getEmployee_name() {
        return employee_name;
    }

    public String getEmployee_salary() {
        return employee_salary;
    }

    public String getEmployee_age() {
        return employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }
}
