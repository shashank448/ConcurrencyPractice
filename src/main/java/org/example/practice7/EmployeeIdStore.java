package org.example.practice7;

import java.util.HashMap;
import java.util.Map;

// This is a singleton class, here its object can only be made once.


public class EmployeeIdStore {
    private final Map<String, String> employees;
    private static EmployeeIdStore INSTANCE = null;

    // Since the constructor is private so it cannot be invoked from outside, we have getInstance for object creation
    private EmployeeIdStore(){
        this.employees = new HashMap<>();
        this.employees.put("101", "Bharat");
        this.employees.put("102", "Vivek");
        this.employees.put("103", "Anoop");
    }
    public static EmployeeIdStore getInstance(){
        if(INSTANCE == null)        // CHECK
            INSTANCE = new EmployeeIdStore();       // THEN ACT
        return INSTANCE;

        // checking INSTANCE and then intialiazing it is COMPOUND ACTION
        // If 2 thread were trying to call the getInstance then it is possible that instead of 1 instance
        // we will have 2 instance of EmployeeIdStore
        // Most of the time, the usecase of Singleton class is when object of it is humoungoes, huge
        // And if you dont have memory to withstand 2 objects of EmployeeIdStore then we will face issue related to memory


    }
}
