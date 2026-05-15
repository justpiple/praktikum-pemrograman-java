
public class Matkomlan extends MataKuliah {

    public Matkomlan(double tugas, double kuis, double uts, double uas) {
        super(tugas, kuis, uts, uas);
    }

    @Override
    public double hitungNilai() {
        return (0.1 * tugas) + (0.2 * kuis) + (0.3 * uts) + (0.4 * uas);
    }
}
