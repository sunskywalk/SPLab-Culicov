package ro.uvt.observers;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.models.Book;

public class SseObserver implements Observer {
    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void update(Book book) {
        try {
            emitter.send(book);
        } catch (Exception e) {
            emitter.completeWithError(e);
        }
    }
}