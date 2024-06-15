package atividade3;

import java.util.Scanner;

public interface IUtil {
    Scanner scan = new Scanner(System.in);

    public static Scanner open(){
        return scan;
    }
    
    public static void close(){
        scan.close();
    }

    public static boolean escolha(){
        Scanner scan  = IUtil.open();
        int aux = -1;
        aux = scan.nextInt();
        scan.nextLine();
        while(aux != 1 && aux != 0){
            System.out.println("Por favor, digite 0 ou 1!");
            aux = scan.nextInt();
            scan.nextLine();
        }
        
        if(aux == 1) return true;
        else return false;
    }
}

