package basic;

public class Delegation {

    class SpaceShipController{
        public void forward(){}
        public void up(){}
        public void down(){}
        public void backward(){}
    }

    class SpaceShip {
        SpaceShipController controller = new SpaceShipController();

        public void forward() {
            controller.forward();
        }

        public void up() {
            controller.up();
        }

        public void down() {
            controller.down();
        }

        public void backward() {
            controller.backward();
        }
    }
}
