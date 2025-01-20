package ro.uvt.handlers;

public class CreateSectionHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equalsIgnoreCase("CreateSection")) {
            System.out.println("Handler: Creating a new Section.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}