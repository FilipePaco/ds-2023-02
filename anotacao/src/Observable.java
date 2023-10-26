import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Observable<T> {
    private List<Consumer<T>> observers = new ArrayList<>();

    public void addObserver(Consumer<T> observer) {
        observers.add(observer);
    }

    public void notifyObservers(T event) {
        observers.forEach(observer -> observer.accept(event));
    }
}


