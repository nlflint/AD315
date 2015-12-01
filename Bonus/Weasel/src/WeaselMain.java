import java.util.ArrayList;

/**
 * Main class that composes the application
 */
public class WeaselMain {

    /**
     * Staring point.
     * @param args not used
     */
    public static void main(String[] args) {
        // The initial animal
        Weasel champion = new Weasel();

        // Track generations
        int generation = 0;

        do {
            // Make contenders from our initial chapion
            ArrayList<Weasel> contenders = generateContendersFrom(champion);

            // Grab the best contender
            champion = getNewChampion(contenders);

            // this this is the next generation
            generation++;

            // Print generation and the content of the next champion
            System.out.println(generation + " : " + champion.content);

            // Continue until we reach the weasel string
        } while (!champion.isTrueChampion());
    }

    /**
     * Gets a contender from the given list of the contenders. It grabs the contender that
     * is most pure. That is, closest to the target weasel string.
     * @param contenders list of contenders to become next champion
     * @return The most pure contender.
     */
    private static Weasel getNewChampion(ArrayList<Weasel> contenders) {
        Weasel newChampion = contenders.get(0);
        for (int i = 1; i < contenders.size(); i++) {
            Weasel contender = contenders.get(i);
            if (contender.getPurity() > newChampion.getPurity())
                newChampion = contender;

        }
        return newChampion;
    }

    /**
     * Generates 100 offspring with random mutations from the given champion
     * @param champion the parent from which the offspring are based.
     * @return 100 children with random mutations
     */
    private static ArrayList<Weasel> generateContendersFrom(Weasel champion) {
        ArrayList<Weasel> contenders = new ArrayList<Weasel>();
        for (int i = 1; i < 100; i++) {
            contenders.add(new Weasel(champion));
        }
        return contenders;
    }
}

