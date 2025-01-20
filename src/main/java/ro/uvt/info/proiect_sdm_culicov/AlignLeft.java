package ro.uvt.info.proiect_sdm_culicov;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(String paragraph) {
        System.out.println("Align Left: " + paragraph);
    }
}