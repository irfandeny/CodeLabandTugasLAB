import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    Admin admin;
    Student student = new Student();
    public ArrayList<Student> userStudent;

    public Main() {
        this.admin = new Admin();
        userStudent = this.admin.getUserStudent();
    }
    //method menu
    public void menu(Scanner input) {
        boolean selesai = false;
        while (!selesai) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Pilihan Opsi (1-3): ");
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    masukanNim();
                    break;
                case 2:
                    admin.loginAsAdmin();
                    break;
                case 3:
                    selesai = true;
                    System.out.println("Program selesai, Exit program");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
            }
        }
    }
    //method masukannim
    public void masukanNim() {
        System.out.print("Enter your NIM : ");
        String nim = scanner.nextLine();
        cekNim(nim);
    }
    //method ceknim
    public void cekNim(String nim) {
        for (Student student : userStudent) {
            if (student.getNim().equals(nim)) {
                student.displayInfo(student);
                student.displayBook();
                menuStudent();
                return;
            }
        }
        System.out.println("NIM tidak ditemukan, silakan coba lagi");
    }
    //method menu student
    public void menuStudent() {
        Scanner input = new Scanner(System.in);
        boolean selesai = false;
        while (!selesai) {
            System.out.println("===== Student Menu =====");
            System.out.println("1. Tampilkan Buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Tampilkan Buku yang dipinjam");
            System.out.println("4. Kembalikan buku");
            System.out.println("5. Logout");
            System.out.print("Pilihan Opsi (1-5): ");
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    student.displayBook();
                    break;
                case 2:
                    student.pinjamBuku();
                    break;
                case 3:
                    student.tampilBukuTerpinjam();
                    break;
                case 4:
                    student.returnBooks();
                    break;
                case 5:
                    selesai = true;
                    student.logout();
                    System.out.println("dari student menu");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
            }
        }
    }
    //method menu admin
    public void menuAdmin() {
        Scanner input = new Scanner(System.in);
        boolean selesai = false;
        while (!selesai) {
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Tampilkan Daftar Buku");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("5. Tambah Mahasiswa");
            System.out.println("6. Log out");
            System.out.print("Pilihan Opsi (1-6): ");
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    admin.tambahBuku();
                    break;
                case 2:
                    admin.hapusBuku();
                    break;
                case 3:
                    admin.displayBook();
                    break;
                case 4:
                    admin.tampilkanDaftarMahasiswa();
                    break;
                case 5:
                    admin.addStudent();
                    break;
                case 6:
                    selesai = true;
                    System.out.println("Logging out... from admin menu");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
            }
        }
    }

    //method hapus buku

    //method utama
    public static void main(String[] args) {
        System.out.println("SELAMAT DATANG");
        Main lib = new Main();
        Scanner input = new Scanner(System.in);
        lib.menu(input);
        input.close();

    }
}