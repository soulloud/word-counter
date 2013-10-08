package edu.macalester.comp124.wordcounter;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * @author Shilad Sen
 */
public class TestAllWordsCounter {

    @Test
    public void testInitial() {
        AllWordsCounter counter = new AllWordsCounter();
        assertEquals(counter.getCount("foo"), 0);
        assertEquals(counter.getCount("bar"), 0);
        assertEquals(counter.getCount("baz"), 0);
        assertEquals(counter.getNumWords(), 0);
    }

    @Test
    public void testIncrement() {
        AllWordsCounter counter = new AllWordsCounter();
        assertEquals(counter.getCount("foo"), 0);
        counter.count("foo");
        assertEquals(counter.getCount("foo"), 1);
        counter.count("foo");
        counter.count("foo");
        counter.count("bar");
        counter.count("bar");
        assertEquals(counter.getCount("foo"), 3);
        assertEquals(counter.getCount("bar"), 2);
        assertEquals(counter.getNumWords(), 2);
    }

    @Test
    public void testCaseInsensitive() {
        AllWordsCounter counter = new AllWordsCounter();
        assertEquals(counter.getCount("foo"), 0);
        counter.count("foO");
        counter.count("fOo");
        counter.count("fo-o");
        counter.count("bar");
        counter.count("bar!");
        assertEquals(counter.getCount("foo"), 3);
        assertEquals(counter.getCount("bar"), 2);
        assertEquals(counter.getNumWords(), 2);
    }



    @Test
    public void testGetAllWords() {
        AllWordsCounter counter = new AllWordsCounter();
        assertEquals(counter.getCount("foo"), 0);
        counter.count("foo");
        counter.count("fOo");
        counter.count("fo-o");
        counter.count("bar");
        counter.count("bar!");
        assertEquals(counter.getCount("foo"), 3);
        assertEquals(counter.getCount("bar"), 2);
        assertEquals(counter.getNumWords(), 2);
        assertEquals(counter.getAllWords(), new String[] { "foo", "bar"});
    }

}
