
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Employee implements Payable {

    int registrationNumber;
    String name;
    int salaryPerMonth;
    List<Invoice> invoices = new ArrayList<>();

    public Employee(int registrationNumber, String name, int salaryPerMonth) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
    }

    public void addInvoice(Invoice... invoices) {
        this.invoices.addAll(Arrays.asList(invoices));
    }

    public int getTotalInvoice() {
        int total = 0;

        for (Invoice invoice : invoices) {
            total += invoice.getPayableAmount();
        }

        return total;
    }

    @Override
    public int getPayableAmount() {
        return salaryPerMonth - getTotalInvoice();
    }

    public void display() {
        System.out.println("=== DATA KARYAWAN ===");
        System.out.println("No Registrasi : " + registrationNumber);
        System.out.println("Nama          : " + name);
        System.out.println("Gaji/Bulan    : " + salaryPerMonth);

        System.out.println("\n=== DETAIL BELANJA ===");
        for (Invoice invoice : invoices) {
            invoice.display();
            System.out.println();
        }

        System.out.println("Total Hutang  : " + getTotalInvoice());
        System.out.println("Gaji Bersih   : " + getPayableAmount());
    }
}
