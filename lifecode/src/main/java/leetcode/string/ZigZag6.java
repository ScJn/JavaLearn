package leetcode.string;

public class ZigZag6 {

    /**
     *
     * using char[][] to store the zigzag sequence
     * need store the current row and column, use a flag to control either go down straight or go up
     *
     *
     */
    public static String convert(String s, int numRows) {
        if(s.length()<1)return s;
        if(numRows==1)return s;
        char[][] con = new char[numRows][s.length()];
        int col = 0;
        int row=-1;
        boolean colFlag=true; // stop
        for (int i = 0; i < s.length(); i++) {

            if(colFlag){
                con[++row][col]=s.charAt(i);
            }else{
                con[--row][++col]=s.charAt(i);
            }
            if(i%(numRows-1)==0){
                colFlag = (i / (numRows - 1) & 1) == 0;
            }


        }
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<=col;j++){
                stringBuilder.append(con[i][j]==0?"":con[i][j]);
            }
        }
        return stringBuilder.toString();
    }


    /**
     * use several StringBuilder to store the zigzag's rows respectively
     * need a flag to specify the change of the index of the array of StringBuilder(+1 or -1)
     * combine several StringBuilder, use the join()
     */
    public String convert2(String s, int numRows) {
        if (numRows<=1) return s;
        StringBuilder[] sb= new StringBuilder[numRows];
        for (int i=0; i<numRows; i++) sb[i]=new StringBuilder();
        int idx=0, k=1;
        for (char c: s.toCharArray()){
            sb[idx].append(c);
            if (idx==0) k=1;
            if (idx==numRows-1) k=-1;
            idx+=k;
        }
        return String.join("", sb);
    }

    public static void main(String[] args) {
        System.out.println(convert("AB",1));

    }

}
