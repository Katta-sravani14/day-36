package com.bridgelabz.fourtyuc3anduc4;

import java.time.LocalDate;
import java.util.List;

public class EmployeePayrollData {
    public int id;
    public String name;
    public double salary;
    public String gender;
    public LocalDate startDate;

    public EmployeePayrollData(int id, String name, String gender, double salary, LocalDate startDate) {
        this(id, name, salary, startDate);
        this.gender = gender;
    }

    public EmployeePayrollData(int id, String name, double salary, LocalDate startDate) {
        
        this.startDate = startDate;
    }

    public EmployeePayrollData() {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

	public static void addEmployeesToPayroll(List<EmployeePayrollData> asList) {
		// TODO Auto-generated method stub
		
	}

	public static void addEmployeeToPayRollWIthThreads(List<EmployeePayrollData> asList) {
		// TODO Auto-generated method stub
		
	}

	public static void readEmployeePayrollData(String dbIo) {
		// TODO Auto-generated method stub
		
	}

	public static Object countEntries(Object dB_IO) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<EmployeePayrollData> getEmployeePayrollForDateRange(LocalDate startDate2, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}
}
 