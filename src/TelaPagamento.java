import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPagamento extends JFrame {

    public TelaPagamento() {
        setTitle("Tela de Pagamento");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        setLocationRelativeTo(null);

        JButton btnPix = new JButton("Pagar com Pix");
        JButton btnCartao = new JButton("Pagar com Cartão de Crédito");

        btnPix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirQrCode();
            }
        });

        btnCartao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPagamento("Cartão de Crédito");
            }
        });

        add(btnPix);
        add(btnCartao);
    }

    private void abrirQrCode() {
        JFrame qrFrame = new JFrame("QR Code - Pix");
        qrFrame.setSize(800, 600);
        qrFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        qrFrame.setLocationRelativeTo(null);

        // Substitua o caminho da imagem com o caminho correto
        ImageIcon qrIcon = new ImageIcon(getClass().getResource("Imagem/qr-code.jpg"));
        JLabel qrLabel = new JLabel(qrIcon);

        qrFrame.add(qrLabel);
        qrFrame.setVisible(true);
    }

    private void realizarPagamento(String metodoPagamento) {
        JOptionPane.showMessageDialog(this, "Selecionada opção de pagamento com " + metodoPagamento);
        voltarParaHome();
    }

    private void voltarParaHome() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaInicial telaInicial = new TelaInicial();
                telaInicial.setVisible(true);
                dispose(); // Fecha a tela de pagamento
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPagamento().setVisible(true);
            }
        });
    }
}
