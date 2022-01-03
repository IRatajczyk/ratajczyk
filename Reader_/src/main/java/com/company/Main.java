package com.company;

public class Main {
    public static void main(String[] args) {
        final int noReaders = Integer.parseInt(args[0]);
        final int noWriters = Integer.parseInt(args[1]);

        Resource resource = new Resource(5);

        for (int i = 0; i < noReaders; i++) {
            resource.addReader(new Reader(i, resource));
        }
        for (int j = 0; j < noWriters; j++) {
            resource.addWriter(new Writer(j, resource));
        }
        resource.startAll();
    }


}
