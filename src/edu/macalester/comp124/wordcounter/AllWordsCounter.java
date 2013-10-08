package edu.macalester.comp124.wordcounter;

import java.util.Set;

/**
 * A counter that keeps track of counts for all words
 * 
 * @author shilad
 *
 */
public class AllWordsCounter {

    public static final int MAX_WORDS = 10000;

	// TODO: initialize instance variable to hold MAX_WORDS objects
    SingleWordCounter counters[] = new SingleWordCounter[MAX_WORDS];

    public int getNumWords() {
        // Counts the number of non-null words in the array
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] == null) {
                return i;
            }
        }
        return counters.length;
    }
	
	/**
	 * Increment the count for the specified word.  Remember that this may
     * be the first time the word counter has seen this particular word.
	 * 
	 * @param word
	 */
	public void count(String word) {
        int n = getNumWords();
        for (int i = 0; i < n; i++) {
            if (counters[i].wordMatches(word)) {
                counters[i].incrementCount();
                return;
            }
        }
        counters[n] = new SingleWordCounter(word);
        counters[n].incrementCount();
	}
	
	/**
	 * Return the count for the particular word.  Remember that the
	 * word may not have been seen before.
	 * @param word
	 * @return
	 */
	public int getCount(String word) {
        // TODO: pattern this after the count() function.
        int n = getNumWords();
        for (int i = 0; i < n; i++) {
            if (counters[i].wordMatches(word)) {
                return counters[i].getCount();
            }
        }
        return 0;
	}
	
	/**
	 * @return The an array of all words that have been counted
	 * (just the words, not the values).
	 */
	public String []  getAllWords() {
        // part two: create an array of strings of size equal to the number of words

        // part three: fill the array of strings
        int n = getNumWords();
        String words[] = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = counters[i].getWord();
        }
        return words;
//        return null;    // TODO: FIXME
	}
}
