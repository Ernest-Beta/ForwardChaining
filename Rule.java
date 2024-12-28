import java.util.List;

public class Rule {
    private List<String> protaseis;
    private String symperasma; 

    public Rule(List<String> protaseis, String symperasma) {
        this.protaseis = protaseis;
        this.symperasma = symperasma;
    }

    public List<String> getPremises() {
        return protaseis;
    }

    public String getConclusion() {
        return symperasma;
    }
}
