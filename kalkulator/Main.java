
public class Main {

    public static void main(String[] args) {
        int angka1 = 20;
        int angka2 = 5;

        Kalkulator kalkulator = new Kalkulator();

        int hasilJumlah = Kalkulator.penjumlahan(angka1, angka2);
        int hasilKurang = Kalkulator.pengurangan(angka1, angka2);
        int hasilKali = kalkulator.perkalian(angka1, angka2);
        int hasilBagi = kalkulator.pembagian(angka1, angka2);

        System.out.println("Hasil Penjumlahan: " + hasilJumlah);
        System.out.println("Hasil Pengurangan: " + hasilKurang);
        System.out.println("Hasil Perkalian: " + hasilKali);
        System.out.println("Hasil Pembagian: " + hasilBagi);

        Pecahan pecahan = kalkulator.sederhana(12, 18);
        System.out.println("Hasil Sederhana Pecahan: " + pecahan.getPembilang() + "/" + pecahan.getPenyebut());

        // Jaket
        System.out.println("--- PROGRAM JAKET ---");
        int jmlA = 120;
        int jmlB = 110;
        int jmlC = 90;

        int totalA = Jaket.hitungHargaA(jmlA);
        int totalB = Jaket.hitungHargaB(jmlB);
        int totalC = Jaket.hitungHargaC(jmlC);

        int totalAll = totalA + totalB + totalC;

        System.out.printf("Total Harga Jaket A: Rp %,d\n", totalA);
        System.out.printf("Total Harga Jaket B: Rp %,d\n", totalB);
        System.out.printf("Total Harga Jaket C: Rp %,d\n", totalC);
        System.out.printf("Total Semua Harga: Rp %,d\n", totalAll);
    }
}
