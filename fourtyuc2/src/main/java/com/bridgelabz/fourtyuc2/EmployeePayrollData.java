package com.bridgelabz.fourtyuc2;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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
        this(id, name, salary);
        this.startDate = startDate;
    }
    public EmployeePayrollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeePayrollData)) return false;
        EmployeePayrollData that = (EmployeePayrollData) o;
        return id == that.id &&
                Double.compare(that.salary, salary) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,gender,salary,startDate);
    }
	public List<EmployeePayrollData> readData() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<EmployeePayrollData> getEmployeePayrollData(String name2) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<EmployeePayrollData> getEmployeePayrollForDateRange(LocalDate startDate2, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}
	public EmployeePayrollData addEmployeeToPayroll(String name2, double salary2, LocalDate startDate2,
			String gender2) {
		// TODO Auto-generated method stub
		return null;
	}
	public int updateEmployeeData(String name2, double salary2) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static EmployeePayrollService getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}