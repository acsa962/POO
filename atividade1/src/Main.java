package POO1.atividade1.src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        PessoaFisica pf = new PessoaFisica(scan.nextLine(), scan.nextLine(),scan.nextLine(), scan.nextLine());

        PessoaJuridica pj = new PessoaJuridica(scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine());
        
        System.out.println("\n\n");
        
        pf.boletim();
        System.out.println("\n#######################\n");
        pj.boletim();

        scan.close();
    }
}
