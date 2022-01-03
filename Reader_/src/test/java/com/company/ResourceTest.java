package com.company;

import org.junit.Test;

import java.util.ArrayList;

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
        ArrayList<Integer> b = r.getBook();
        assertTrue(b.isEmpty());
    }


}
