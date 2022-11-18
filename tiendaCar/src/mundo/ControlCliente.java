/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author stiver
 */
public class ControlCliente implements ControlTabla{

    
    /*-----------------------
    *   Atributos
    *------------------------*/
    
    
    static String[][] clientes=new String[5][100];
    
    private static ControlCliente instancia;
    int cantidadRegistro=0;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String placa;
    private String cantidad;
    
    /*-----------------------------
    * Metodos
    *---------------------------------*/
    
    
    public static ControlCliente getInstance(){
        if(instancia == null)
            instancia = new ControlCliente();
        return instancia;
    }
    private ControlCliente() {
        
    }
    
    
   public DefaultTableModel Mostrar() {
       
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("cedula");
        modelo.addColumn("nombre");
        modelo.addColumn("apellido");
        modelo.addColumn("telefono");
        modelo.addColumn("placa automovil");
        
        
        
        for(int i=0;i<100;i++){
            String[] cliente=new String[5];
            for(int j=0;j<5;j++){
                
                if(clientes[j][i] != null)
                    cliente[j]=clientes[j][i];
                    
                    
            }
            modelo.addRow(cliente);
        }
        return modelo;
    }

    @Override
    public boolean Guardar(String nombreCategoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean GuardarAuto(String placa, String marca, String modelo, String color, String nombreCategoria, String precio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean venderAuto(String nombre, String apellido, String cedula, 
            String telefono, String placa) {
        clientes[0][cantidadRegistro]=cedula;
        clientes[1][cantidadRegistro]=nombre;
        clientes[2][cantidadRegistro]=apellido;
        clientes[3][cantidadRegistro]=telefono;
        clientes[4][cantidadRegistro]=placa;
     
        cantidadRegistro++;
        
        return true;   
    }

    @Override
    public void Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public boolean verificarcliente(String cedula)
    {
        
        for (int i=0;i<100;i++)
        {
            if(clientes[0][i].equals(cedula))
            {
               nombres=clientes[1][i];
               apellidos=clientes[2][i];
               telefono=clientes[3][i];
               placa=clientes[4][i];
               
               return true; 
              
            }
           
           
        }
        return false; 
         
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCantidad() {
        return cantidad;
    }
      
}