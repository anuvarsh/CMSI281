package edu.lmu.cmsi.anu.collections;

import edu.lmu.cmsi.anu.collections.MyCollection;
import edu.lmu.cmsi.anu.collections.MyLinkedList;
import edu.lmu.cmsi.anu.collections.MyLinkedListIterator;
import edu.lmu.cmsi.anu.collections.ManualLinkedList;
import edu.lmu.cmsi.anu.collections.ManualLinkedListIterator;
import edu.lmu.cmsi.anu.collections.MyArray;
import edu.lmu.cmsi.anu.collections.MyArrayIterator;

import org.junit.*;

import java.util.Iterator;

import static org.junit.Assert.*;

public class CollectionsTest {

    private MyArray arr;
    private ManualLinkedList manLink;
    private MyLinkedList myLink;

    @Before
    public void initialize() {
        arr = new MyArray(3);
        manLink = new ManualLinkedList(3);
        myLink = new MyLinkedList(3);
    }

    //skipped all MyArray tests... insert here later


    //ManualLinkedList Tests:
    @Test
    public void manLinkGetOldestFewN() {
        manLink.add("1");
        manLink.add("2");
        assertEquals("did not return oldest element", "1", manLink.getOldest());
    }

    @Test
    public void manLinkGetOldestExtraN() {
        manLink.add("1");
        manLink.add("2");
        manLink.add("3");
        manLink.add("4");
        assertEquals("did not return oldest element", "2", manLink.getOldest());
    }

    @Test
    public void manLinkGetNewestFewN() {
        manLink.add("1");
        manLink.add("2");
        assertEquals("did not return newest element", "2", manLink.getNewest());
    }

    @Test
    public void manLinkGetNewestExtraN() {
        manLink.add("1");
        manLink.add("2");
        manLink.add("3");
        manLink.add("4");
        assertEquals("did not return newest element", "4", manLink.getNewest());
    }

    @Test
    public void manLinkGetSize() {
        manLink.add("1");
        manLink.add("2");
        assertEquals("did not return correct size", 2, manLink.getSize());
    }

    @Test
    public void manLinkResetGetSize() {
        manLink.add("1");
        manLink.add("2");
        manLink.reset();
        assertEquals("did not return correct size", 0, manLink.getSize());
    }

    @Test
    public void manLinkIterator() {
        manLink.add("1");
        manLink.add("2");
        manLink.add("3");
        Iterator<String> manLinkIter = manLink.iterator();
        assertEquals("incorrect first hasNext", true, manLinkIter.hasNext());
        assertEquals("incorrect first next", "1", manLinkIter.next());
        assertEquals("incorrect second hasNext", true, manLinkIter.hasNext());
        assertEquals("incorrect second next", "2", manLinkIter.next());
        assertEquals("incorrect third hasNext", true, manLinkIter.hasNext());
        assertEquals("incorrect third next", "3", manLinkIter.next());
    }

    @Test(expected = IllegalArgumentException.class)
    public void manLinkAddNull() {
        manLink.add(null);
    }


    //MyLinkedList Tests:
    @Test
    public void myLinkGetOldestFewN() {
        myLink.add("1");
        myLink.add("2");
        assertEquals("did not return oldest element", "1", myLink.getOldest());
    }

    @Test
    public void myLinkGetOldestExtraN() {
        myLink.add("1");
        myLink.add("2");
        myLink.add("3");
        myLink.add("4");
        assertEquals("did not return oldest element", "2", myLink.getOldest());
    }

    @Test
    public void myLinkGetNewestFewN() {
        myLink.add("1");
        myLink.add("2");
        assertEquals("did not return newest element", "2", myLink.getNewest());
    }

    @Test
    public void myLinkGetNewestExtraN() {
        myLink.add("1");
        myLink.add("2");
        myLink.add("3");
        myLink.add("4");
        assertEquals("did not return newest element", "4", myLink.getNewest());
    }

    @Test
    public void myLinkGetSize() {
        myLink.add("1");
        myLink.add("2");
        assertEquals("did not return correct size", 2, myLink.getSize());
    }

    @Test
    public void myLinkResetGetSize() {
        myLink.add("1");
        myLink.add("2");
        myLink.reset();
        assertEquals("did not return correct size", 0, myLink.getSize());
    }

    @Test
    public void myLinkIterator() {
        myLink.add("1");
        myLink.add("2");
        myLink.add("3");
        Iterator<String> myLinkIter = myLink.iterator();
        assertEquals("incorrect first hasNext", true, myLinkIter.hasNext());
        assertEquals("incorrect first next", "1", myLinkIter.next());
        assertEquals("incorrect second hasNext", true, myLinkIter.hasNext());
        assertEquals("incorrect second next", "2", myLinkIter.next());
        assertEquals("incorrect third hasNext", true, myLinkIter.hasNext());
        assertEquals("incorrect third next", "3", myLinkIter.next());
    }

    @Test(expected = IllegalArgumentException.class)
    public void myLinkAddNull() {
        myLink.add(null);
    }
}