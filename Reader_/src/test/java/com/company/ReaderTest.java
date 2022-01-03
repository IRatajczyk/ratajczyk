package com.company;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;

public class ReaderTest {

    @Test
    public void checkConstructor(){
        Resource re = new Resource(1);
        Reader rd = new Reader(1,re);
        assertNotNull(rd);
    }

    @Test
    public void checkId(){
        Resource re = new Resource(1);
        Reader rd = new Reader(1,re);
        assertEquals(1,rd.getReaderId());
    }

    @Test
    public void checkEquals(){
        Resource re = new Resource(1);
        Reader rd = new Reader(1,re);
        assertEquals(rd,rd);
    }

    @Test
    public void checkNotEquals(){
        Resource re = new Resource(1);
        Reader rd = new Reader(1,re);
        Reader rd2 = new Reader(2,re);
        assertNotSame(rd,rd2);
    }

}
