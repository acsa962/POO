package trabalhoFacade;

public class FachadaCliente {


    /*
     * Utiliza das janelas da JOptionPane para receber informações do cliente e criar uma instância de Cliente Físico ou Jurídico, decidido pelo usuário
    */
    public static Cliente clienteBuilder(){
        Cliente cliente;

        int tipo = FachadaJOptionPane.exibirMensagemBotao("Como deseja se cadastrar?", "Pessoa Física", "Pessoa Jurídica", "Tipo de cadastro");
        //0-> fisica     1-> jurídica
        
        String nome = FachadaJOptionPane.lerStrings("Nome: ");
        String email = FachadaJOptionPane.lerStrings("Email: ");
        String telefone = FachadaJOptionPane.lerStrings("Telefone: ");

        if(tipo == 0){
            String cpf = FachadaJOptionPane.lerStrings("Informe o CPF:");
            cliente = new Fisico(nome, email, telefone, cpf);
        } else {
            String cnpj = FachadaJOptionPane.lerStrings("Informe o CNPJ:");
            cliente = new Juridico(nome, email, telefone, cnpj);
        }

        return cliente;
    }

}
