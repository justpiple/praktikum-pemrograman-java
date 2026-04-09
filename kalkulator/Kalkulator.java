
public class Kalkulator {

    public static int penjumlahan(int angka1, int angka2) {
        return angka1 + angka2;
    }

    public static int pengurangan(int angka1, int angka2) {
        return angka1 - angka2;
    }

    public int perkalian(int angka1, int angka2) {
        return angka1 * angka2;
    }

    public int pembagian(int angka1, int angka2) {
        return angka1 / angka2;
    }

    public Pecahan sederhana(int pembilang, int penyebut) {
        int fpb = this.cariFpb(pembilang, penyebut);

        return new Pecahan(pembilang / fpb, penyebut / fpb);
    }

    private int cariFpb(int angka1, int angka2) {
        while (angka2 != 0) {
            int sisa = angka1 % angka2;
            angka1 = angka2;
            angka2 = sisa;
        }

        return angka1;
    }
}
