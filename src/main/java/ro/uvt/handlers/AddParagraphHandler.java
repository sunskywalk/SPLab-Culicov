package ro.uvt.handlers;

public class AddParagraphHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equalsIgnoreCase("AddParagraph")) {
            System.out.println("Handler: Adding a new Paragraph.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}