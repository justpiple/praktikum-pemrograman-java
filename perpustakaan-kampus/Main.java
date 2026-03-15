
public class Main {

    public static void main(String[] args) {

        Perpustakaan perpus = new Perpustakaan("Perpustakaan Pusat UB");

        Kategori teknologi = new Kategori("Teknologi", "Buku seputar perkembangan teknologi dan ilmu komputer");

        Buku t1 = new Buku("The Year in Tech, 2025", 2024, "9781633695243");
        t1.tambahPenulis(new Penulis("Tim editor HBR", "Amerika Serikat"));

        Buku t2 = new Buku("Artificial Intelligence: A Guide for Thinking Humans", 2019, "9780374257835");
        t2.tambahPenulis(new Penulis("Melanie Mitchell", "Amerika Serikat"));

        Buku t3 = new Buku("Life 3.0: Being Human in the Age of Artificial Intelligence", 2017,
                "9781101946596");
        t3.tambahPenulis(new Penulis("Max Tegmark", "Swedia/AS"));

        Buku t4 = new Buku("AI 2041: Ten Visions for Our Future", 2021, "9780593238295");
        t4.tambahPenulis(new Penulis("Kai-Fu Lee", "Taiwan/AS"));
        t4.tambahPenulis(new Penulis("Chen Qiufan", "Tiongkok"));

        Buku t5 = new Buku("Code (Updated): The Hidden Language of Computer Hardware and Software", 2022, "9780137909100");
        t5.tambahPenulis(new Penulis("Charles Petzold", "Amerika Serikat"));

        teknologi.tambahBuku(t1, t2, t3, t4, t5);
        perpus.tambahKategori(teknologi);

        System.out.println("=== Percobaan ===");
        System.out.println("Jumlah kata sinopsis t1: " + t1.hitungJumlahKataSinopsis());
        System.out.println("Jumlah kata sinopsis t2: " + t2.hitungJumlahKataSinopsis());
        System.out.println("Kesamaan t1 vs t2: " + t1.cekTingkatKesamaan(t2) + "%");
        Buku t2Copy = t2.copy();
        System.out.println("Kesamaan t2 vs copy(t2): " + t2.cekTingkatKesamaan(t2Copy) + "%");
        System.out.println();

        Kategori filsafat = new Kategori("Filsafat", "Buku seputar filsafat, pemikiran, dan dasar-dasar ilmu");

        Buku f1 = new Buku("Filosofi Teras: Filsafat Yunani-Romawi Kuno untuk Mental Tangguh Masa Kini", 2018,
                "978-623-346-931-9");
        f1.tambahPenulis(new Penulis("Henry Manampiring", "Indonesia"));

        Buku f2 = new Buku("Filsafat Ilmu: Sebuah Pengantar Populer", 2010, "978-979-416-899-8");
        f2.tambahPenulis(new Penulis("Jujun S. Suriasumantri", "Indonesia"));

        Buku f3 = new Buku("Buku Ajar Filsafat Ilmu", 2020, "978-623-02-0901-7");
        f3.tambahPenulis(new Penulis("Agus Thoha", "Indonesia"));

        Buku f4 = new Buku("Filsafat di Indonesia: Manusia dan Budaya", 2010, "9786029012150");
        f4.tambahPenulis(new Penulis("Hengky Alexander Mangkulo", "Indonesia"));

        Buku f5 = new Buku("Sophie's World: A Novel About the History of Philosophy", 2010, "9781857992915");
        f5.tambahPenulis(new Penulis("Jostein Gaarder", "Norwegia"));

        filsafat.tambahBuku(f1, f2, f3, f4, f5);
        perpus.tambahKategori(filsafat);

        Kategori sejarah = new Kategori("Sejarah",
                "Buku seputar sejarah Indonesia dan sejarah peradaban dunia");

        Buku s1 = new Buku("Sejarah Indonesia: Dinamika Bangsa dalam Arus Global (10 jilid)", 2025,
                "ISBN berbeda per jilid");
        s1.tambahPenulis(new Penulis("123 sejarawan dari 34 universitas", "Indonesia"));

        Buku s2 = new Buku("Melihat Indonesia dari Mata Pemuda", 2023, "ISBN ada di katalog Deepublish");
        s2.tambahPenulis(new Penulis("Nur Khafi Udin Pancar Setiabudi Ilham Mukarromah", "Indonesia"));

        Buku s3 = new Buku("Perjuangan Mempertahankan Kemerdekaan Indonesia", 2017,
                "ISBN ada di katalog Deepublish");
        s3.tambahPenulis(new Penulis("Koesmi Hartiyah", "Indonesia"));

        Buku s4 = new Buku("Sapiens: A Brief History of Humankind", 2014, "9780099590088");
        s4.tambahPenulis(new Penulis("Yuval Noah Harari", "Israel"));

        Buku s5 = new Buku("Guns, Germs, and Steel: The Fates of Human Societies", 2010, "9780393317558");
        s5.tambahPenulis(new Penulis("Jared Diamond", "Amerika Serikat"));

        sejarah.tambahBuku(s1, s2, s3, s4, s5);
        perpus.tambahKategori(sejarah);

        Kategori agama = new Kategori("Agama", "Buku seputar agama, spiritualitas, dan pencarian makna hidup");

        Buku a1 = new Buku("Muhammad: Lelaki Penggenggam Hujan", 2011, "9786028811310");
        a1.tambahPenulis(new Penulis("Tasaro GK", "Indonesia"));

        Buku a2 = new Buku("Man's Search for Meaning", 2010, "9780807014295");
        a2.tambahPenulis(new Penulis("Viktor E. Frankl", "Austria"));

        Buku a3 = new Buku("The Purpose Driven Life", 2012, "9780310337508");
        a3.tambahPenulis(new Penulis("Rick Warren", "Amerika Serikat"));

        Buku a4 = new Buku("Islam: A Short History", 2010, "9780812966183");
        a4.tambahPenulis(new Penulis("Karen Armstrong", "Inggris"));

        Buku a5 = new Buku("Sejarah Tuhan (A History of God)", 2010, "9780345384560");
        a5.tambahPenulis(new Penulis("Karen Armstrong", "Inggris"));

        agama.tambahBuku(a1, a2, a3, a4, a5);
        perpus.tambahKategori(agama);

        Kategori psikologi = new Kategori("Psikologi",
                "Buku seputar psikologi, kesehatan mental, dan pengembangan diri");

        Buku p1 = new Buku(
                "Pulih dari Trauma: Berkenalan dengan Trauma dan Proses Penyembuhan yang Penuh Harapan",
                2025, "ISBN tercantum di katalog Gramedia");
        p1.tambahPenulis(new Penulis("dr. Jiemi Ardian, Sp.KJ", "Indonesia"));

        Buku p2 = new Buku("Mindset: The New Psychology of Success", 2006, "9780345472328");
        p2.tambahPenulis(new Penulis("Carol S. Dweck", "Amerika Serikat"));

        Buku p3 = new Buku("Emotional Intelligence: Why It Can Matter More Than IQ", 1995, "9780553383713");
        p3.tambahPenulis(new Penulis("Daniel Goleman", "Amerika Serikat"));

        Buku p4 = new Buku("How to be Alone and Not Feel Lonely: Seni Berdamai dengan Rasa Sepi", 2024,
                "978-602-955-282-9");
        p4.tambahPenulis(new Penulis("Tristanti Wahyuni", "Indonesia"));

        psikologi.tambahBuku(p1, p2, p3, p4);
        perpus.tambahKategori(psikologi);

        Kategori politik = new Kategori("Politik",
                "Buku seputar politik, demokrasi, hukum, dan tata kelola pemerintahan");

        Buku po1 = new Buku("Literasi Politik dan Konsolidasi Demokrasi di Indonesia", 2024,
                "ISBN tercantum di katalog UIN");
        po1.tambahPenulis(new Penulis("Heryanto", "Indonesia"));

        Buku po2 = new Buku("Demokrasi dan Tata Kelola Pemilu di Indonesia", 2018, "978-602-280-008-8");
        po2.tambahPenulis(new Penulis("Munir Subarman", "Indonesia"));

        Buku po3 = new Buku("Politik Hukum di Indonesia", 2018, "978-602-6215-65-9");
        po3.tambahPenulis(new Penulis("Hanafi Amrani", "Indonesia"));

        Buku po4 = new Buku("Hukum dan Politik di Era Otonomi Daerah", 2019, "978-623-209-988-3");
        po4.tambahPenulis(new Penulis("Agus Anjar", "Indonesia"));

        Buku po5 = new Buku("Ekonomi Politik Pembangunan Daerah", 2020, "978-623-02-1343-4");
        po5.tambahPenulis(new Penulis("Imron Wasi", "Indonesia"));

        politik.tambahBuku(po1, po2, po3, po4, po5);
        perpus.tambahKategori(politik);

        Kategori fiksi = new Kategori("Fiksi",
                "Buku novel dan karya sastra fiksi dari penulis Indonesia dan luar negeri");

        Buku fk1 = new Buku("Marmut Merah Jambu (Edisi Revisi)", 2017, "978-602-220-232-5");
        fk1.tambahPenulis(new Penulis("Raditya Dika", "Indonesia"));

        Buku fk2 = new Buku("Kambing Jantan: Sebuah Catatan Pelajar Bodoh", 2005, "978-979-3600-69-7");
        fk2.tambahPenulis(new Penulis("Raditya Dika", "Indonesia"));

        Buku fk3 = new Buku("Lelaki Harimau", 2014, "9786020310268");
        fk3.tambahPenulis(new Penulis("Eka Kurniawan", "Indonesia"));

        Buku fk4 = new Buku("Negeri di Ujung Tanduk", 2013, "9789797806439");
        fk4.tambahPenulis(new Penulis("Tere Liye", "Indonesia"));

        Buku fk5 = new Buku("The Compass: Filosofi Arete untuk Bahagia Sejati", 2023, "978-623-493-263-8");
        fk5.tambahPenulis(new Penulis("Henry Manampiring", "Indonesia"));

        fiksi.tambahBuku(fk1, fk2, fk3, fk4, fk5);
        perpus.tambahKategori(fiksi);

        perpus.tampilInfo();
    }
}
