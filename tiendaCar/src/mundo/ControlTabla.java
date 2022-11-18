/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mundo;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dafer
 */
public interface ControlTabla {
    public boolean Guardar(String nombreCategoria);
    public boolean GuardarAuto(String placa, String marca, 
            String modelo ,String color,
            String nombreCategoria,String precio);
     public boolean venderAuto(String nombre, String apellido, 
            String cedula ,String telefono,
            String placa);
    
    public DefaultTableModel Mostrar();
    public void Eliminar(int id);
  
}
