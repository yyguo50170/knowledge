package Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuoYangYang
 * @date 2022/1/14
 * 被观察者
 */
public class Observable {
    private List<Observer> list = new ArrayList<>();

    public void addObserver(Observer o){
        list.add(o);
    }

    public void removeObserver(Observer o){
        list.remove(o);
    }

    public void notifyObservers(Object event){
        for(Observer ob:list){
            ob.update(event);
        }
    }
}
