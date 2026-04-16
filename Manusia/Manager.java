
import java.time.LocalDate;

public class Manager extends Pekerja {

    private String departemen;

    public Manager(String nama, boolean jenisKelamin, String nik, boolean menikah,
            double gaji, LocalDate tahunMasuk, int jumlahAnak, String departemen) {
        super(nama, jenisKelamin, nik, menikah, gaji, tahunMasuk, jumlahAnak);
        this.departemen = departemen;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    @Override
    public double getPendapatan() {
        return super.getPendapatan() + (0.1 * getGajiPokok());
    }

    @Override
    public String toString() {
        return super.toString()
                + "\ndepartemen : " + departemen;
    }
}
