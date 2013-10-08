package edu.macalester.comp124.wordcounter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Shilad Sen
 */
public class TestSingleWordCounter {

    @Test
    public void testSimple() {
        SingleWordCounter counter = new SingleWordCounter("dog");
        assertEquals(counter.getWord(), "dog");
        assertTrue(counter.wordMatches("DOG"));
        assertTrue(counter.wordMatches("DoG"));
        assertTrue(counter.wordMatches("Do-G"));
        assertTrue(counter.wordMatches("DOG!"));
        assertEquals(counter.getCount(), 0);
    }

    @Test
    public void testIncrement() {
        SingleWordCounter counter = new SingleWordCounter("dog");
        assertEquals(counter.getWord(), "dog");
        assertEquals(counter.getCount(), 0);
        counter.incrementCount();
        assertEquals(counter.getCount(), 1);
    }
}
