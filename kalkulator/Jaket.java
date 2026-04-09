
public class Jaket {

    public static final int HARGA_A = 100_000;
    public static final int HARGA_B = 125_000;
    public static final int HARGA_C = 175_000;

    public static int hitungHargaA(int jumlah) {
        if (jumlah > 100) {
            return jumlah * 95_000;
        }

        return jumlah * HARGA_A;
    }

    public static int hitungHargaB(int jumlah) {
        if (jumlah > 100) {
            return jumlah * 120_000;
        }

        return jumlah * HARGA_B;
    }

    public static int hitungHargaC(int jumlah) {
        if (jumlah > 100) {
            return jumlah * 160_000;
        }

        return jumlah * HARGA_C;
    }
}
