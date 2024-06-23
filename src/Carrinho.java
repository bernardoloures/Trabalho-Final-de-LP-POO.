import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Carrinho extends JFrame {
    private List<Produto> produtosCarrinho;
    private DefaultListModel<String> listModel;
    private JLabel totalLabel;

    public Carrinho(List<Produto> produtosCarrinho) {
        this.produtosCarrinho = produtosCarrinho;

        setTitle("Carrinho de Compras");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();
        for (Produto produto : produtosCarrinho) {
            listModel.addElement(produto.getNome());
        }

        JList<String> list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        totalLabel = new JLabel("Total: R$ " + calcularTotal());
        totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        JButton btnComprar = new JButton("Comprar");
        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPagamento telaPagamento = new TelaPagamento();
                telaPagamento.setVisible(true);
                dispose(); // Fecha a tela do Carrinho ao abrir a tela de pagamento
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela do Carrinho e retorna à tela anterior
            }
        });

        JPanel buttonPanel = new JPanel(new BorderLayout());
        JPanel buttons = new JPanel();
        buttons.add(btnComprar);
        buttons.add(btnVoltar);

        buttonPanel.add(totalLabel, BorderLayout.NORTH);
        buttonPanel.add(buttons, BorderLayout.SOUTH);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private double calcularTotal() {
        double total = 0;
        for (Produto produto : produtosCarrinho) {
            total += produto.getPreco();
        }
        return total;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Simulação de produtos no carrinho para teste
                List<Produto> produtos = List.of(
                        new Produto("Camisa Cruzeiro - R$350,00", 350.00, "Bebida", 10),
                        new Produto("Camisa Internacional - R$250,00", 250.00, "Bebida", 15)
                );
                new Carrinho(produtos).setVisible(true);
            }
        });
    }
}
