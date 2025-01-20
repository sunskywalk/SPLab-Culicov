package ro.uvt.info.proiect_sdm_culicov;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(String paragraph) {
        System.out.println("Align Right: " + paragraph);
    }
}