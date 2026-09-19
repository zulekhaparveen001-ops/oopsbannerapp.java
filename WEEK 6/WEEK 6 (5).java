class CompanyEmployee {
    String empName;
    double salary;
    
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        CompanyEmployee e1 = new CompanyEmployee("A", 50000);
        CompanyEmployee e2 = new CompanyEmployee("B", 60000);
        CompanyEmployee e3 = new CompanyEmployee("C", 55000);

        CompanyEmployee.printCompanyInfo();
    }
}