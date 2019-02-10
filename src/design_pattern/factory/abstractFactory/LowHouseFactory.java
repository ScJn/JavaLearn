package design_pattern.factory.abstractFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

public class LowHouseFactory implements HouseFactory {

    @Override
    public Door createDoor() {
        return new LowDoor();
    }

    @Override
    public Floor createFloor() {
        return new LowFloor();
    }

    @Override
    public Windows createWindows() {
        return new LowWindows();
    }

    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();
        try {
            Connection connection=DriverManager.getConnection("");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
