import java.util.Scanner;

public interface Estilo {
    Scanner scan = new Scanner(System.in);
    public static Scanner abrirScan(){
        return scan;
    }
    public static void fecharScan(Scanner scan){
        scan.close();
    }

}
