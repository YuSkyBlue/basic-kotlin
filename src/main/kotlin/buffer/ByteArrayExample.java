package buffer;

public class ByteArrayExample {
    public static void main(String[] args){
        byte[] byteArray = new byte[2];

        byteArray[0]= 1;
        byteArray[1] = 2;

        for(byte b : byteArray){
            System.out.println(b);
        }
    }
}
