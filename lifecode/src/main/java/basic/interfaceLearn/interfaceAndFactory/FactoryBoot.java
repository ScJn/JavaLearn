package basic.interfaceLearn.interfaceAndFactory;

/**
 * factory design pattern
 *
 */
public class FactoryBoot {

    static void consume(ServiceFactory factory){
        Service service = factory.getService();
        service.service();
    }

    static void consume2(Service service){
        service.service();
    }

    public static void main(String[] args) {
        consume(new CarServiceFactory());
        consume(new RoomServiceFactory());

        consume2(new CarService()); // this can also work, so why I need factory design pattern
        consume2(new RoomService());
    }
}
