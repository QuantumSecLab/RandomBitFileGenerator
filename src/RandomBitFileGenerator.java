import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Scanner;

public class RandomBitFileGenerator {

    public static void main(String args[]) {
        int fileSizeInBytes = 1024; // change this to the desired file size

        Scanner se = new Scanner(System.in);
        System.out.println("Enter the desired file size (in byte): ");
        fileSizeInBytes = se.nextInt();

        String fileName = "random_bits.bin"; // change this to the desired file name

        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[1 << 10];

        int numberOfKB = fileSizeInBytes / (1 << 10);
        int numberOfBytes = fileSizeInBytes % (1 << 10);

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            while (numberOfKB != 0) {
                numberOfKB -= 1;
                random.nextBytes(bytes);
                fos.write(bytes);
            }
            while (numberOfBytes != 0) {
                numberOfBytes -= 1;
                fos.write((byte) random.nextInt(256));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
