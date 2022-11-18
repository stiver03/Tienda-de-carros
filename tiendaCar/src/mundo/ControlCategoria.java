/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author dafer
 */
public class ControlCategoria implements ControlTabla {
    
    private static ControlCategoria instancia;
    private static String categorias[][]=new String[3][100];
    private int numeroFila=0;
   
   
   

    
    public static ControlCategoria getInstance(){
        if(instancia == null)
            instancia = new ControlCategoria();
        return instancia;
    }
    
    public ControlCategoria(){
        
    }
    
    @Override
    public boolean Guardar(String nombreCategoria) {
       if((numeroFila==0) ||(!categorias[1][numeroFila-1].equals(nombreCategoria)) )
       {
           categorias[1][numeroFila]=nombreCategoria;
           categorias[0][numeroFila]=String.valueOf(numeroFila+1);
           numeroFila++;
           return true;
       }
       return false;
        
        
        
    }

    @Override
    public DefaultTableModel Mostrar() {
        
        
        DefaultTableModel modelo = new DefaultTableModel();
      
        modelo.getColumnCount();
        modelo.addColumn("id");
        modelo.addColumn("Categoria");
        modelo.addColumn("cantidad autos");
        for(int i=0;i<100;i++){
            String[] categoria=new String[3];
            for(int j=0;j<3;j++){
                
                if(categorias[j][i] != null)
                    categoria[j]=categorias[j][i];       
            }
            modelo.addRow(categoria);
        }
       
        return modelo;
    }

    @Override
    public void Eliminar(int id ) {
     
       if(numeroFila>=1)
       {
            //System.out.println("id "+id);
            for (int i=id;i<100;i++)
            {
                for(int j=0;j<2;j++)
                {
                
                    if(categorias[j][i] !=null)
                    {
                        categorias[j][i]=categorias[j][id+1];   
                    }
                }
                id++;
            }
            numeroFila--;
        }
       
       else
       {
            JOptionPane.showMessageDialog(null, "no hay elementos por eliminar");   
       }
         
    }
    
    public static void itmCategorias(JComboBox<String> combo) {
        for(int j=0;j<100;j++)
        {
            combo.addItem(categorias[1][j]);
        }
        
       
    }

    @Override
    public boolean GuardarAuto(String placa, String marca, String modelo, String color, String nombreCategoria, String precio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean venderAuto(String nombre, String apellido, String cedula, 
            String telefono, String placa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean verificar(String categoriaCarro) {
       
        return true;
    }
    
    public void nuevoAuto(String categoria, String cantidad)
    {
        for(int i=0;i<100;i++)
        {
            if(categorias[1][i].equals(categoria))
            {
                categorias[2][i]=String.valueOf(cantidad);
            }
        }
    }
}