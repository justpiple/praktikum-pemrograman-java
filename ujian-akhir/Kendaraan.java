
public abstract class Kendaraan {

    private String kodeKendaraan;
    private String namaKendaraan;
    private double hargaSewaPerHari;
    private boolean tersedia;

    public Kendaraan(String kodeKendaraan, String namaKendaraan, double hargaSewaPerHari) {
        this.kodeKendaraan = kodeKendaraan;
        this.namaKendaraan = namaKendaraan;
        this.hargaSewaPerHari = hargaSewaPerHari;
        this.tersedia = true;
    }

    public String getKodeKendaraan() {
        return kodeKendaraan;
    }

    public void setKodeKendaraan(String kodeKendaraan) {
        this.kodeKendaraan = kodeKendaraan;
    }

    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public void setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
    }

    public double getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }

    public void setHargaSewaPerHari(double hargaSewaPerHari) {
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public void tampilInfo() {
        System.out.printf("%-15s : %s%n", "Kode Kendaraan", kodeKendaraan);
        System.out.printf("%-15s : %s%n", "Nama Kendaraan", namaKendaraan);
        System.out.printf("%-15s : Rp%,.0f%n", "Harga/Hari", hargaSewaPerHari);
        System.out.printf("%-15s : %s%n", "Status", tersedia ? "Tersedia" : "Tidak Tersedia");
    }

    public abstract double hitungBiayaDasar(int lamaSewa);
}
