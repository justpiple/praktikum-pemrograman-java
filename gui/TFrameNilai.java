
import java.awt.*;
import java.awt.event.*;

public class TFrameNilai extends Frame implements ActionListener, ItemListener {

    Label lbJudul, lbTugas, lbKuis, lbUTS, lbUAS, lbHasil;

    TextField txtTugas, txtKuis, txtUTS, txtUAS, txtHasil;

    CheckboxGroup cbg;
    Checkbox cbPemlan, cbASD, cbMatkomlan, cbProbstat;

    Button btnHitung, btnTampil;

    TextArea areaHasil;

    double nilaiPemlan = 0;
    double nilaiASD = 0;
    double nilaiMatkomlan = 0;
    double nilaiProbstat = 0;

    public TFrameNilai() {

        setLayout(null);

        lbJudul = new Label("Hitung Nilai akhir");
        lbJudul.setFont(new Font("Arial", Font.BOLD, 18));
        add(lbJudul);
        lbJudul.setBounds(140, 50, 200, 30);

        cbg = new CheckboxGroup();

        cbASD = new Checkbox("ASD", cbg, false);
        cbPemlan = new Checkbox("Pemlan", cbg, true);
        cbMatkomlan = new Checkbox("Matkomlan", cbg, false);
        cbProbstat = new Checkbox("Probstat", cbg, false);

        add(cbASD);
        add(cbPemlan);
        add(cbMatkomlan);
        add(cbProbstat);

        cbASD.setBounds(40, 100, 70, 20);
        cbPemlan.setBounds(140, 100, 80, 20);
        cbMatkomlan.setBounds(260, 100, 100, 20);
        cbProbstat.setBounds(400, 100, 100, 20);

        cbASD.addItemListener(this);
        cbPemlan.addItemListener(this);
        cbMatkomlan.addItemListener(this);
        cbProbstat.addItemListener(this);

        lbTugas = new Label("Tugas : ");
        lbKuis = new Label("Kuis : ");
        lbUTS = new Label("UTS : ");
        lbUAS = new Label("UAS : ");
        lbHasil = new Label("Hasil : ");

        add(lbTugas);
        add(lbKuis);
        add(lbUTS);
        add(lbUAS);
        add(lbHasil);

        lbTugas.setBounds(140, 150, 80, 20);
        lbKuis.setBounds(140, 190, 80, 20);
        lbUTS.setBounds(140, 230, 80, 20);
        lbUAS.setBounds(140, 270, 80, 20);
        lbHasil.setBounds(140, 310, 80, 20);

        txtTugas = new TextField();
        txtKuis = new TextField();
        txtUTS = new TextField();
        txtUAS = new TextField();
        txtHasil = new TextField();

        add(txtTugas);
        add(txtKuis);
        add(txtUTS);
        add(txtUAS);
        add(txtHasil);

        txtTugas.setBounds(240, 150, 100, 25);
        txtKuis.setBounds(240, 190, 100, 25);
        txtUTS.setBounds(240, 230, 100, 25);
        txtUAS.setBounds(240, 270, 100, 25);
        txtHasil.setBounds(240, 310, 100, 25);

        btnHitung = new Button("Hitung");
        add(btnHitung);
        btnHitung.setBounds(180, 360, 120, 30);

        btnHitung.addActionListener(this);

        areaHasil = new TextArea();
        add(areaHasil);
        areaHasil.setBounds(100, 420, 350, 150);

        btnTampil = new Button("Tampilkan nilai semua matkul");
        add(btnTampil);
        btnTampil.setBounds(120, 590, 300, 30);

        btnTampil.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        txtTugas.setText("");
        txtKuis.setText("");
        txtUTS.setText("");
        txtUAS.setText("");
        txtHasil.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnHitung) {

            double tugas = Double.parseDouble(txtTugas.getText());
            double kuis = Double.parseDouble(txtKuis.getText());
            double uts = Double.parseDouble(txtUTS.getText());
            double uas = Double.parseDouble(txtUAS.getText());

            MataKuliah mk = null;

            if (cbPemlan.getState()) {
                mk = new Pemlan(tugas, kuis, uts, uas);
                nilaiPemlan = mk.hitungNilai();
                txtHasil.setText(String.valueOf(nilaiPemlan));
            } else if (cbASD.getState()) {
                mk = new ASD(tugas, kuis, uts, uas);
                nilaiASD = mk.hitungNilai();
                txtHasil.setText(String.valueOf(nilaiASD));
            } else if (cbMatkomlan.getState()) {
                mk = new Matkomlan(tugas, kuis, uts, uas);
                nilaiMatkomlan = mk.hitungNilai();
                txtHasil.setText(String.valueOf(nilaiMatkomlan));
            } else if (cbProbstat.getState()) {
                mk = new Probstat(tugas, kuis, uts, uas);
                nilaiProbstat = mk.hitungNilai();
                txtHasil.setText(String.valueOf(nilaiProbstat));
            }
        }

        if (e.getSource() == btnTampil) {
            areaHasil.setText(
                    """
                    HASIL NILAI SEMUA MATKU
                    Pemlan : """ + nilaiPemlan + "\n"
                    + "ASD : " + nilaiASD + "\n"
                    + "Matkomlan : " + nilaiMatkomlan + "\n"
                    + "Probstat : " + nilaiProbstat
            );
        }
    }
}
