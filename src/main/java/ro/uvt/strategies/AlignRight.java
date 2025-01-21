package ro.uvt.strategies;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(String paragraph) {
        System.out.println("Align Right: " + paragraph);
    }
}