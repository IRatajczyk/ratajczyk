package com.company;

import java.util.Objects;
import java.util.Random;


/***
 * Class that implements Reader in Writer-Reader Problem
 * stands for process that cannot change the resource.
 */
public class Reader extends Thread{

    final int readerId;
    final Resource resource;
    Random r;
    /***
     * Trivial constructor
     * @param id id of reader
     * @param  resource resource the reader is going to read from
     */
    public Reader(int id, Resource resource){
        this.readerId = id;
        this.resource = resource;
        this.r = new Random();
    }

    /***
     * Simple getter
     * @return reader id
     */
    public int getReaderId() {
        return readerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reader reader)) return false;
        return getReaderId() == reader.getReaderId() && Objects.equals(resource, reader.resource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReaderId(), resource);
    }

    /***
     * Method dedicated to getting sleeping time
     * @return randomized time of sleep
     */
    public int getSleep(){
        return r.nextInt(1000);
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(getSleep());
            }catch(InterruptedException ignored){}
            try {
                resource.read(readerId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
