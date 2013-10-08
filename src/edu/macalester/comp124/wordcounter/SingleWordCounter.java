package edu.macalester.comp124.wordcounter;

/**
 * Records counts for a particular word.
 *
 * @author Shilad Sen
 */
public class SingleWordCounter {
    private String word;
    private int count;

    /**
     * Creates a word counter for the specified word with count 0.
     * @param word
     */
    public SingleWordCounter(String word) {
        this.word = word;
        this.count = 0;
    }

    /**
     * Incrmeents the counter for the word
     */
    public void incrementCount() {
        this.count++;
    }

    /**
     * Returns true iff the "cleaned" version of the word matches.
     * @param word
     * @return
     */
    public boolean wordMatches(String word) {
        String c1 = cleanWord(this.word);
        String c2 = cleanWord(word);
        return c1.equals(c2);
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }


    /**
     * Removes excess punctuation from a word, and turns it to lower case.
     * Only used internally by the wordMatches method.
     * @param word
     * @return
     */
    private static String cleanWord(String word) {
        return word.toLowerCase().replaceAll("[^a-zA-Z0-9]+", "");
    }
}
