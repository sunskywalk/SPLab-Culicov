package ro.uvt.info.proiect_sdm_culicov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.uvt.info.proiect_sdm_culicov.Author;
import ro.uvt.info.proiect_sdm_culicov.Book;
import ro.uvt.info.proiect_sdm_culicov.Image;
import ro.uvt.info.proiect_sdm_culicov.Paragraph;
import ro.uvt.info.proiect_sdm_culicov.Section;

@SpringBootApplication
public class ProiectSdmCulicovApplication {

    public static void main(String[] args) {
        // SpringApplication.run(ProiectSdmCulicovApplication.class, args);

        // Тестируем модель книги
        Book noapteBuna = new Book("Noapte buna, copii!");
        Author rpGheo = new Author("Radu", "Pavel Gheo");
        noapteBuna.addAuthor(rpGheo);

        Section cap1 = new Section("Capitolul 1");
        Section cap11 = new Section("Capitolul 1.1");
        Section cap111 = new Section("Subcapitolul 1.1.1");

        noapteBuna.add(new Paragraph("Multumesc celor care ..."));
        noapteBuna.add(cap1);
        cap1.add(new Paragraph("Moto capitol"));
        cap1.add(cap11);
        cap11.add(new Paragraph("Text from subchapter 1.1"));
        cap11.add(cap111);
        cap111.add(new Image("Image subchapter 1.1.1.1"));

        noapteBuna.print();
    }

}
