package com.ej.singleton;

public class Connection {

    //very critical to make INSTANCE volatile.
    //not keeping it volatile may affect singleton in following way
    //Suppose one thread goes to line INSTANCE = new Connection().
    //Now since INSTANCE is not volatile this initialization may not be
    //seen immediately in other thread  and that thread may still
    //think INSTANCE is null and will try to initialize it
    private static volatile Connection INSTANCE = null;
    public static Connection getInstance(){
        if(INSTANCE == null){
            synchronized (Connection.class) {
                if(INSTANCE == null){
                    INSTANCE = new Connection();
                }
            }
        }
        return INSTANCE;
    }
}
