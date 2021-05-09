package basic.exception;

public class FinallyTest {

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {

            try{
                System.out.println(11);
                if(i == 1)break;
                continue;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println(222);
            }
        }
    }
}
