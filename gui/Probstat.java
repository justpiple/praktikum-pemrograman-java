
public class Probstat extends MataKuliah {

    public Probstat(double tugas, double kuis, double uts, double uas) {
        super(tugas, kuis, uts, uas);
    }

    @Override
    public double hitungNilai() {
        return (0.25 * tugas) + (0.25 * kuis) + (0.25 * uts) + (0.25 * uas);
    }
}
