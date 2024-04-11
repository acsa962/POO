import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        Pessoa pf = new Fisica(scan.nextLine(), scan.nextLine(),scan.nextLine(), scan.nextLine());

        Pessoa pj = new Juridica(scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine());
        
        System.out.println("\n\n");
        
        pf.boletim();
        System.out.println("\n#######################\n");
        pj.boletim();

        scan.close();
    }
}
