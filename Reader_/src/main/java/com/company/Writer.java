package com.company;


import java.util.Objects;
import java.util.Random;

public class Writer extends Thread{

    private final int writerId;
    private final Resource resource;
    private Random r;
    /***
     * Trivial constructor
     * @param id id of writer
     * @param  resource resource the reader is going to read from
     */
    public Writer(int id, Resource resource){
        this.writerId = id;
        this.resource = resource;
        this.r = new Random();
    }

    /***
     * Simple getter
     * @return writer id
     */
    public int getWriterId() {
        return writerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Writer writer)) return false;
        return getWriterId() == writer.getWriterId() && Objects.equals(resource, writer.resource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWriterId(), resource);
    }

    /***
     * Method dedicated to getting sleeping time
     * @return randomized time of sleep
     */
    private int getSleep(){
        return (int) (Math.random() * 5000);
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(getSleep());
            }catch(InterruptedException e){}
            try {
                resource.write(writerId, writerId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
