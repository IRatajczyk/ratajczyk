package com.company;

import java.util.ArrayList;
import java.util.List;


/***
 * Class that implements resources in Reader-Writer Problem
 */
public class Resource {

    private final ArrayList<Integer> book;
    private final ArrayList<Writer> writers;
    private final ArrayList<Reader> readers;

    private final int maxNoReaders;
    private int currentlyWriting;
    private int currentlyReading;

    private boolean prepareForWriting;

    /***
     * Trivial constructor
     * @param maxNoReaders maximal number of readers at one time
     */
    public Resource(int maxNoReaders){
        book = new ArrayList<>();
        this.readers = new ArrayList<>();
        this.writers = new ArrayList<>();
        this.maxNoReaders = maxNoReaders;
        currentlyWriting = 0;
        currentlyReading = 0;
        prepareForWriting = true;
    }

    /***
     * Simple getter
     * @return maximal number of readers at one time
     */
    public int getMaxNoReaders() {
        return maxNoReaders;
    }

    /***
     * Simple getter
     * @return the very resource to be written
     */
    public List<Integer> getBook() {
        return book;
    }

    /***
     * Method dedicated to adding a Writer for waiting for resources
     * @param writer writer to be added
     */
    public void addWriter(Writer writer){
        writers.add(writer);
    }

    /***
     * Method dedicated to adding a Reader for waiting for resources
     * @param reader writer to be added
     */
    public void addReader(Reader reader){
        readers.add(reader);
    }

    /***
     * Metohd dedicated for comprehensive start all Threads
     */
    public void startAll(){
        for(Reader reader: readers){
            reader.start();
        }
        for(Writer writer: writers){
            writer.start();
        }
    }

    /***
     * Method dedicated to writing to resource
     * @param writerId writing writer id
     * @param value value to be witten
     * @throws InterruptedException in case of interruption
     */
    public void write(int writerId, int value) throws InterruptedException {

        if (!prepareForWriting){
            return;
        }
        synchronized (this) {
            while (currentlyWriting > 0 || !prepareForWriting) {
                try {
                    System.out.println("Writer " + writerId + " would like to get access to a resource");
                    this.wait();
                } catch (InterruptedException ignored) {}
            }
            currentlyWriting++;
            System.out.println("Writer " + writerId + " has begun writing");
            book.add(value);
            try {
                this.wait(getSleep());
            } catch (InterruptedException e) {
            }
            currentlyWriting--;
            System.out.println("Writer " + writerId + " has finished writing");
            prepareForWriting = false;
            this.notifyAll();
        }
    }

    /***
     * Method dedicated to reading from resource
     * @param readerId reading reader Id
     * @throws InterruptedException in case of interruption
     */
    public void read(int readerId) throws InterruptedException {
        if(prepareForWriting){
            return;
        }
        synchronized(this){
            while(currentlyReading>=maxNoReaders) {
                try
                {
                    this.wait();
                }
                catch (InterruptedException e) {}
            }
            currentlyReading++;
            System.out.println("Reader "+readerId+" has begun reading");
        }
        try{
            Thread.sleep(10L *getSleep());
        }catch(InterruptedException ignored){}
        synchronized(this){
            currentlyReading--;
            System.out.println("Reader "+readerId+" has finished reading");
            if(currentlyReading==0){
                this.notifyAll();
                prepareForWriting = true;
            }
        }
    }

    /***
     * Method dedicated to getting sleeping time
     * @return randomized time of sleep
     */
    private int getSleep(){
        return (int) (Math.random() * 100);
    }
}
