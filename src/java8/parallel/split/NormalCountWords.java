package java8.parallel.split;

public class NormalCountWords {

    public static int countWordsIteratively(String s){
        int cont = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if(Character.isWhitespace(c)){
                lastSpace = true;
            } else {
                if(lastSpace) cont++;
                lastSpace = false;
            }
        }
        return cont;
    }

    public static void main(String[] args) {
        System.out.println(countWordsIteratively("i'm famous hhh?"));
    }
}
