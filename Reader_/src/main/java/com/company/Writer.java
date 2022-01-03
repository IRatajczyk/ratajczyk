package com.company;


public class Writer extends Thread{

    private final int writerId;
    private final Resource resource;

    /***
     * Trivial constructor
     * @param id id of writer
     * @param  resource resource the reader is going to read from
     */
    public Writer(int id, Resource resource){
        this.writerId = id;
        this.resource = resource;
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
        if (!(o instanceof Writer)) return false;
        Writer writer = (Writer) o;
        return getWriterId() == writer.getWriterId();
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
                resource.write(writerId, writerId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
