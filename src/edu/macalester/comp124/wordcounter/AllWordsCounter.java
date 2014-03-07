package edu.macalester.comp124.wordcounter;

import java.util.ArrayList;
import java.util.List;

/**
 * A counter that keeps track of counts for all words
 * 
 * @author shilad
 *
 */
public class AllWordsCounter {

    public static final int MAX_WORDS = 10000;

	private List<SingleWordCounter> allWords = new ArrayList<SingleWordCounter>(MAX_WORDS);

    public int getNumWords() {
        return allWords.size();
    }
	
	/**
	 * Increment the count for the specified word.  Remember that this may
     * be the first time the word counter has seen this particular word.
	 * 
	 * @param word
	 */
	public void count(String word) {
        int n = getNumWords();
        boolean notFound = true;
        for (int i = 0; i < n; i++) {
            SingleWordCounter lookUp = allWords.get(i);
            if (lookUp.wordMatches(word)) {
                allWords.get(i).incrementCount();
                notFound = false;
            }
        }
        if (notFound) {
            SingleWordCounter newWord = new SingleWordCounter(word);
            newWord.incrementCount();
            this.allWords.add(newWord);
        }

	}
	
	/**
	 * Return the count for the particular word.  Remember that the
	 * word may not have been seen before.
	 * @param word
	 * @return
	 */
	public int getCount(String word) {
        int n = getNumWords();
        for (int i = 0; i < n; i++) {
            SingleWordCounter lookUp = allWords.get(i);
            if (lookUp.wordMatches(word)) {
                return lookUp.getCount();
            }
        }
        return 0;
	}
	
	/**
	 * @return The an array of all words that have been counted
	 * (just the words, not the values).
	 */
	public String[] getAllWords() {
        int n = getNumWords();
        String words[] = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = allWords.get(i).getWord();
        }
        return words;
	}
}
