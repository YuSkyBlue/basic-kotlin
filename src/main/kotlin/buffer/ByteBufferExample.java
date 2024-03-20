package buffer;

import java.nio.ByteBuffer;

public class ByteBufferExample {
    public static void main(String[] args){
        ByteBuffer buffer =ByteBuffer.allocate(10);

        buffer.put((byte) 1); // Write mode: position=1, limit=10
        buffer.put((byte) 2); // Write mode: position=2, limit=10
        buffer.flip(); // Switch to read mode: position=0, limit=2
        byte a = buffer.get(); // Assuming this buffer was in read mode and had some data
        System.out.println(buffer.compact()); // Unread data is moved to the beginning, and the buffer is now in write mode ready for more data

        System.out.println("a:" + a);
        while(buffer.hasRemaining()){
            System.out.println(buffer.get());
        }

    }
}
