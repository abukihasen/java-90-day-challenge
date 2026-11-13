package cs.challeng.day9;

public class PayrollEngine {
    public abstract static class Employee {
        private final String id;
        private final String name;

        public Employee(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public abstract double calculatePay();
        public abstract String getType();
    }
    static class FullTimeEmployee extends Employee {
        private final double monthlySalary;

        public FullTimeEmployee(String id,String name, double monthlySalary){
            super(id,name);
            this.monthlySalary=monthlySalary;
        }

        @Override
        public double calculatePay(){
            return monthlySalary;
        }
        @Override
        public String getType(){
            return "Full Time";
        }

    }

    static class ContractEmployee extends Employee {
        private final double hourlyRate;
        private final double hoursWorked;

        public ContractEmployee(String id,String name, double hourlyRate,double hoursWorked){
            super(id,name);
            this.hourlyRate=hourlyRate;
            this.hoursWorked=hoursWorked;
        }

        @Override
        public double calculatePay(){
            return hourlyRate*hoursWorked;
        }
        @Override
        public String getType(){
            return "Contract";
        }

    }

    static void main(String[] args) {
        System.out.println("Day 9 Payroll Hierarchy Challenge");
        Employee[] employees={
                new FullTimeEmployee("emp-001","Abubekr",10000),
                new ContractEmployee("empC-001","Ahmed",100.00,25)
        };
        double totalPayroll=0;
        System.out.println("\n=====EMPLOYEE PAYROLL====");
        for (Employee emp:employees){
            double payment=emp.calculatePay();
            System.out.println("ID: "+emp.getId());
            System.out.println("Name: "+emp.getName());
            System.out.println("Type:"+emp.getType());
            System.out.println("Payment: "+payment);
            System.out.println();
            totalPayroll+=payment;
        }
        System.out.println("Total Payroll: "+totalPayroll);
    }

}




