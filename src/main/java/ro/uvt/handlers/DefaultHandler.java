package ro.uvt.handlers;

public class DefaultHandler implements Handler {
    @Override
    public void setNext(Handler nextHandler) {
        // No next handler in the chain.
    }

    @Override
    public void handleRequest(String request) {
        System.out.println("Handler: No handler found for " + request);
    }
}