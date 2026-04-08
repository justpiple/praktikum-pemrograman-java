
public class KaryawanPartTime extends Karyawan {

    private int upahPerJam;

    public KaryawanPartTime(String nama, int upahPerJam) {
        super(nama);
        this.upahPerJam = upahPerJam;
    }

    @Override
    public int hitungGaji(int jamKerja) {
        return (this.upahPerJam * jamKerja);
    }
}
