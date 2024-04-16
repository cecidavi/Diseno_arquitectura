package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarServicioDialog extends JDialog {
    private JTextField txtModelo;
    private JTextArea txtDescripcion;
    private JTextField txtEstado;
    private JTextField txtCosto;
    private JTextField txtFecha;
    private JTextField txtHora;
    private JTextField txtFolioCliente;
    private JButton btnModificar;
    
    public ModificarServicioDialog(JFrame parent, boolean modal, String id, String modeloActual, String descripcionActual, String estadoActual, long costoActual, String fechaActual, String horaActual, String folioClienteActual) {
        super(parent, modal);
        initComponents();
        
        // Configurar los campos de texto con los datos actuales
        txtModelo.setText(modeloActual);
        txtDescripcion.setText(descripcionActual);
        txtEstado.setText(estadoActual);
        txtCosto.setText(Long.toString(costoActual));
        txtFecha.setText(fechaActual);
        txtHora.setText(horaActual);
        txtFolioCliente.setText(folioClienteActual);
        
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para modificar el servicio preventivo en la base de datos
                // Aquí debes escribir el código para actualizar los datos del servicio preventivo en la base de datos
                // Puedes obtener los nuevos valores de los campos de texto con txtModelo.getText(), txtDescripcion.getText(), etc.
                
                // Después de realizar la modificación, cierra el diálogo
                dispose();
            }
        });
    }
    
    private void initComponents() {
        // Aquí configura los componentes del diálogo, como JTextField, JTextArea, JButton, etc.
        // Puedes hacerlo manualmente o utilizando un diseñador de GUI como NetBeans Form Editor
    }
}