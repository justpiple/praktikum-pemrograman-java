
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            Account[] accounts = {
                new Account("312", 50_000),
                new Account("123", 25_000),};

            loop:
            while (true) {
                System.out.print("Silahkan pilih menu (topup/withdraw/cek/keluar): ");
                String action = scan.next();

                switch (action) {
                    case "topup" -> {
                        Account account = getAccountFromNumber(scan, accounts);
                        if (account == null) {
                            System.out.println("Akun tidak ditemukan.");
                        } else {
                            System.out.print("Input nominal: ");
                            int nominal = inputNumber(scan);
                            account.topUp(nominal);
                            System.out.println("Sukses melakukan topup.");
                        }
                    }
                    case "withdraw" -> {
                        Account account = getAccountFromNumber(scan, accounts);
                        if (account == null) {
                            System.out.println("Akun tidak ditemukan.");
                        } else {
                            System.out.print("Input nominal: ");
                            int nominal = inputNumber(scan);
                            try {
                                account.withdraw(nominal);
                                System.out.println("Sukses melakukan withdraw.");
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    case "cek" -> {
                        Account account = getAccountFromNumber(scan, accounts);
                        if (account == null) {
                            System.out.println("Akun tidak ditemukan.");
                        } else {
                            System.out.println("Saldo akun Anda: " + account.getSaldo());
                        }
                    }
                    case "keluar" -> {
                        System.out.println("Terima kasih.");
                        break loop;
                    }
                    default ->
                        System.out.println("Perintah tidak ditemukan.");
                }
            }

        } finally {
            System.out.println("Program selesai.");
        }
    }

    public static int inputNumber(Scanner scan) {
        int input = -1;
        while (input == -1) {
            try {
                int inputNumber = scan.nextInt();
                input = inputNumber;
            } catch (InputMismatchException e) {
                System.out.print("Input salah. Harap perhatikan isian Anda: ");
                scan.nextLine();
            }
        }

        return input;
    }

    public static Account getAccountFromNumber(Scanner scan, Account[] accounts) {
        Account account = null;

        while (account == null) {
            System.out.print("Input nomor akun: ");
            String number = scan.next();
            for (Account acc : accounts) {
                if (acc.getAccountNumber().equals(number)) {
                    account = acc;
                }
            }

            if (account != null) {
                System.out.print("Akun tidak ditemukan. ");
            }
        }

        return account;
    }
}
// Pencatatan pemasukan dan pengeluaran tabungan Bank. Tambah saldo, kurangi saldo, cek saldo, exit.
// Menggunakan try catch untuk handle input error.
