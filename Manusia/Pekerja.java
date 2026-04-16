
import java.time.LocalDate;

public class Pekerja extends Manusia {

    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public Pekerja(String nama, boolean jenisKelamin, String nik, boolean menikah,
            double gaji, LocalDate tahunMasuk, int jumlahAnak) {
        super(nama, jenisKelamin, nik, menikah);
        this.gaji = gaji;
        this.tahunMasuk = tahunMasuk;
        this.jumlahAnak = jumlahAnak;
    }

    public double getGajiPokok() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public LocalDate getTahunMasuk() {
        return tahunMasuk;
    }

    public void setTahunMasuk(LocalDate tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    public int getJumlahAnak() {
        return jumlahAnak;
    }

    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public double getBonus() {
        int lamaKerja = LocalDate.now().getYear() - tahunMasuk.getYear();

        if (lamaKerja >= 0 && lamaKerja < 5) {
            return 0.05 * gaji;
        } else if (lamaKerja >= 5 && lamaKerja < 10) {
            return 0.1 * gaji;
        } else {
            return 0.15 * gaji;
        }
    }

    public double getGaji() {
        return gaji + getBonus();
    }

    @Override
    public double getPendapatan() {
        return super.getPendapatan() + getGaji() + (jumlahAnak * 20);
    }

    @Override
    public String toString() {
        return super.toString()
                + "\ntahun masuk : " + tahunMasuk
                + "\njumlah anak : " + jumlahAnak
                + "\ngaji : $" + getGaji();
    }
}
