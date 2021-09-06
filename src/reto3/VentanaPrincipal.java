/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto3;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;





/**
 *
 * @author EDUARDO
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Tienda
     */
    
        
        private Tienda tienda;
    public VentanaPrincipal() {
        this.tienda = new Tienda();
        this.initComponents();
        this.setVisible(true);
        this.cargarDatosPrueba();
        this.actualizarTablaClientes();
        this.actualizarTablaProductos();
        this.actualizarTablaPedidos();
        habilitar_botones();
        
    }
    
    public void cargarDatosPrueba(){
        
        //Clientes
        Cuenta cuenta1 = new Cuenta("123",1000);
		Cuenta cuenta2 = new Cuenta("456",0);
		Cuenta cuenta3 = new Cuenta("789",100000);
		Cuenta cuenta4 = new Cuenta("101",0);
		Cuenta cuenta5 = new Cuenta("111",10000000);
		Cuenta cuenta6 = new Cuenta("121",0);
		
		//Definici�n de cuentas
		
		ArrayList<Cuenta> cuentas1 = new ArrayList<Cuenta>();
		ArrayList<Cuenta> cuentas2 = new ArrayList<Cuenta>();
		ArrayList<Cuenta> cuentas3 = new ArrayList<Cuenta>();
				
		//Asignaci�n de valores.
		
		
		cuentas3.add(cuenta5);
		
		cuentas2.add(cuenta6);
		cuentas1.add(cuenta5);
		cuentas1.add(cuenta2);
		
		//Clientes
		
		Cliente c1 = new Cliente("123","Edu","Bog","320","m@g.c",cuentas1);
		Cliente c2 = new Cliente("154","Rib","Cuc","321","n@g.c",cuentas2);
		Cliente c3 = new Cliente("168","Eto","Med","322","mo@g.c",cuentas3);
		Cliente c4 = new Cliente("198","fri","Cal","323","p@g.c",cuentas2);
		Cliente c5 = new Cliente("124","Des","Sol","324","m@g.c",cuentas1);
                
                
               this.tienda.getClientes().add(c1);
               this.tienda.getClientes().add(c2);
               this.tienda.getClientes().add(c3);
               this.tienda.getClientes().add(c4);
               this.tienda.getClientes().add(c5);
               
        //Productos
        
                Producto p1 = new Producto("1", 2000, 2500, 100, 20, true);
		Producto p2 = new Producto("2", 43100, 44000, 200, 120, true);
		Producto p3 = new Producto("3", 92000, 100000, 10, 2, true);
		Producto p4 = new Producto("4", 73000, 75000, 10, 2, true);
		Producto p5 = new Producto("5", 12000, 15000, 120, 50, true);
		Producto p6 = new Producto("6", 2000, 4000, 120, 20, true);
		Producto p7 = new Producto("7", 62000, 70000, 100, 20, true);
		Producto p8 = new Producto("8", 123000, 130000, 18, 4, true);
		Producto p9 = new Producto("9", 212000, 250000, 14, 4, true);
		Producto p10 = new Producto("10", 12000, 12500, 23, 7, true);
                
                
                this.tienda.getProductos().add(p1);
                this.tienda.getProductos().add(p2);
                this.tienda.getProductos().add(p3);
                this.tienda.getProductos().add(p4);
                this.tienda.getProductos().add(p5);
                this.tienda.getProductos().add(p6);
                this.tienda.getProductos().add(p7);
                this.tienda.getProductos().add(p8);
                this.tienda.getProductos().add(p9);
                this.tienda.getProductos().add(p10);
                
        //Pedidos
        
        //Subpedidos
		
		HashMap<Producto,Double> subpedidos1 = new HashMap();
			subpedidos1.put(p1, 2.0);
			subpedidos1.put(p2, 20.0);
			subpedidos1.put(p3, 10.0);
			subpedidos1.put(p4, 1.0);
			subpedidos1.put(p5, 12.0);
		
		//Pedidos
		
		Pedido ped1 = new Pedido(c1,subpedidos1,"Aprobado");
		
		HashMap<Producto,Double> subpedidos2 = new HashMap();
		subpedidos2.put(p1, 5.0);
		subpedidos2.put(p2, 10.0);
		subpedidos2.put(p5, 1.0);
		subpedidos2.put(p6, 1.0);
		subpedidos2.put(p8, 3.0);
	
		//Pedidos
	
		Pedido ped2 = new Pedido(c2,subpedidos2,"Aprobado");
		
		HashMap<Producto,Double> subpedidos3 = new HashMap();
		subpedidos3.put(p4, 5.0);
		subpedidos3.put(p7, 10.0);
		subpedidos3.put(p8, 1.0);
		subpedidos3.put(p9, 1.0);
		subpedidos3.put(p10, 3.0);
	
		//Pedidos
	
		Pedido ped3 = new Pedido(c4,subpedidos3,"Aprobado");
                
                this.tienda.getPedidos().add(ped1);
                this.tienda.getPedidos().add(ped2);
                this.tienda.getPedidos().add(ped3);
                
                
	
    }
    
    public void actualizarTablaClientes(){
        for(int i=0;i<this.tienda.clientes.size();i++){
            DefaultTableModel modelo = (DefaultTableModel) table_clientes.getModel();
        
            String[] registro = new String[5];
            
            registro[0] = tienda.clientes.get(i).identificacion;
            registro[1] = tienda.clientes.get(i).nombre;
            registro[2] = tienda.clientes.get(i).direccion;
            registro[3] = tienda.clientes.get(i).telefono;
            registro[4] = tienda.clientes.get(i).correo;

            modelo.addRow(registro);
            
            cb_clientes.addItem(tienda.clientes.get(i));
        }
    }
    
    public void actualizarTablaProductos(){
        for(int i=0;i<this.tienda.productos.size();i++){
            DefaultTableModel modelo = (DefaultTableModel) table_productos.getModel();
        
            String[] registro = new String[6];
            
            registro[0] = tienda.productos.get(i).codigo;
            registro[1] = tienda.productos.get(i).precio_compra+"";
            registro[2] = tienda.productos.get(i).precio_venta+"";
            registro[3] = tienda.productos.get(i).cantidad_bodega+"";
            registro[4] = tienda.productos.get(i).cantidad_minima+"";
            registro[5] = tienda.productos.get(i).IVA+"";

            modelo.addRow(registro);
        }
    }
    
    public void actualizarTablaPedidos(){
        for(int i=0;i<this.tienda.pedidos.size();i++){
            DefaultTableModel modelo = (DefaultTableModel) table_pedidos.getModel();
        
            String[] registro = new String[6];
            
            registro[0] = tienda.pedidos.get(i).cliente.identificacion;
            registro[1] = "DETALLES";
            registro[2] = tienda.pedidos.get(i).total_sin_iva+"";
            registro[3] = tienda.pedidos.get(i).total_con_iva+"";
            registro[4] = tienda.pedidos.get(i).estado;
           
            
            modelo.addRow(registro);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        tf_precio_venta = new javax.swing.JTextField();
        tf_precio_compra = new javax.swing.JTextField();
        tf_codigo_producto = new javax.swing.JTextField();
        tf_cantidad_requerida = new javax.swing.JTextField();
        tf_cantidad_minima = new javax.swing.JTextField();
        tf_iva = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_productos = new javax.swing.JTable();
        button_registrar_producto = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        button_buscar_producto = new javax.swing.JButton();
        button_editar_producto = new javax.swing.JButton();
        button_eliminar_producto = new javax.swing.JButton();
        button_cancelar_producto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_pedidos = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tf_nombre1 = new javax.swing.JTextField();
        button_registrar_pedido = new javax.swing.JButton();
        label_notificacion1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cb_clientes = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        tf_nombre = new javax.swing.JTextField();
        tf_correo = new javax.swing.JTextField();
        tf_direccion = new javax.swing.JTextField();
        tf_tel = new javax.swing.JTextField();
        button_registrar = new javax.swing.JButton();
        label_notificacion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        button_buscar_cliente = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_clientes = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tf_id1 = new javax.swing.JTextField();
        tf_nombre2 = new javax.swing.JTextField();
        tf_correo1 = new javax.swing.JTextField();
        tf_direccion1 = new javax.swing.JTextField();
        tf_tel1 = new javax.swing.JTextField();
        button_registrar1 = new javax.swing.JButton();
        label_notificacion2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        button_buscar_cliente1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        tf_id2 = new javax.swing.JTextField();
        tf_nombre_cliente2 = new javax.swing.JTextField();
        tf_correo2 = new javax.swing.JTextField();
        tf_direccion2 = new javax.swing.JTextField();
        tf_tel2 = new javax.swing.JTextField();
        button_registrar2 = new javax.swing.JButton();
        label_notificacion3 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        button_buscar_cliente2 = new javax.swing.JButton();
        button_cancelar_2 = new javax.swing.JButton();
        button_editar_2 = new javax.swing.JButton();
        button_eliminar2 = new javax.swing.JButton();

        jLabel16.setText("jLabel16");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(51, 51, 255));

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Eras Demi ITC", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Tienda Eduardo");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 0));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 102));

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));

        tf_precio_venta.setToolTipText("hola");

        tf_precio_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_precio_compraActionPerformed(evt);
            }
        });

        tf_codigo_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_codigo_productoActionPerformed(evt);
            }
        });

        tf_cantidad_requerida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cantidad_requeridaActionPerformed(evt);
            }
        });

        tf_cantidad_minima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cantidad_minimaActionPerformed(evt);
            }
        });

        tf_iva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ivaActionPerformed(evt);
            }
        });

        table_productos.setForeground(new java.awt.Color(0, 255, 0));
        table_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Precio Compra", "Precio venta", "Cantidad Bodega", "Cantidad minima", "IVA"
            }
        ));
        table_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_productosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_productos);

        button_registrar_producto.setBackground(new java.awt.Color(255, 255, 0));
        button_registrar_producto.setForeground(new java.awt.Color(0, 0, 204));
        button_registrar_producto.setText("REGISTRAR");
        button_registrar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_registrar_productoActionPerformed(evt);
            }
        });

        jLabel17.setText("Codigo");

        jLabel18.setText("Precio compra");

        jLabel19.setText("Precio venta");

        jLabel20.setText("Cantidad bodega");

        jLabel21.setText("Cantidad minima");

        jLabel22.setText("IVA");

        button_buscar_producto.setBackground(new java.awt.Color(255, 255, 0));
        button_buscar_producto.setForeground(new java.awt.Color(0, 0, 204));
        button_buscar_producto.setText("BUSCAR");
        button_buscar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_buscar_productoActionPerformed(evt);
            }
        });

        button_editar_producto.setBackground(new java.awt.Color(255, 255, 0));
        button_editar_producto.setForeground(new java.awt.Color(0, 0, 204));
        button_editar_producto.setText("EDITAR");
        button_editar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_editar_productoActionPerformed(evt);
            }
        });

        button_eliminar_producto.setBackground(new java.awt.Color(255, 255, 0));
        button_eliminar_producto.setForeground(new java.awt.Color(0, 0, 204));
        button_eliminar_producto.setText("ELIMINAR");
        button_eliminar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_eliminar_productoActionPerformed(evt);
            }
        });

        button_cancelar_producto.setBackground(new java.awt.Color(255, 255, 0));
        button_cancelar_producto.setForeground(new java.awt.Color(0, 0, 204));
        button_cancelar_producto.setText("CANCELAR");
        button_cancelar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelar_productoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(203, 203, 203)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tf_cantidad_minima, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                            .addComponent(tf_cantidad_requerida, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_precio_venta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_precio_compra, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_codigo_producto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_iva)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(button_registrar_producto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_buscar_producto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_editar_producto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_eliminar_producto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_cancelar_producto)))
                .addContainerGap(688, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_precio_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_precio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cantidad_requerida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cantidad_minima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_iva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_registrar_producto)
                    .addComponent(button_buscar_producto)
                    .addComponent(button_editar_producto)
                    .addComponent(button_eliminar_producto)
                    .addComponent(button_cancelar_producto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jScrollPane4.setViewportView(jPanel8);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Productos", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        table_pedidos.setForeground(new java.awt.Color(0, 255, 0));
        table_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id cliente", "Detalles Productos", "Total sin iva", "Total con iva", "Estado"
            }
        ));
        table_pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_pedidosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_pedidos);

        jLabel9.setText("Nuevo Pedido");

        tf_nombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombre1ActionPerformed(evt);
            }
        });

        button_registrar_pedido.setBackground(new java.awt.Color(255, 255, 0));
        button_registrar_pedido.setForeground(new java.awt.Color(0, 0, 204));
        button_registrar_pedido.setText("REGISTRAR");
        button_registrar_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_registrar_pedidoActionPerformed(evt);
            }
        });

        jLabel10.setText("Cliente");

        jLabel11.setText("Nombre");

        jLabel12.setText("Productos");

        cb_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_clientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(label_notificacion1))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(tf_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel11)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cb_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(button_registrar_pedido)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addGap(2, 2, 2)
                .addComponent(jLabel10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel11))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(button_registrar_pedido)
                .addGap(146, 146, 146)
                .addComponent(label_notificacion1)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pedidos", jPanel4);

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(664, 450));

        jLabel2.setText("Nuevo cliente");

        tf_id.setToolTipText("hola");

        tf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombreActionPerformed(evt);
            }
        });

        tf_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_correoActionPerformed(evt);
            }
        });

        tf_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_direccionActionPerformed(evt);
            }
        });

        tf_tel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_telActionPerformed(evt);
            }
        });

        button_registrar.setText("REGISTRAR");
        button_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_registrarActionPerformed(evt);
            }
        });

        jLabel3.setText("Identificación");

        jLabel5.setText("Nombre");

        jLabel6.setText("Dirección");

        jLabel7.setText("Telefono");

        jLabel8.setText("Correo");

        button_buscar_cliente.setText("BUSCAR");

        jButton2.setText("CANCELAR");

        jButton3.setText("EDITAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5)
                                .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addGap(83, 83, 83)
                                                        .addComponent(label_notificacion))
                                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(button_buscar_cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(button_registrar))))
                                    .addComponent(tf_correo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tf_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_registrar)
                    .addComponent(button_buscar_cliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_notificacion)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        table_clientes.setForeground(new java.awt.Color(0, 255, 0));
        table_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificación", "Nombre ", "Dirección", "Telefono", "Correo electronico"
            }
        ));
        table_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_clientes);

        jLabel4.setText("Nuevo cliente");

        tf_id1.setToolTipText("hola");

        tf_nombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombre2ActionPerformed(evt);
            }
        });

        tf_correo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_correo1ActionPerformed(evt);
            }
        });

        tf_direccion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_direccion1ActionPerformed(evt);
            }
        });

        tf_tel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_tel1ActionPerformed(evt);
            }
        });

        button_registrar1.setText("REGISTRAR");
        button_registrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_registrar1ActionPerformed(evt);
            }
        });

        jLabel13.setText("Identificación");

        jLabel14.setText("Nombre");

        jLabel15.setText("Dirección");

        jLabel23.setText("Telefono");

        jLabel24.setText("Correo");

        button_buscar_cliente1.setText("BUSCAR");

        jButton4.setText("CANCELAR");

        jButton5.setText("EDITAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel14)
                                .addComponent(tf_nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                                        .addGap(83, 83, 83)
                                                        .addComponent(label_notificacion2))
                                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(button_buscar_cliente1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(button_registrar1))))
                                    .addComponent(tf_correo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tf_direccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_direccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_correo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_registrar1)
                    .addComponent(button_buscar_cliente1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_notificacion2)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        tf_id2.setToolTipText("hola");
        tf_id2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_id2ActionPerformed(evt);
            }
        });

        tf_nombre_cliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombre_cliente2ActionPerformed(evt);
            }
        });

        tf_correo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_correo2ActionPerformed(evt);
            }
        });

        tf_direccion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_direccion2ActionPerformed(evt);
            }
        });

        tf_tel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_tel2ActionPerformed(evt);
            }
        });

        button_registrar2.setBackground(new java.awt.Color(255, 255, 0));
        button_registrar2.setForeground(new java.awt.Color(0, 0, 204));
        button_registrar2.setText("REGISTRAR");
        button_registrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_registrar2ActionPerformed(evt);
            }
        });

        jLabel26.setText("Identificación");

        jLabel27.setText("Nombre");

        jLabel28.setText("Dirección");

        jLabel29.setText("Telefono");

        jLabel30.setText("Correo");

        button_buscar_cliente2.setBackground(new java.awt.Color(255, 255, 0));
        button_buscar_cliente2.setForeground(new java.awt.Color(0, 0, 204));
        button_buscar_cliente2.setText("BUSCAR");
        button_buscar_cliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_buscar_cliente2ActionPerformed(evt);
            }
        });

        button_cancelar_2.setBackground(new java.awt.Color(255, 255, 0));
        button_cancelar_2.setForeground(new java.awt.Color(0, 0, 204));
        button_cancelar_2.setText("CANCELAR");
        button_cancelar_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelar_2ActionPerformed(evt);
            }
        });

        button_editar_2.setBackground(new java.awt.Color(255, 255, 0));
        button_editar_2.setForeground(new java.awt.Color(0, 0, 204));
        button_editar_2.setText("EDITAR");
        button_editar_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_editar_2ActionPerformed(evt);
            }
        });

        button_eliminar2.setBackground(new java.awt.Color(255, 255, 0));
        button_eliminar2.setForeground(new java.awt.Color(0, 0, 204));
        button_eliminar2.setText("ELIMINAR");
        button_eliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_eliminar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(tf_nombre_cliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(label_notificacion3))
                            .addComponent(tf_correo2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tf_direccion2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(button_buscar_cliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(button_registrar2))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(button_editar_2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button_eliminar2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(button_cancelar_2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_nombre_cliente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_direccion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_tel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_correo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_buscar_cliente2)
                    .addComponent(button_registrar2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_editar_2)
                    .addComponent(button_eliminar2))
                .addGap(2, 2, 2)
                .addComponent(button_cancelar_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_notificacion3)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clientes", jPanel2);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1087, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nombreActionPerformed

    private void tf_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_correoActionPerformed

    private void tf_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_direccionActionPerformed

    private void tf_telActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_telActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_telActionPerformed

    private void button_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_registrarActionPerformed
        String id = tf_id.getText();
        String nombre = tf_nombre.getText();
        String direccion = tf_direccion.getText();
        String telefono = tf_tel.getText();
        String correo = tf_correo.getText();
        ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
        Cliente nuevo_cliente = new Cliente(id,nombre,direccion,telefono,correo,cuentas);
        tienda.clientes.add(nuevo_cliente);
        
        label_notificacion.setText("Nuevo cliente agregado correctamente");
        DefaultTableModel modelo = (DefaultTableModel) table_clientes.getModel();
        
        String[] registro = new String[5];
        registro[0] = nuevo_cliente.identificacion;
        registro[1] = nuevo_cliente.nombre;
        registro[2] = nuevo_cliente.direccion;
        registro[3] = nuevo_cliente.telefono;
        registro[4] = nuevo_cliente.correo;
        
        modelo.addRow(registro);
        
        
        
    }//GEN-LAST:event_button_registrarActionPerformed

    private void tf_precio_compraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_precio_compraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_precio_compraActionPerformed

    private void tf_codigo_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_codigo_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_codigo_productoActionPerformed

    private void tf_cantidad_minimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cantidad_minimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cantidad_minimaActionPerformed

    private void tf_cantidad_requeridaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cantidad_requeridaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cantidad_requeridaActionPerformed

    private void tf_ivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ivaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ivaActionPerformed

    private void button_registrar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_registrar_productoActionPerformed
        String codigo = tf_codigo_producto.getText();
        double pc = Double.parseDouble(tf_precio_compra.getText());
        double pv = Double.parseDouble(tf_precio_venta.getText());
        double cb = Double.parseDouble(tf_cantidad_requerida.getText());
        double cmb = Double.parseDouble(tf_cantidad_minima.getText());
        boolean iva = true;
        if(tf_iva.getText().toLowerCase().equals("si")){
            iva = true;
        }else{
            iva = false;
        }
        
        //ArrayList<Producto> Listaproductos = new ArrayList<Cuenta>();
        Producto nuevo_producto = new Producto(codigo,pc,pv,cb,cmb,iva);
        tienda.productos.add(nuevo_producto);
        
        
        DefaultTableModel modelo = (DefaultTableModel) table_productos.getModel();
        
        String[] registro = new String[6];
        registro[0] = nuevo_producto.codigo;
        registro[1] = nuevo_producto.precio_compra+"";
        registro[2] = nuevo_producto.precio_venta+"";
        registro[3] = nuevo_producto.cantidad_bodega+"";
        registro[4] = nuevo_producto.cantidad_minima+"";
        registro[5] = nuevo_producto.IVA+"";
        
        modelo.addRow(registro);
        
    }//GEN-LAST:event_button_registrar_productoActionPerformed

    private void button_registrar_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_registrar_pedidoActionPerformed
        Cliente c = cb_clientes.getItemAt(cb_clientes.getSelectedIndex());
        //Subpedidos
		
        HashMap<Producto,Double> subpedidos1 = new HashMap();
			
		
		
		
	Pedido ped1 = new Pedido(c,subpedidos1,"aprobado");
        this.tienda.getPedidos().add(ped1);
        
        
        //Show
        
        label_notificacion.setText("Nuevo pedido agregado correctamente");
        DefaultTableModel modelo = (DefaultTableModel) table_pedidos.getModel();
        
        String[] registro = new String[5];
        registro[0] = ped1.cliente.identificacion;
        registro[1] = "DETALLES";
        registro[2] = ped1.total_sin_iva+"";
        registro[3] = ped1.total_con_iva+"";
        registro[4] = ped1.estado;
        
        modelo.addRow(registro);
        
        
    }//GEN-LAST:event_button_registrar_pedidoActionPerformed

    private void tf_nombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nombre1ActionPerformed

    private void cb_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_clientesActionPerformed
        
       //
    }//GEN-LAST:event_cb_clientesActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tf_nombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nombre2ActionPerformed

    private void tf_correo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_correo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_correo1ActionPerformed

    private void tf_direccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_direccion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_direccion1ActionPerformed

    private void tf_tel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_tel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_tel1ActionPerformed

    private void button_registrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_registrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_registrar1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tf_nombre_cliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombre_cliente2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nombre_cliente2ActionPerformed

    private void tf_correo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_correo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_correo2ActionPerformed

    private void tf_direccion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_direccion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_direccion2ActionPerformed

    private void tf_tel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_tel2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_tel2ActionPerformed

    private void button_registrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_registrar2ActionPerformed
        String id = tf_id2.getText();
        String nombre = tf_nombre_cliente2.getText();
        String direccion = tf_direccion2.getText();
        String telefono = tf_tel2.getText();
        String correo = tf_correo2.getText();
        ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
        Cliente nuevo_cliente = new Cliente(id,nombre,direccion,telefono,correo,cuentas);
        tienda.clientes.add(nuevo_cliente);
        
        label_notificacion.setText("Nuevo cliente agregado correctamente");
        DefaultTableModel modelo = (DefaultTableModel) table_clientes.getModel();
        
        String[] registro = new String[5];
        registro[0] = nuevo_cliente.identificacion;
        registro[1] = nuevo_cliente.nombre;
        registro[2] = nuevo_cliente.direccion;
        registro[3] = nuevo_cliente.telefono;
        registro[4] = nuevo_cliente.correo;
        
        modelo.addRow(registro);
    }//GEN-LAST:event_button_registrar2ActionPerformed

    private void button_editar_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_editar_2ActionPerformed
        //Editar cliente
        Cliente cliente_seleccionado = this.tienda.getClientes().get(table_clientes.getSelectedRow());
        System.out.println(cliente_seleccionado);
        
        
        String id =  tf_id2.getText(); //producto_seleccionado.getCodigo();
        String nombre = tf_nombre_cliente2.getText();//producto_seleccionado.getPrecio_compra()+"";
        String telefono =  tf_tel2.getText(); //producto_seleccionado.getPrecio_venta()+"";
        String direccion = tf_direccion2.getText();// producto_seleccionado.getCantidad_bodega()+"";
        String correo = tf_correo2.getText(); //producto_seleccionado.getCantidad_minima()+"";
        
        
        int index = this.tienda.getClientes().indexOf(cliente_seleccionado);
        
        this.tienda.clientes.get(index).setIdentificacion(id);
        this.tienda.clientes.get(index).setNombre(nombre);
        this.tienda.clientes.get(index).setTelefono(telefono);
        this.tienda.clientes.get(index).setDireccion(direccion);
        this.tienda.clientes.get(index).setCorreo(correo);
        
        
        DefaultTableModel modelo = (DefaultTableModel) table_clientes.getModel();
        modelo.removeRow(index);
        
        String[] registro = new String[5];
        registro[0] = this.tienda.clientes.get(index).getIdentificacion();
        registro[1] = this.tienda.clientes.get(index).getNombre();
        registro[2] = this.tienda.clientes.get(index).getTelefono();
        registro[3] = this.tienda.clientes.get(index).getDireccion();
        registro[4] = this.tienda.clientes.get(index).getCorreo();
       
        modelo.addRow(registro);
    }//GEN-LAST:event_button_editar_2ActionPerformed

    private void button_buscar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_buscar_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_buscar_productoActionPerformed

    private void button_eliminar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_eliminar_productoActionPerformed
        Producto producto_seleccionado = this.tienda.getProductos().get(table_productos.getSelectedRow());
        String codigo = producto_seleccionado.getCodigo();
        for(int i=0;i<this.tienda.getProductos().size();i++){
            if(producto_seleccionado.codigo.equals(this.tienda.getProductos().get(i).codigo)){
                this.tienda.getProductos().remove(i);
                
                //Delete modelTABLE
                 DefaultTableModel modelo = (DefaultTableModel) table_productos.getModel();
                 modelo.removeRow(i);
               
                System.out.println("Si se eliminó");
            }
            System.out.println("No se eliminó");
            //System.out.println(producto_seleccionado.codigo);
            //System.out.println(this.tienda.getProductos().get(i));
        }
    }//GEN-LAST:event_button_eliminar_productoActionPerformed

    private void table_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_productosMouseClicked
        Producto producto_seleccionado = this.tienda.getProductos().get(table_productos.getSelectedRow());
        String codigo = producto_seleccionado.getCodigo();
        String precio_compra = producto_seleccionado.getPrecio_compra()+"";
        String precio_venta = producto_seleccionado.getPrecio_venta()+"";
        String cantidad_bodega = producto_seleccionado.getCantidad_bodega()+"";
        String cantidad_minima = producto_seleccionado.getCantidad_minima()+"";
        String iva = producto_seleccionado.IVA+"";
        
        tf_codigo_producto.setText(codigo);
        tf_precio_compra.setText(precio_compra);
        tf_precio_venta.setText(precio_venta);
        tf_cantidad_requerida.setText(cantidad_bodega);
        tf_cantidad_minima.setText(cantidad_minima);
        tf_iva.setText(iva);
        
        deshabilitar_botones();
        
        
        
    }//GEN-LAST:event_table_productosMouseClicked

    private void button_cancelar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelar_productoActionPerformed
        vaciar_tabla_productos();
        habilitar_botones();
        
    }//GEN-LAST:event_button_cancelar_productoActionPerformed

    private void button_editar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_editar_productoActionPerformed
        Producto producto_seleccionado = this.tienda.getProductos().get(table_productos.getSelectedRow());
        System.out.println(producto_seleccionado);
        
        
        String codigo =  tf_codigo_producto.getText(); //producto_seleccionado.getCodigo();
        String precio_compra = tf_precio_compra.getText();//producto_seleccionado.getPrecio_compra()+"";
        String precio_venta =  tf_precio_venta.getText(); //producto_seleccionado.getPrecio_venta()+"";
        String cantidad_bodega = tf_cantidad_requerida.getText();// producto_seleccionado.getCantidad_bodega()+"";
        String cantidad_minima = tf_cantidad_minima.getText(); //producto_seleccionado.getCantidad_minima()+"";
        String iva = tf_iva.getText(); //producto_seleccionado.IVA+"";
        
        int index = this.tienda.getProductos().indexOf(producto_seleccionado);
        
        this.tienda.productos.get(index).setCodigo(codigo);
        this.tienda.productos.get(index).setPrecio_compra(Double.parseDouble(precio_compra));
        this.tienda.productos.get(index).setPrecio_venta(Double.parseDouble(precio_venta));
        this.tienda.productos.get(index).setCantidad_bodega(Double.parseDouble(cantidad_bodega));
        this.tienda.productos.get(index).setCantidad_minima(Double.parseDouble(cantidad_minima));
        this.tienda.productos.get(index).setIVA(Boolean.parseBoolean(iva));
        
        DefaultTableModel modelo = (DefaultTableModel) table_productos.getModel();
        modelo.removeRow(index);
        
        String[] registro = new String[6];
        registro[0] = this.tienda.productos.get(index).getCodigo();
        registro[1] = this.tienda.productos.get(index).getPrecio_compra()+"";
        registro[2] = this.tienda.productos.get(index).getPrecio_venta()+"";
        registro[3] = this.tienda.productos.get(index).getCantidad_bodega()+"";
        registro[4] = this.tienda.productos.get(index).getCantidad_minima()+"";
        registro[5] = this.tienda.productos.get(index).IVA+"";
        
        modelo.addRow(registro);
    }//GEN-LAST:event_button_editar_productoActionPerformed

    private void button_buscar_cliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_buscar_cliente2ActionPerformed
        System.out.println("Buscar");
    }//GEN-LAST:event_button_buscar_cliente2ActionPerformed

    private void table_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_clientesMouseClicked
        Cliente cliente_seleccionado = this.tienda.getClientes().get(table_clientes.getSelectedRow());
        
        
        String id = cliente_seleccionado.getIdentificacion();
        String nombre  = cliente_seleccionado.getNombre();
        String telefono  = cliente_seleccionado.getTelefono();
        String direccion  = cliente_seleccionado.getDireccion();
        String correo  = cliente_seleccionado.getCorreo();
        
        tf_id2.setText(id);
        tf_nombre_cliente2.setText(nombre);
        tf_tel2.setText(telefono);
        tf_direccion2.setText(direccion);
        tf_correo2.setText(correo);
        
        
        deshabilitar_botones_cliente();
    }//GEN-LAST:event_table_clientesMouseClicked

    private void button_eliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_eliminar2ActionPerformed
        //Eliminar cliente
        
        Cliente cliente_seleccionado = this.tienda.getClientes().get(table_clientes.getSelectedRow());
        String id = cliente_seleccionado.getIdentificacion();
        for(int i=0;i<this.tienda.getClientes().size();i++){
            if(cliente_seleccionado.identificacion.equals(this.tienda.getClientes().get(i).identificacion)){
                this.tienda.getClientes().remove(i);
                
                //Delete modelTABLE
                 DefaultTableModel modelo = (DefaultTableModel) table_clientes.getModel();
                 modelo.removeRow(i);
               
                System.out.println("Si se eliminó");
            }
            System.out.println("No se eliminó");
            //System.out.println(producto_seleccionado.codigo);
            //System.out.println(this.tienda.getProductos().get(i));
        }
        
    }//GEN-LAST:event_button_eliminar2ActionPerformed

    private void button_cancelar_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelar_2ActionPerformed
        vaciar_tabla_clientes();
        habilitar_botones_cliente();
    }//GEN-LAST:event_button_cancelar_2ActionPerformed

    private void tf_id2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_id2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_id2ActionPerformed

    private void table_pedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_pedidosMouseClicked
        //Tabla pedidos.
        Pedido pedido_seleccionado = this.tienda.getPedidos().get(table_pedidos.getSelectedRow());
        
        
        String id_cliente = pedido_seleccionado.getCliente().identificacion;
        String detalles  = "Detalles";
        String total_sin_iva = pedido_seleccionado.getTotal_sin_iva()+"";
        String total_con_iva  = pedido_seleccionado.getTotal_con_iva()+"";
        String estado = pedido_seleccionado.getEstado();
        
        //Cliente c = cb_clientes.getItemAt(cb_clientes.getSelectedIndex());
        
        
        String informe = pedido_seleccionado.generarInforme();
        
        DetallesPedido detallePedido = new DetallesPedido();
        detallePedido.setDetalles(informe);
        detallePedido.setVisible(true);
        
        
        
        
        deshabilitar_botones_cliente();
        
        
    }//GEN-LAST:event_table_pedidosMouseClicked
    //start new code
    public void vaciar_tabla_productos(){
        tf_cantidad_minima.setText("");
        tf_precio_compra.setText("");
        tf_precio_venta.setText("");
        tf_cantidad_requerida.setText("");
        tf_codigo_producto.setText("");
        tf_iva.setText("");
    }
    
    public void vaciar_tabla_clientes(){
        tf_id2.setText("");
        tf_nombre_cliente2.setText("");
        tf_tel2.setText("");
        tf_direccion2.setText("");
        tf_correo2.setText("");
    }
    //end new code
    public void habilitar_botones(){
        button_cancelar_producto.setEnabled(false);
        button_registrar_producto.setEnabled(true);
        button_editar_producto.setEnabled(false);
        button_buscar_producto.setEnabled(true);
        button_eliminar_producto.setEnabled(false);
    }
    
    public void deshabilitar_botones(){
        button_cancelar_producto.setEnabled(true);
        button_registrar_producto.setEnabled(false);
        button_editar_producto.setEnabled(true);
        button_buscar_producto.setEnabled(false);
        button_eliminar_producto.setEnabled(true);
    }
    
    public void habilitar_botones_cliente(){
        button_cancelar_2.setEnabled(false);
        button_registrar2.setEnabled(true);
        button_editar_2.setEnabled(false);
        button_buscar_cliente2.setEnabled(true);
        button_eliminar2.setEnabled(false);
    }
    
    public void deshabilitar_botones_cliente(){
        button_cancelar_2.setEnabled(true);
        button_registrar2.setEnabled(false);
        button_editar_2.setEnabled(true);
        button_buscar_cliente2.setEnabled(false);
        button_eliminar2.setEnabled(true);
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton button_buscar_cliente;
    private javax.swing.JButton button_buscar_cliente1;
    private javax.swing.JButton button_buscar_cliente2;
    private javax.swing.JButton button_buscar_producto;
    private javax.swing.JButton button_cancelar_2;
    private javax.swing.JButton button_cancelar_producto;
    private javax.swing.JButton button_editar_2;
    private javax.swing.JButton button_editar_producto;
    private javax.swing.JButton button_eliminar2;
    private javax.swing.JButton button_eliminar_producto;
    private javax.swing.JButton button_registrar;
    private javax.swing.JButton button_registrar1;
    private javax.swing.JButton button_registrar2;
    private javax.swing.JButton button_registrar_pedido;
    private javax.swing.JButton button_registrar_producto;
    private javax.swing.JComboBox<Cliente> cb_clientes;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label_notificacion;
    private javax.swing.JLabel label_notificacion1;
    private javax.swing.JLabel label_notificacion2;
    private javax.swing.JLabel label_notificacion3;
    private javax.swing.JTable table_clientes;
    private javax.swing.JTable table_pedidos;
    private javax.swing.JTable table_productos;
    private javax.swing.JTextField tf_cantidad_minima;
    private javax.swing.JTextField tf_cantidad_requerida;
    private javax.swing.JTextField tf_codigo_producto;
    private javax.swing.JTextField tf_correo;
    private javax.swing.JTextField tf_correo1;
    private javax.swing.JTextField tf_correo2;
    private javax.swing.JTextField tf_direccion;
    private javax.swing.JTextField tf_direccion1;
    private javax.swing.JTextField tf_direccion2;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_id1;
    private javax.swing.JTextField tf_id2;
    private javax.swing.JTextField tf_iva;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JTextField tf_nombre1;
    private javax.swing.JTextField tf_nombre2;
    private javax.swing.JTextField tf_nombre_cliente2;
    private javax.swing.JTextField tf_precio_compra;
    private javax.swing.JTextField tf_precio_venta;
    private javax.swing.JTextField tf_tel;
    private javax.swing.JTextField tf_tel1;
    private javax.swing.JTextField tf_tel2;
    // End of variables declaration//GEN-END:variables
}
