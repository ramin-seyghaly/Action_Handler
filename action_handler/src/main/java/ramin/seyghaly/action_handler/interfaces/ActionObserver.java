package ramin.seyghaly.action_handler.interfaces;

import java.util.Observable;
import java.util.Observer;

import ramin.seyghaly.action_handler.models.Action;

public class ActionObserver implements Observer {

    private Delegate delegate;

    public interface Delegate{
        void onActionEvent(Action action);
    }

    public ActionObserver(Delegate actionDelegate) {
        this.delegate = actionDelegate;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Action) {
            delegate.onActionEvent((Action) arg);
        }
    }

}