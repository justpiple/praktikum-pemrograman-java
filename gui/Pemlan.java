
public class Pemlan extends MataKuliah {

    public Pemlan(double tugas, double kuis, double uts, double uas) {
        super(tugas, kuis, uts, uas);
    }

    @Override
    public double hitungNilai() {
        return (0.2 * tugas) + (0.2 * kuis) + (0.3 * uts) + (0.3 * uas);
    }
}
