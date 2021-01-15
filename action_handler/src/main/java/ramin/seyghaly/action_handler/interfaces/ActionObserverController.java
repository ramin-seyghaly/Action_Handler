package ramin.seyghaly.action_handler.interfaces;

import java.util.Observable;
import java.util.Observer;

import ramin.seyghaly.action_handler.models.Action;

public class ActionObserverController extends Observable {

    private static ActionObserverController actionObserverController;

    public static ActionObserverController getInstance(){
        if (actionObserverController == null){
            actionObserverController = new ActionObserverController();
        }
        return actionObserverController;
    }

    private ActionObserverController() {}

    public void onEvent(Action action){
        if (action != null) {
            /*if(countObservers() == 0){
                throw new AdsException(AdsException.INITIALIZE_EXCEPTION);
            }*/
            setChanged();
            notifyObservers(action);
        }
    }

    public void registerObserver(Observer observer){
        addObserver(observer);
    }

    public void unRegisterObserver(Observer observer){
        deleteObserver(observer);
    }

}