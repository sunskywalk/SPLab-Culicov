package ro.uvt.info.proiect_sdm_culicov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ro.uvt.commands.AddParagraphCommand;
import ro.uvt.commands.CreateSectionCommand;
import ro.uvt.difexamples.ClientComponent;
import ro.uvt.difexamples.SingletonComponent;
import ro.uvt.difexamples.TransientComponent;
import ro.uvt.executors.CommandExecutor;
import ro.uvt.handlers.AddParagraphHandler;
import ro.uvt.handlers.CreateSectionHandler;
import ro.uvt.handlers.DefaultHandler;
import ro.uvt.handlers.Handler;
import ro.uvt.models.*;
import ro.uvt.repositories.BookRepository;
import ro.uvt.repositories.AuthorRepository;
import ro.uvt.strategies.AlignCenter;
import ro.uvt.strategies.AlignLeft;
import ro.uvt.strategies.AlignRight;

@SpringBootApplication
@EntityScan(basePackages = "ro.uvt.models")
@EnableJpaRepositories(basePackages = "ro.uvt.repositories")
@ComponentScan({"ro.uvt.info.proiect_sdm_culicov", "ro.uvt.difexamples", "ro.uvt.controllers", "ro.uvt.commands", "ro.uvt.executors", "ro.uvt.filters", "ro.uvt.services", "ro.uvt.handlers", "ro.uvt.repositories", "ro.uvt.requests", "ro.uvt.subjects","ro.uvt.observers" })
public class ProiectSdmCulicovApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProiectSdmCulicovApplication.class, args);

        // Получение репозиториев
        BookRepository bookRepository = context.getBean(BookRepository.class);
        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);

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

        // Сохранение книги и автора в базу данных
        authorRepository.save(rpGheo);
        bookRepository.save(noapteBuna);

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

        // Логика третьего лабораторного: Dependency Injection
        System.out.println("\nDependency Injection Demonstration:");

        // Работа с TransientComponent
        TransientComponent transientBean1 = context.getBean(TransientComponent.class);
        transientBean1.operation();

        TransientComponent transientBean2 = context.getBean(TransientComponent.class);
        transientBean2.operation();

        // Работа с SingletonComponent
        SingletonComponent singletonBean1 = context.getBean(SingletonComponent.class);
        singletonBean1.operation();

        SingletonComponent singletonBean2 = context.getBean(SingletonComponent.class);
        singletonBean2.operation();

        // Работа с ClientComponent
        ClientComponent clientBean = context.getBean(ClientComponent.class);
        clientBean.operation();

        // Логика четвёртого лабораторного: Command Pattern
        System.out.println("\nCommand Pattern Demonstration:");
        CommandExecutor commandExecutor = context.getBean(CommandExecutor.class);
        CreateSectionCommand createSectionCommand = context.getBean(CreateSectionCommand.class);
        AddParagraphCommand addParagraphCommand = context.getBean(AddParagraphCommand.class);

        // Асинхронное выполнение
        commandExecutor.executeAsync(createSectionCommand);
        commandExecutor.executeAsync(addParagraphCommand);

        // Синхронное выполнение
        String result1 = commandExecutor.executeSync(createSectionCommand);
        String result2 = commandExecutor.executeSync(addParagraphCommand);

        System.out.println(result1);
        System.out.println(result2);

        // Логика четвёртого лабораторного: Chain of Responsibility
        System.out.println("\nChain of Responsibility Demonstration:");
        Handler createSectionHandler = new CreateSectionHandler();
        Handler addParagraphHandler = new AddParagraphHandler();
        Handler defaultHandler = new DefaultHandler();

        createSectionHandler.setNext(addParagraphHandler);
        addParagraphHandler.setNext(defaultHandler);

        createSectionHandler.handleRequest("CreateSection");
        createSectionHandler.handleRequest("AddParagraph");
        createSectionHandler.handleRequest("UnknownCommand");
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}