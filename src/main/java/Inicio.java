import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {
    private JPanel mainPanel;
    private JButton consultarTodosButton;
    private JButton consultarPorCodigoButton;
    private JButton agregarRegistroButton;
    private JButton actualizarRegistroButton;
    private JButton eliminarRegistroButton;
    private JTextArea textArea1;
    private JList<String> list1;

    public Inicio() {
        setContentPane(mainPanel);
        setTitle("Consultas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        // Action Listeners
        consultarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funciones.ejecutarConsultarTodos();
            }
        });

        consultarPorCodigoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = JOptionPane.showInputDialog("Ingrese el código:");
                Funciones.ejecutarConsultarPorCodigo(codigo);
            }
        });

        agregarRegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para agregar registro
            }
        });

        actualizarRegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para actualizar registro
            }
        });

        eliminarRegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = JOptionPane.showInputDialog("Ingrese el código:");
                Funciones.ejecutarEliminarPorCodigo(codigo);
            }
        });
    }

    public static void main(String[] args) {
        new Inicio();
    }
}



