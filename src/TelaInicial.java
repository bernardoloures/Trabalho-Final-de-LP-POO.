import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaInicial extends JFrame {
    private JButton btnCarrinho;
    private JButton btnCarrinhoIcon;
    private JButton btnLogin;
    private List<Produto> carrinhoDeCompras = new ArrayList<>();

    public TelaInicial() {
        setTitle("FutFans");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel vitrinePanel = new JPanel(new GridLayout(2, 2));

        Produto camisa1 = new Produto("Camisa Cruzeiro - R$350,00", 350.00, "Futebol", 10);
        Produto camisa2 = new Produto("Camisa Atletico - R$300,00", 300.00, "Futebol", 142);
        Produto camisa3 = new Produto("Camisa Internacional - R$250,00", 250.00, "Futebol", 214);
        Produto camisa4 = new Produto("Camisa São Paulo - R$350,00", 350.00, "Futebol", 18);

        // Carregue as imagens usando ImageIcon
        ImageIcon imagemCamisa1 = new ImageIcon(getClass().getResource("Imagem/camisa-cruzeiro.jpg"));
        ImageIcon imagemCamisa2 = new ImageIcon(getClass().getResource("Imagem/camisa-atletico.jpg"));
        ImageIcon imagemCamisa3 = new ImageIcon(getClass().getResource("Imagem/camisa-internacional.jpg"));
        ImageIcon imagemCamisa4 = new ImageIcon(getClass().getResource("Imagem/camisa-sao-paulo.jpg"));

        // Redimensione as imagens para o tamanho desejado
        Image imgCamisa1 = imagemCamisa1.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        Image imgCamisa2 = imagemCamisa2.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        Image imgCamisa3 = imagemCamisa3.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        Image imgCamisa4 = imagemCamisa4.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);

        // Crie novos Icones com as imagens redimensionadas
        ImageIcon imgRedimensionada1 = new ImageIcon(imgCamisa1);
        ImageIcon imgRedimensionada2 = new ImageIcon(imgCamisa2);
        ImageIcon imgRedimensionada3 = new ImageIcon(imgCamisa3);
        ImageIcon imgRedimensionada4 = new ImageIcon(imgCamisa4);

        // Crie os labels com as imagens e informações
        JLabel labelCamisa1 = new JLabel(imgRedimensionada1);
        labelCamisa1.setText("<html><center><h2>" + camisa1.getNome());
        labelCamisa1.setHorizontalTextPosition(JLabel.CENTER);
        labelCamisa1.setVerticalTextPosition(JLabel.BOTTOM);
        labelCamisa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adicionarAoCarrinho(camisa1);
            }
        });

        JLabel labelCamisa2 = new JLabel(imgRedimensionada2);
        labelCamisa2.setText("<html><center><h2>" + camisa2.getNome());
        labelCamisa2.setHorizontalTextPosition(JLabel.CENTER);
        labelCamisa2.setVerticalTextPosition(JLabel.BOTTOM);
        labelCamisa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adicionarAoCarrinho(camisa2);
            }
        });

        JLabel labelCamisa3 = new JLabel(imgRedimensionada3);
        labelCamisa3.setText("<html><center><h2>" + camisa3.getNome());
        labelCamisa3.setHorizontalTextPosition(JLabel.CENTER);
        labelCamisa3.setVerticalTextPosition(JLabel.BOTTOM);
        labelCamisa3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adicionarAoCarrinho(camisa3);
            }
        });

        JLabel labelCamisa4 = new JLabel(imgRedimensionada4);
        labelCamisa4.setText("<html><center><h2>" + camisa4.getNome());
        labelCamisa4.setHorizontalTextPosition(JLabel.CENTER);
        labelCamisa4.setVerticalTextPosition(JLabel.BOTTOM);
        labelCamisa4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adicionarAoCarrinho(camisa4);
            }
        });

        // Adicione os labels ao painel
        vitrinePanel.add(labelCamisa1);
        vitrinePanel.add(labelCamisa2);
        vitrinePanel.add(labelCamisa3);
        vitrinePanel.add(labelCamisa4);

        // Crie o botão do carrinho com ícone
        ImageIcon iconeCarrinho = new ImageIcon(getClass().getResource("Imagem/carrinho.png"));
        Image imageCarrinho = iconeCarrinho.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        iconeCarrinho = new ImageIcon(imageCarrinho);
        btnCarrinhoIcon = new JButton(iconeCarrinho);
        btnCarrinhoIcon.setToolTipText("Ver Carrinho");
        btnCarrinhoIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                abrirCarrinho();
            }
        });

        // Crie um painel para o botão Login e o botão do carrinho
        JPanel botaoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Login login = new Login();
                login.setVisible(true);
                dispose(); // Fecha a tela Home
            }
        });
        botaoPanel.add(btnLogin);
        botaoPanel.add(btnCarrinhoIcon);

        btnCarrinho = new JButton("Carrinho");
        btnCarrinho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                abrirCarrinho();
            }
        });

        // Adicione os painéis à janela
        add(botaoPanel, BorderLayout.NORTH);
        add(vitrinePanel, BorderLayout.CENTER);
        add(btnCarrinho, BorderLayout.SOUTH);
        updateCarrinhoButton(); // Chama a função para atualizar o botão inicialmente

        // Mensagem com fundo colorido
        JPanel mensagemPanel = new JPanel();
        mensagemPanel.setBackground(Color.YELLOW);
        mensagemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel mensagemLabel = new JLabel("Clique na imagem do produto, para adicioná-lo ao carrinho.");
        mensagemPanel.add(mensagemLabel);
        add(mensagemPanel, BorderLayout.SOUTH);
    }

    private void adicionarAoCarrinho(Produto produto) {
        carrinhoDeCompras.add(produto);
        JOptionPane.showMessageDialog(null, "Camisa adicionado ao carrinho com sucesso!");
        updateCarrinhoButton();
    }

    private void updateCarrinhoButton() {
        if (carrinhoDeCompras.isEmpty()) {
            btnCarrinho.setText("Carrinho");
        } else {
            StringBuilder text = new StringBuilder("Carrinho (");
            for (int i = 0; i < carrinhoDeCompras.size(); i++) {
                text.append(carrinhoDeCompras.get(i).getNome());
                if (i < carrinhoDeCompras.size() - 1) {
                    text.append(", ");
                }
            }
            text.append(")");
            btnCarrinho.setText(text.toString());
        }
    }

    private void abrirCarrinho() {
        Carrinho carrinho = new Carrinho(carrinhoDeCompras);
        carrinho.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }
}
