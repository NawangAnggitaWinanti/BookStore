package id.co.indivara.jdt12.bookstore.controller;

import id.co.indivara.jdt12.bookstore.entity.Book;
import id.co.indivara.jdt12.bookstore.entity.BukuMahal;
import id.co.indivara.jdt12.bookstore.entity.BukuMurah;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BookController {
    //    @GetMapping("/book")
//    public Book bookGet(
//            @RequestParam(value="kodbuk",defaultValue = "0") String isbn,
//            @RequestParam(value="judbuk",defaultValue = "Merupakan Judul Bukunya") String judul,
//            @RequestParam(value ="penulis",defaultValue = "Merupakan Pengarang Bukunya") String pengarang){
//            return new Book(isbn, "Halloo Judul Buku Pada Method Get Ini adalah "+judul, pengarang);
//            }
//
//    @PostMapping("/book")
//    public Book bookPost(
//            @RequestParam(value="kodbuk",defaultValue = "0") String isbn,
//            @RequestParam(value="judbuk",defaultValue = "Merupakan Judul Bukunya") String judul,
//            @RequestParam(value ="penulis",defaultValue = "Merupakan Pengarang Bukunya") String pengarang){
//        return new Book(isbn, "Halloo Judul Buku Pada Method Post Ini adalah "+judul, pengarang);
//    }
//    @PutMapping("/book")
//    public Book bookPut(
//            @RequestParam(value="kodbuk",defaultValue = "0") String isbn,
//            @RequestParam(value="judbuk",defaultValue = "Merupakan Judul Bukunya") String judul,
//            @RequestParam(value ="penulis",defaultValue = "Merupakan Pengarang Bukunya") String pengarang){
//        return new Book(isbn, "Halloo Judul Buku Pada Method Put Ini adalah "+judul, pengarang);
//    }
//    @PatchMapping("/book")
//    public Book bookPatch(
//            @RequestParam(value="kodbuk",defaultValue = "0") String isbn,
//            @RequestParam(value="judbuk",defaultValue = "Merupakan Judul Bukunya") String judul,
//            @RequestParam(value ="penulis",defaultValue = "Merupakan Pengarang Bukunya") String pengarang){
//        return new Book(isbn, "Halloo Judul Buku Pada Method Patch Ini adalah " + judul, pengarang);
//    }
//    @DeleteMapping("/book")
//    public Book bookDelete(
//            @RequestParam(value="kodbuk",defaultValue = "0") String isbn,
//            @RequestParam(value="judbuk",defaultValue = "Merupakan Judul Bukunya") String judul,
//            @RequestParam(value ="penulis",defaultValue = "Merupakan Pengarang Bukunya") String pengarang){
//        return new Book(isbn, "Halloo Judul Buku Pada Method Delete Ini adalah " + judul, pengarang);
//    }
    @GetMapping("/book/{isbn}/{judul}/{pengarang}")//hanya digunakan pada method get
    public Book tampilkanBuku(
            @PathVariable("isbn") String isbn,
            @PathVariable("judul") String judul,
            @PathVariable("pengarang") String pengarang) {
        return new Book(isbn, judul, pengarang);
    }

    @PostMapping("/simpan")
    public Book simpanBuku(@RequestBody Book jsonData) {
        Book b = jsonData;
        b.setPengarang(b.getPengarang() + " Ini Dari JSON loohh....");
        return b;
    }

    @PostMapping("/save")
    public BukuMahal saveBuku(@RequestBody Book jsonData) {
        Book b = jsonData;
        BukuMahal bm = new BukuMahal();
        bm.setIsbn(b.getIsbn());
        bm.setJudul(b.getJudul());
        bm.setPengarang(b.getPengarang());
        bm.setKemasan("Kotak Kayu");
        bm.setCover("besi");
        return bm;
    }

    @GetMapping("/all")
    public ArrayList<Book> findAllBook() {
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("1111", "Cara Makan", "Nawang"));
        list.add(new Book("2222", "Cara Bernafas", "Anggita"));
        list.add(new Book("3333", "Cara Minum", "Winanti"));
        return list;
    }

    @PostMapping("/termahal")
    public BukuMurah findBukuTermahal(@RequestBody ArrayList<BukuMurah> list) {
        BukuMurah buku = list.get(1);//ambil element pertama yang akan kita bandingkan
        for (BukuMurah b : list) {
            if (b.getHarga() < buku.getHarga()) {
                buku = b;
            }
        }
        return buku;
    }
}
