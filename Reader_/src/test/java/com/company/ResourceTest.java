package com.company;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ResourceTest {

    @Test
    public void checkConstructor(){
        Resource r = new Resource(1);
        assertNotNull(r);
    }

    @Test
    public void checkMaxNoReaders(){
        Resource r = new Resource(5);
        assertEquals(5,r.getMaxNoReaders());
    }

    @Test
    public void checkBook(){
        Resource r = new Resource(5);
        List<Integer> b = r.getBook();
        assertTrue(b.isEmpty());
    }

    @Test
    public void checkWriters(){
        Resource r = new Resource(5);
        List<Writer> b = r.getWriters();
        assertTrue(b.isEmpty());
    }

    @Test
    public void checkReaders(){
        Resource r = new Resource(5);
        List<Reader> b = r.getReaders();
        assertTrue(b.isEmpty());
    }

    @Test
    public void checkAddReaders(){
        Resource r = new Resource(5);
        r.addReader(new Reader(1,r));
        List<Reader> b = r.getReaders();
        assertEquals(1, b.size());
    }

    @Test
    public void checkAddWriters(){
        Resource r = new Resource(5);
        r.addWriter(new Writer(1,r));
        List<Writer> b = r.getWriters();
        assertEquals(1, b.size());
    }

}
