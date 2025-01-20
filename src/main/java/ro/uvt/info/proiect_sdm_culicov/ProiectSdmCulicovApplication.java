package ro.uvt.info.proiect_sdm_culicov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.uvt.info.proiect_sdm_culicov.Author;
import ro.uvt.info.proiect_sdm_culicov.Book;
import ro.uvt.info.proiect_sdm_culicov.Image;
import ro.uvt.info.proiect_sdm_culicov.Paragraph;
import ro.uvt.info.proiect_sdm_culicov.Section;

public class ProiectSdmCulicovApplication {
    public static void main(String[] args) {
        // Логика первого лабораторного
        Book noapteBuna = new Book("Noapte buna, copii!");
        Author rpGheo = new Author("Radu Pavel", "Gheo");
        noapteBuna.addAuthor(rpGheo);
        Section cap1 = new Section("Capitolul 1");
        Section cap11 = new Section("Capitolul 1.1");
        Section cap111 = new Section("Subchapter 1.1.1");

        noapteBuna.addContent(new Paragraph("Multumesc celor care ..."));
        noapteBuna.addContent(cap1);
        cap1.add(new Paragraph("Moto capitol"));
        cap1.add(cap11);
        cap11.add(new Paragraph("Text from subchapter 1.1"));
        cap11.add(cap111);
        cap111.add(new Image("Image subchapter 1.1.1.1"));

        noapteBuna.print();

        // Логика второго лабораторного
        System.out.println("\nTesting paragraph alignment:");
        Paragraph p1 = new Paragraph("Paragraph 1");
        Paragraph p2 = new Paragraph("Paragraph 2");
        Paragraph p3 = new Paragraph("Paragraph 3");

        p1.setAlignStrategy(new AlignCenter());
        p2.setAlignStrategy(new AlignRight());
        p3.setAlignStrategy(new AlignLeft());

        p1.print();
        p2.print();
        p3.print();
    }
}