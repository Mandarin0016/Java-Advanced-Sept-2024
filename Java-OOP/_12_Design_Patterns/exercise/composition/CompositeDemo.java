package composition;

public class CompositeDemo {
    public static void main(String args[]) {
        Department salesDepartment = new SalesDepartment(
        1, "Sales department");
        Department financialDepartment = new FinancialDepartment(
        2, "Financial department");

        HeadDepartment headDepartment = new HeadDepartment(
        3, "Head department");

        headDepartment.addDepartment(salesDepartment);
        headDepartment.addDepartment(financialDepartment);

        headDepartment.printDepartmentName();
    }
}