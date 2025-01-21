package ro.uvt.strategies;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(String paragraph) {
        System.out.println("Align Center: " + paragraph);
    }
}