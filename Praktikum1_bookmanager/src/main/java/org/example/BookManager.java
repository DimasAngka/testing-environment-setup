package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookManager {
    private final List<org.example.Book> buku;

    public BookManager() {
        this.buku = new ArrayList<>();
    }

    public void addBook(org.example.Book buku) {
        if (buku == null) {
            throw new IllegalArgumentException("Buku tidak boleh kosong");
        }
        this.buku.add(buku);
    }

    public boolean removeBook(String judul) {
        if (judul == null || judul.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul tidak boleh kosong");
        }
        return buku.removeIf(buku ->
                buku.getJudul_buku().equalsIgnoreCase(judul.trim()));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(buku);
    }

    public List<Book> findBooksByAuthor(String penulis) {
        if (penulis == null || penulis.trim().isEmpty()) {
            throw new IllegalArgumentException("Penulis tidak boleh kosong");
        }
        return buku.stream()
                .filter(buku -> buku.getPenulis().equalsIgnoreCase(penulis.trim()))
                .collect(Collectors.toList());
    }

    public int findBooksByYear(int buku) {
        if (buku < 0 || buku > 2100) {
            throw new IllegalArgumentException("Tahun hanya bisa diisi dari tahun 2000 sampai 2100");
        }
        return buku;
    }

    public int getBookCount() {
        return buku.size();
    }

    public boolean containsBook(String judul) {
        if (judul == null || judul.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul tidak boleh kosong");
        }
        return buku.stream()
                .anyMatch(buku -> buku.getJudul_buku().equalsIgnoreCase(judul.trim()));
    }

    public void clearAllBooks() {
        buku.clear();
    }
}