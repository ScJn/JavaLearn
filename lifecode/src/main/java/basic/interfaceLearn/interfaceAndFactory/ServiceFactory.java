package basic.interfaceLearn.interfaceAndFactory;

public interface ServiceFactory {
    Service getService();
}

class CarServiceFactory implements ServiceFactory{

    @Override
    public Service getService() {
        return new CarService(); // up cast
    }
}

class RoomServiceFactory implements ServiceFactory {
    @Override
    public Service getService() {
        return new RoomService();
    }
}