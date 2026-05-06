
public class Main {

    public static void main(String[] args) {
        Invoice inv1 = new Invoice("PS", 1, 3_000_000);
        Invoice inv2 = new Invoice("Minyak", 1, 25_000);
        Invoice inv3 = new Invoice("Gula", 3, 15_000);

        Employee emp1 = new Employee(101, "Budi", 3_500_000);
        emp1.addInvoice(inv1, inv2, inv3);

        // Contoh Polymorhp
        Payable payable = emp1;
        System.out.println("Gaji setelah potongan : " + payable.getPayableAmount());

        System.out.println();

        emp1.display();
    }
}
