package business.ticketState;

public class Closed implements State {
    private static Closed instance;
    private Closed(){

    }

    @Override
    public int showState() {
        return 0;
    }

    public static Closed getInstance(){
        if(instance == null){
            instance = new Closed();
        }
        return instance;
    }
}
