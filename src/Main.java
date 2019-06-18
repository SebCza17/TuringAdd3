import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");


        ArrayList<Integer> inputTape = new ArrayList<Integer>(Arrays.asList(0, 1, 1));
        System.out.println(inputTape.toString());

        Automata automata = new Automata(inputTape);


        automata.start();

        System.out.println(automata.checkEnd());

    }
}
