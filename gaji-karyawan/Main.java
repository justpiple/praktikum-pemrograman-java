
public class Main {

    public static void main(String[] args) {
        Karyawan[] karyawans = {
            new KaryawanTetap("Kusidra", 3_700_000, 30_000),
            new KaryawanPartTime("Aji", 25_000)
        };

        for (Karyawan karyawan : karyawans) {
            String nama = karyawan.getNama();
            int gaji = karyawan.hitungGaji(21);

            System.out.printf("Gaji %s Adalah: %,d\n", nama, gaji);
        }
    }
}
