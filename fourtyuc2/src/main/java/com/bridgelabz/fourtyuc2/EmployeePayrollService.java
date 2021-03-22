package com.bridgelabz.fourtyuc2;


import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeePayrollService {

    public enum IOService{FILE_IO, DB_IO}
    private List<EmployeePayrollData> employeePayrollList;
    private static EmployeePayrollService employeePayrollDBService;
    public EmployeePayrollService() {
        employeePayrollDBService = EmployeePayrollData.getInstance();
    }
    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this();
        this.employeePayrollList = employeePayrollList;
    }
    public List<EmployeePayrollData> readEmployeePayrollData(IOService ioservice) {
        if (ioservice.equals(IOService.DB_IO)){
            this.employeePayrollList= employeePayrollDBService.readData();
        }
        return this.employeePayrollList;
    }
   
	
   
    private List<EmployeePayrollData> readData() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<EmployeePayrollData> readEmployeePayrollForDateRange(IOService ioService,
                                                                     LocalDate startDate, LocalDate endDate) {
        if (ioService.equals(IOService.DB_IO)) {
            return employeePayrollDBService.getEmployeePayrollForDateRange(startDate, endDate);
        }
        return null;
    }

    private List<EmployeePayrollData> getEmployeePayrollForDateRange(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}
	public void addEmployeesToPayroll(List<EmployeePayrollData> employeePayrollDataList) {
        employeePayrollDataList.forEach(employeePayrollData -> {
            System.out.println(employeePayrollData.name+" is adding");
            this.addEmployeeToPayroll(employeePayrollData.name, employeePayrollData.salary,
                    employeePayrollData.startDate, employeePayrollData.gender);
            System.out.println(employeePayrollData.name+" added");
        });
    }

    public Collection<? extends EmployeePayrollData> addEmployeeToPayroll(String name, double salary, LocalDate startDate, String gender) {
        employeePayrollList.addAll(employeePayrollDBService.addEmployeeToPayroll(name, salary, startDate, gender));
		return employeePayrollList;
    }
    

    public void addEmployeeToPayRollWIthThreads(List<EmployeePayrollData> employeePayrollDataList) {
        Map<Integer, Boolean> employeeAdditionStatus = new HashMap<Integer, Boolean>();
        employeePayrollDataList.forEach(employeePayrollData -> {
            Runnable task = () -> {
                employeeAdditionStatus.put(employeePayrollData.hashCode(), false);
                System.out.println("Employee Adding:" + Thread.currentThread().getName());
                this.addEmployeeToPayroll(employeePayrollData.name, employeePayrollData.salary,
                        employeePayrollData.startDate, employeePayrollData.gender);
                employeeAdditionStatus.put(employeePayrollData.hashCode(), true);
                System.out.println("Employee Added: " + Thread.currentThread().getName());
            };
            Thread thread = new Thread(task, employeePayrollData.name);
            thread.start();
        });
        while (employeeAdditionStatus.containsValue(false)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        System.out.println(employeePayrollDataList);
    }
	public Object countEnteries(IOService dbIo) {
		// TODO Auto-generated method stub
		return null;
	}

}