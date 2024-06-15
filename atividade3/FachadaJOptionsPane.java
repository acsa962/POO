package atividade3;

import java.util.List;
import javax.swing.JOptionPane;

public class FachadaJOptionsPane {

    public static void exibirMensagemComum(String mensagem, String titulo){
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);
    }

    public static void exibirMensagemWarning(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.WARNING_MESSAGE);
    }

    public static void exibirMensagemError(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
    }


    public static String lerStrings(String mensagem) {
        return JOptionPane.showInputDialog(mensagem);
    }

    public static int lerInteiro(String mensagem) {
        int opcao = 0;
        boolean opcaoValida = false;
        
        while (!opcaoValida) {
            String input = JOptionPane.showInputDialog(mensagem);
            // Verifica se o input é null (usuário clicou em "Cancel" ou fechou a caixa de diálogo)
            if (input == null) {
                FachadaJOptionsPane.finalizarPrograma("Encerrando pedido...", "Encerrando"); // Retorna null se o usuário cancelou a operação
                return -1; // Retorna um valor indicativo de cancelamento
                } else {
                    try {
                        opcao = Integer.parseInt(input);
                        opcaoValida = true;
                    } catch (NumberFormatException e) {
                        exibirMensagemWarning("Por favor, digite um número inteiro válido.", null);
            }
            }
        }
        return opcao;
    }

    public static float lerFloat(String mensagem) {
        String input = JOptionPane.showInputDialog(mensagem);
        return Float.parseFloat(input);
    }

    public static Produto selecionaProduto(List<Produto> produtos){

        Object produtoSelecionado  = JOptionPane.showInputDialog(null, "Escolha um produto", "Opção", JOptionPane.PLAIN_MESSAGE, null, produtos.toArray(), produtos.get(0));
        if (produtoSelecionado instanceof Produto) {
            return (Produto) produtoSelecionado; // Converte para Produto se foi selecionado
        } else {
            FachadaJOptionsPane.finalizarPrograma("Encerrando pedido...", "Encerrando"); // Retorna null se o usuário cancelou a operação
            return null;
        }
    }

    public static int exibirMensagemBotao(String mensagem, String botao1, String botao2, String titulo){
        String[] respostas = {botao1, botao2};
        return JOptionPane.showOptionDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, respostas, 0);
    }

    public static void finalizarPrograma(String mensagem, String titulo){
        FachadaJOptionsPane.exibirMensagemComum(mensagem, titulo);
        System.exit(0);
    }



}
