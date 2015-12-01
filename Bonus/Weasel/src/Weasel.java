import java.util.Random;

/**
 * Represents a weasel
 */
public class Weasel {
    private static Random random = new Random();
    public final String content;
    private static String answer = "METHINKS IT IS LIKE A WEASEL";

    /**
     * Constructs a new weasel with completely random content
     */
    public Weasel() {
        content = initialGuess("");
    }

    /**
     * Constructs a child weasel based on the given parent. Child might have some mutations
     * @param parent the weasel from which to base the new weasel
     */
    public Weasel(Weasel parent) {
        String stuff = "";
        for (int i = 0; i < parent.content.length(); i++) {
            stuff += mutateChar(parent.content.charAt(i));
        }
        content = stuff;
    }

    /**
     * Gets a number indicating how close the content is to the answer. Greater count is closer.
     * @return the count of characters from the content which match the weasel answer
     */
    public int getPurity() {
        int matchingChars = 0;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == answer.charAt(i)) {
                matchingChars++;
            }
        }
        return matchingChars;
    }

    /**
     * Applies a 20% chance that the char will mutate.
     * @param givenChar The char that might mutate
     * @return 80% chance this will just be the givenChar. 20% chance of a random char.
     */
    private char mutateChar(char givenChar) {
        boolean mutates = random.nextInt(100) < 5;
        if (mutates)
            return randomChar();
        return givenChar;
    }

    /**
     * Recursive function that builds an inital random string.
     * @param buildingString should be "".
     * @return a random string for initialization
     */
    private String initialGuess(String buildingString) {
        if (buildingString.length() == answer.length())
            return buildingString;

        char newChar = randomChar();
        return initialGuess(buildingString + newChar);
    }

    /**
     * Generates a random char from a-z and spaces.
     * @return a random char
     */
    private char randomChar() {
        int rand = random.nextInt(27);

        char a = 'A';
        return rand == 26 ? ' ' : (char) (a + rand);
    }

    /**
     * Determines if the content matches the weasel answer
     * @return true if content matches answer.
     */
    public boolean isTrueChampion() {
        return content.equals(answer);
    }
}
