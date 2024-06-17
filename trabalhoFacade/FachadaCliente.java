package trabalhoFacade;

public class FachadaCliente {


    /*
     * Utiliza das janelas da JOptionsPane para receber informações do cliente e criar uma instância de Cliente Físico ou Jurídico, decidido pelo usuário
    */
    public static Cliente clienteBuilder(){
        Cliente cliente;

        int tipo = FachadaJOptionsPane.exibirMensagemBotao("Como deseja se cadastrar?", "Pessoa Física", "Pessoa Jurídica", "Tipo de cadastro");
        //0-> fisica     1-> jurídica
        
        String nome = FachadaJOptionsPane.lerStrings("Nome: ");
        String email = FachadaJOptionsPane.lerStrings("Email: ");
        String telefone = FachadaJOptionsPane.lerStrings("Telefone: ");

        if(tipo == 0){
            String cpf = FachadaJOptionsPane.lerStrings("Informe o CPF:");
            cliente = new Fisico(nome, email, telefone, cpf);
        } else {
            String cnpj = FachadaJOptionsPane.lerStrings("Informe o CNPJ:");
            cliente = new Juridico(nome, email, telefone, cnpj);
        }

        return cliente;
    }

}
