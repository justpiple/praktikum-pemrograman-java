
public class KaryawanTetap extends Karyawan {

    private int gajiPokok;
    private int uangMakan;

    public KaryawanTetap(String nama, int gajiPokok, int uangMakan) {
        super(nama);
        this.gajiPokok = gajiPokok;
        this.uangMakan = uangMakan;
    }

    @Override
    public int hitungGaji(int hariKerja) {
        return this.gajiPokok + (this.uangMakan * hariKerja);
    }

}
