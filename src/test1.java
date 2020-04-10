import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

class test{

    public static void main(String[] args) throws Exception {

        FileInputStream in = new FileInputStream("cet6.md");
        int temp = -1;
        Scanner sin = new Scanner(in);
        ArrayList<String> words = new ArrayList<>();
        int index = 0;
        while(sin.hasNextLine()){
            words.add(sin.nextLine());

        }

        Random ran = new Random(2);
        int aa = 0;
        while(!words.isEmpty()){
            int cur = ran.nextInt(words.size());
            System.out.println(words.get(cur));
            words.remove(cur);
            aa++;

        }
        System.out.println(aa);

    }
}