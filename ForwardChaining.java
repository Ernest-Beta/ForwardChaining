import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ForwardChaining {

    public static void main(String[] args) {
        //dexetai san input to arxeio 
        String inputFile = "kb.txt";
        Vasignwshs kb = new Vasignwshs();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String grammh;
            while ((grammh = br.readLine()) != null) {
                grammh = grammh.trim();
                if (grammh.contains("=>")) {
                    //anagnwrizei oti an exei "=>" einai kanonas kai xwrizei ta gegonota se portaseis kai symperasmata 
                    String[] parts = grammh.split("=>");
                    String protaseispart = parts[0].trim();
                    String symperpart = parts[1].trim();

                    //xwrismos
                    List<String> protaseis = new ArrayList<>();
                    for (String protash : protaseispart.split("&")) {
                        protaseis.add(protash.trim());
                    }
                    kb.addRule(protaseis, symperpart);
                } else {
                    //to kanei add san gegonos
                    kb.addFact(grammh);
                }
            }
            //printarei ta arxika gegonota
            System.out.println("Arxika gnwsta gegonota: " + kb.getFacts());

            //dexetai to stoxo apo ton xristi
            System.out.println("Eisagete ti thelei na apodeixtei:");
            String goal = System.console().readLine().trim();

            //elegxei an mporei na apodeixtei o stoxos
            boolean result = kb.forwardchaining(goal);
            System.out.println("To " + goal + " apodeiknuetai oti einai " + result);

        } catch (IOException e) {
            System.out.println("Error reading the input file: " + e.getMessage());
        }
    }
}
