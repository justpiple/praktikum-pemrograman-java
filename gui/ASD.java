
public class ASD extends MataKuliah {

    public ASD(double tugas, double kuis, double uts, double uas) {
        super(tugas, kuis, uts, uas);
    }

    @Override
    public double hitungNilai() {
        return (0.3 * tugas) + (0.2 * kuis) + (0.2 * uts) + (0.3 * uas);
    }
}
