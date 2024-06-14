import javax.swing.*;




public class Inicio extends JFrame {
    private JPanel mainPanel;
    private JButton buscarButton;
    private JButton editarButton;
    private JList list1;
    private JButton borrarButton;
    private JButton añadirButton;
    private JFormattedTextField formattedTextField1;

    public Inicio() {
        setContentPane(mainPanel);
        setTitle("Consultas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    public static void main(String[] args) {
    new Inicio();
    }


}



