package com.company;

/***
 * Class that implements Reader in Writer-Reader Problem
 * stands for process that cannot change the resource.
 */
public class Reader extends Thread{

    final int readerId;
    final Resource resource;

    /***
     * Trivial constructor
     * @param id id of reader
     * @param  resource resource the reader is going to read from
     */
    public Reader(int id, Resource resource){
        this.readerId = id;
        this.resource = resource;
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
        if (!(o instanceof Reader)) return false;
        Reader reader = (Reader) o;
        return getReaderId() == reader.getReaderId();
    }

    /***
     * Method dedicated to getting sleeping time
     * @return randomized time of sleep
     */
    private int getSleep(){
        return (int) (Math.random() * 1000);
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(getSleep());
            }catch(InterruptedException e){}
            try {
                resource.read(readerId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
