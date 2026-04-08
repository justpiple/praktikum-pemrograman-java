
public abstract class Karyawan {

    protected String nama;

    public Karyawan(String nama) {
        this.nama = nama;
    }

    public abstract int hitungGaji(int jamOrHari);

    public String getNama() {
        return this.nama;
    }
}
