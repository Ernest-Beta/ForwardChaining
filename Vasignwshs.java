import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class Vasignwshs {
    //gegonota
    private Set<String> gegon; 
    //kanones
    private List<Rule> kanon;

    public Vasignwshs() {
        this.gegon = new HashSet<>();
        this.kanon = new ArrayList<>();
    }

    //prosthetei ena fact sto knowledge base 
    public void addFact(String fact) {
        gegon.add(fact);

    }

    //prosthetei enan kanona sto knowledge base
    public void addRule(List<String> proup, String conclusion) {
        kanon.add(new Rule(proup, conclusion));
    }

    //o algoritmos tis foward chaining
    public boolean forwardchaining(String goal) {
        //elegxei an auto pou anazhteitai yoparxei hdh sto set me ta gegonota mas
        if (gegon.contains(goal)) {
            return true;
        }

        Set<String> newFacts = new HashSet<>(gegon);
        boolean newFactAdded;

        do {
            newFactAdded = false;

            //kanei parse tous kanones kai tous efarmozei an einai gnwstes oles oi protaseis kai prosthetei sto newFacts to apotelesma gia na sunexistei h diadikasia
            //an den uparxei allo stamataei h diadikasia kai etsi pragmatopiei ton teleutaio elegxo
            for (Rule kanonas : kanon) {
                if (newFacts.containsAll(kanonas.getPremises()) && !newFacts.contains(kanonas.getConclusion())) {
                    newFacts.add(kanonas.getConclusion());
                    System.out.println("Neo gegonos prostethike: " + kanonas.getConclusion());
                    newFactAdded = true;
                }
            }

        } while (newFactAdded);

        //an telika auto pou psaxnoume einai sto teliko set me ola ta geonota pou mporoume na gnwrizoume oti einai true tote einai true 
        return newFacts.contains(goal);
    }
    public Set<String> getFacts() {
        return new HashSet<>(gegon);
    }
}
