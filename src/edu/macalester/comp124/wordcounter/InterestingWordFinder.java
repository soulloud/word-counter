package edu.macalester.comp124.wordcounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Interesting word finder.
 * To use this class, first call countWords(), then call findInterestingWords.
 * 
 * Your tasks are:
 * 1. Complete the countWordsInOneFile method (you only need to add three lines of code).
 * 2. Complete the findInterestingWordsOneWay method (this should be done in 3 stages).
 * 
 * @author shilad
 *
 */
public class InterestingWordFinder {
	// Word counts from each file.
	private AllWordsCounter primaryCounts;
	private AllWordsCounter secondaryCounts;
	
	/**
	 * Constructs a new word counter.
	 */
	public InterestingWordFinder() {
        primaryCounts = new AllWordsCounter();
        secondaryCounts = new AllWordsCounter();
	}
	
	/**
	 * Counts the words in two files.
	 * @param primaryFile
	 * @param secondaryFile
	 * @throws java.io.IOException
	 */
	public void countWords(File primaryFile, File secondaryFile) throws IOException {
		countWordsInOneFile(primaryFile, primaryCounts);
		countWordsInOneFile(secondaryFile, secondaryCounts);
	}

	/**
	 * Counts the words in a single file.  The counts should be tallied
	 * in the passed-in counts object.
	 *
	 * @param file1
	 * @param counter
	 * @throws java.io.IOException
	 */
	private void countWordsInOneFile(File file1, AllWordsCounter counter) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader(file1));
		while (true) {
			String line = r.readLine();
			if (line == null) {
				break;
			}

            String words[] = splitLine(line);

            // TODO: Count each of the words using the supplied counter
			// This should only require a few lines of code.

            // XXX
            for (String w : words) {
                counter.count(w);
            }
		}
	}
	
	/**
	 * Find and display words in the primary word counter that are interesting.
	 * Use System.out.println() to print out information about the interesting
	 * words.
	 * TODO: Loop overall all the words in the primary counter and:
	 * 1. Get the counts for the word from the primary and secondary counters.
	 * 2. Calculate a "score" from the primary and secondary counts (higher should be better).
	 * 
	 * You should use this score in three increasingly complex stages.  Complete one stage at a
	 * a time:
	 * 
	 * Stage 1: print out the counts and scores for all words.  You should tweak your scoring
	 * 			method so that words that seem more interesting have higher scores.
	 * 
	 * Stage 2: choose some threshold of minimum interestingness, and print out
	 * 			words that have scores above that.
	 *
	 * Stage 3: Select the 10 words that are most interesting.  You can do this by
	 *			creating a list of all words and scores (see the WordScore class), and
	 *			sorting the list, and printing the top 10.		
	 *
	 */
	private void findInterestingWords() {
        String words[] = primaryCounts.getAllWords();
        WordScore scores[] = new WordScore[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int c1 = primaryCounts.getCount(word);
            int c2 = secondaryCounts.getCount(word);
            double score = getInterestingnessScore(c1, c2);
            scores[i] = new WordScore(word, score);
        }

        Arrays.sort(scores);
        for (int i = 0; i < 10; i++) {
            String word = scores[i].getWord();
            int c1 = primaryCounts.getCount(word);
            int c2 = secondaryCounts.getCount(word);
            System.out.println("word: " + word + ", primary=" + c1 + ", secondary=" + c2);
        }
	}

    /**
     * Returns a "score" indicating how interesting a word is.
     * @param primaryCount
     * @param secondaryCount
     * @return
     */
    private double getInterestingnessScore(int primaryCount, int secondaryCount) {
        return (1.0 + primaryCount) / (4.0 + primaryCount + secondaryCount);
    }

	/**
	 * Splits a line into words.
	 * @param line
	 * @return An array containing the words.
	 */
	private String [] splitLine(String line) {
		return line.split("[^a-zA-Z0-9']+");
	}
	
	public static void main(String args[]) throws IOException {
        File f1 = new File("dat/palin.txt");
        File f2 = new File("dat/biden.txt");

		InterestingWordFinder finder = new InterestingWordFinder();
		finder.countWords(f1, f2);
		finder.findInterestingWords();
	}

    /**
     * Helper class used for sorting word scores.
     */
    private static class WordScore implements Comparable<WordScore> {
        private String word;
        private Double score;

        private WordScore(String word, Double score) {
            this.word = word;
            this.score = score;
        }

        private String getWord() {
            return word;
        }

        private Double getScore() {
            return score;
        }

        @Override
        public int compareTo(WordScore wordScore) {
            return -1 * score.compareTo(wordScore.getScore());
        }
    }
}
