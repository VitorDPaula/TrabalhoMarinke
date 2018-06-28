/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Hardware;

/**
 *
 * @author Vitor D'Paula
 */
public class HardDAO {
    
    public void create(Hardware h){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO super_hardware (hardware, marca, preco, quantidade) VALUES(?,?,?,?)");
            stmt.setString(1, h.getHardware());
            stmt.setString(2, h.getMarca());
            stmt.setFloat(3, h.getPreco());
            stmt.setInt(4, h.getQuantidade());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar." + ex);
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
            
        }
    }
}
