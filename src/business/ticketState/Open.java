package business.ticketState;


public class Open implements State {
    private static Open instance;
    private Open(){

    }
    public static Open getInstance(){
        if(instance == null){
            instance = new Open();
        }
        return instance;
    }

    @Override
    public int showState() {
        return 1;
    }
}
