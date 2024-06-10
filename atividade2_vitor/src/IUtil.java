import java.util.Scanner;

public interface IUtil {
    Scanner scan = new Scanner(System.in);

    public static Scanner open(){
        return scan;
    }
    
    public static void close(){
        scan.close();
    }
}
