import java.util.ArrayList;
import java.util.Arrays;

public class Automata {

    private int curStat = 0;
    private int curStatTape = 0;

    //Legenda:
    //{-1|0|1, 0..n, 0|1} - Napisz: Nic nie pisz|0|1 Idź do: qn Przesuń taśme o 0|1 w Lewo

    private int[][][] statusTab = new int[][][]{
            {{1, 1, 1}, {0, 3, 1}, {-1,0,1}},
            {{1, 2, 0}, {0, 1, 1}, {1, 2, 1}},
            {{-1, 2, 0}, {-1, 2, 0}, {-1, 2, 0}},
            {{1, 4, 1}, {1, 4, 1}, {0, 4, 1}},
            {{1, 2, 0}, {0, 4, 1}, {1, 2, 0}},
    };

    ArrayList<Integer> tape;


    Automata(ArrayList<Integer> tape) {
        this.tape = tape;

    }

    private int getCurStat() {
        return curStat;
    }

    private void setCurStat(int currentStatus) {
        this.curStat = currentStatus;
    }

    private int getCurStatTape() {
        return curStatTape;
    }

    private void setCurStatTape(int currentStatus) {
        this.curStatTape += currentStatus;
    }

    private int getTape() {
        try {
            return tape.get(getCurStatTape());
        }catch (IndexOutOfBoundsException e){
            this.tape.add(2);
            return tape.get(getCurStatTape());
        }
    }

    private void setTape(int toWrite) {
        try {
            this.tape.set(getCurStatTape(), toWrite);
        }catch (IndexOutOfBoundsException e){
            this.tape.add(toWrite);
        }
    }

    private int[][] getStatusTab() {
        return statusTab[getCurStat()];
    }


    void start(){
        do{
            printDiag();

            int[] currentTab = getStatusTab()[getTape()];

            setTape(currentTab[0]);

            setCurStat(currentTab[1]);

            setCurStatTape(currentTab[2]);


        }while(getCurStat() != 2);

        printDiag();
    }

    private void printDiag(){
        System.out.println(getCurStat() + "\t" + getCurStatTape() + "\t" + tape.toString());
    }

    String checkEnd() {
        if (curStat == 2) {
            return "Dodano 3 do podanej wartości";
        }
        return "Błędna liczba wejściowa";
    }

}
