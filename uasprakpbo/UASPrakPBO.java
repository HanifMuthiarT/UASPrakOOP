//Hanif Muthiar Tsani
//41155050220028
package uasprakpbo;

import java.util.Scanner;

public class UASPrakPBO {
    private static String url = "jdbc:mysql://localhost/uasprakpbo"; 
    private static String username = "root"; 
    private static String password = "";
    
    public static void main(String[] args) {
        Connection connection = new Connection(url, username, password);
     
        // Mengambil input pilihan
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("\nDaftar Todo List");
            System.out.println("1. Tampilkan Data");
            System.out.println("2. Tambah Data");
            System.out.println("3. Update Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih : ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // Menampilkan data dari tabel
                    System.out.println("Data Todo List");
                    connection.displayData();
                    break;
                case 2:
                    // Mengambil input data baru
                    System.out.print("Masukkan ID : ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Masukkan Todo : ");
                    String todo = scanner.nextLine();
                    System.out.print("Masukkan Kategori : ");
                    String kategori = scanner.nextLine();
                    System.out.print("Masukkan Tanggal : ");
                    String tanggal = scanner.nextLine();
                    System.out.print("Masukan Status : ");
                    String status = scanner.nextLine();

                    // Menambahkan data baru
                    
                    connection.createData(id, todo, kategori, tanggal, status);
                    System.out.println("\nData berhasil ditambahkan");
                    break;
                case 3:
                    // Mengambil input data yang akan diupdate
                    System.out.print("Masukkan ID yang ingin diupdate: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Masukkan Todo : ");
                    String newTodo = scanner.nextLine();
                    System.out.print("Masukkan Kategori : ");
                    String newKategori = scanner.nextLine();
                    System.out.print("Masukkan Tanggal : ");
                    String newTanggal = scanner.nextLine();
                    System.out.print("Masukan Status : ");
                    String newStatus = scanner.nextLine();

                    // Mengupdate data
                    
                    connection.updateData(idToUpdate, newTodo, newKategori, newTanggal, newStatus);
                    System.out.println("\nData berhasil diupdate");
                    break;
                case 4:
                    // Mengambil input data yang akan dihapus
                    System.out.print("Masukkan ID yang ingin dihapus: ");
                    int idToDelete = scanner.nextInt();

                    // Menghapus data
        
                    connection.deleteData(idToDelete);
                    System.out.println("\nData berhasil dihapus");
                    break;
                case 5:
                    System.out.println("Byee...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih ulang.");
                    break;
            }
            System.out.println();
        }
 
        scanner.close();
    }
}

