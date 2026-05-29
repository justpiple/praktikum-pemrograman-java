
public class Mobil extends Kendaraan {

    private int jumlahKursi;

    public Mobil(String kodeKendaraan, String namaKendaraan, double hargaSewaPerHari, int jumlahKursi) {
        super(kodeKendaraan, namaKendaraan, hargaSewaPerHari);
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.printf("%-15s : %s%n", "Jumlah Kursi", jumlahKursi);
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {
        double total = lamaSewa * getHargaSewaPerHari();

        if (jumlahKursi > 5) {
            total += 50000;
        }

        return total;
    }
}
