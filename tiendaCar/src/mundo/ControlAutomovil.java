/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author dafer
 */
public class ControlAutomovil implements ControlTabla{

    private static ControlAutomovil instancia;
    private String autos[][]=new String[6][100];;
    private int cantidadRegistro=0;
    private  String marca;
    private String modelo;
    private  String color;
    private  String categoria;
    private  String precio;
    
    public static ControlAutomovil getInstance(){
        if(instancia == null)
            instancia = new ControlAutomovil();
        return instancia;
    }
    
    public ControlAutomovil(){
       
 
    }
    @Override
    public boolean Guardar(String nombreAuto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DefaultTableModel Mostrar() {
       
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("placa");
        modelo.addColumn("marca");
        modelo.addColumn("modelo");
        modelo.addColumn("color");
        modelo.addColumn("categoria");
        modelo.addColumn("precio");
        
        
     
        for(int i=0;i<100;i++){
            String[] categoria=new String[6];
            for(int j=0;j<6;j++){
                //System.out.println("codigo "+pokemones[i][j]+": nombre: "+pokemones[i][j]);
                if(autos[j][i] != null)
                    categoria[j]=autos[j][i];
                    
            }
            modelo.addRow(categoria);
        }
        return modelo;
    }

    @Override
    public void Eliminar(int id) {
        if(cantidadRegistro>=1)
       {
            //System.out.println("id "+id);
            for (int i=id;i<100;i++)
            {
                for(int j=0;j<6;j++)
                {
                
                    if(autos[j][i] !=null)
                    {
                        autos[j][i]=autos[j][id+1];   
                    }
                }
                id++;
            }
            cantidadRegistro--;
        }
       
       else
       {
            JOptionPane.showMessageDialog(null, "no hay elementos por eliminar");   
       }
    }

    @Override
    public boolean GuardarAuto(String placa, String marca, 
            String modelo, String color, String nombreCategoria, 
            String precio) {
        if(cantidadRegistro>=1 && autos[0][cantidadRegistro-1].equals(placa))
        {
            JOptionPane.showMessageDialog(null, "auto con placas "+placa+
                    "\n ya esta registrado ");
            return false;
        }
        else
        {
            autos[0][cantidadRegistro]=placa;
            autos[1][cantidadRegistro]=marca;
            autos[2][cantidadRegistro]=modelo;
            autos[3][cantidadRegistro]=color;
            autos[4][cantidadRegistro]=nombreCategoria;
            autos[5][cantidadRegistro]=precio;
        }
        cantidadRegistro++;
        return true;
        
    }
    
    public boolean verificarCarro(String placa)
    {
        
        for (int i=0;i<100;i++)
        {
            if(autos[0][i].equals(placa))
            {
               marca=autos[1][i];
               modelo=autos[2][i];
               color=autos[3][i];
               categoria=autos[4][i];
               precio=autos[5][i];
               return true; 
              
            }
           
           
        }
        return false; 
         
    }

    @Override
    public boolean venderAuto(String nombre, String apellido, String cedula
            , String telefono, String placa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMarca() {
        return marca;
    }

    public  String getModelo() {
        return modelo;
    }

    public  String getColor() {
        return color;
    }

    public  String getPrecio() {
        return precio;
    }
}