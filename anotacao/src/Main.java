public class Main {
    public static void main(String[] args) {
        Observable<String> carroObservable = new Observable<>();

        carroObservable.addObserver(event -> System.out.println("Objeto Observer: " + event));
        carroObservable.addObserver(event -> System.out.println("Outro Objeto Observer: " + event));

        carroObservable.notifyObservers("Evento no carro!");
    }
}