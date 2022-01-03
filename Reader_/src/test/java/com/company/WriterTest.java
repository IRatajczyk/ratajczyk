package com.company;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class WriterTest {

    @Test
    public void checkConstructor(){
        Resource re = new Resource(1);
        Writer wr = new Writer(1,re);
        assertNotNull(wr);
    }

    @Test
    public void checkId(){
        Resource re = new Resource(1);
        Writer wr = new Writer(1,re);
        assertEquals(1,wr.getWriterId());
    }

    @Test
    public void checkEquals(){
        Resource re = new Resource(1);
        Writer wr = new Writer(1,re);
        assertEquals(wr,wr);
    }

    @Test
    public void checkNotEquals(){
        Resource re = new Resource(1);
        Writer wr = new Writer(1,re);
        Writer wr2 = new Writer(2,re);
        assertNotSame(wr,wr2);
    }


}
