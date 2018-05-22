package server;

public class StatusSingleton {

    private static final StatusSingleton instance = new StatusSingleton();;
    private boolean isWorking;


    private StatusSingleton(){
        isWorking = true;
    }

    public static StatusSingleton getInstance() {
        return instance;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}
