package ro.uvt.strategies;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(String paragraph) {
        System.out.println("Align Left: " + paragraph);
    }
}