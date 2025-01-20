package ro.uvt.info.proiect_sdm_culicov;

public class Paragraph implements Element {
    private final String text;
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        this.text = text;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    @Override
    public void print() {
        if (alignStrategy != null) {
            alignStrategy.render(text);
        } else {
            System.out.println(String.format("Paragraph: %s", text));
        }
    }
}