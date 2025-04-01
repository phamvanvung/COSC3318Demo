/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pham Van Vung
 */
public class SQLUtil implements AutoCloseable {

    private Connection con;
    private Statement stm;

    private Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/studentdb?allowMultiQueries=true";
                String username = "root";
                String password = "pass";
                try {
                    con = DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    private Statement getStatement() {
        if (stm == null) {
            try {
                stm = getConnection().createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return stm;
    }

    public int executeUpdate(String stmStr) {
        int ret = 0;
        try {
            ret = getStatement().executeUpdate(stmStr);
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    public ResultSet executeQuery(String queryStr){
        ResultSet ret = null;
        try {
            ret = getStatement().executeQuery(queryStr);
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    public void closeConnection() {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
    
//    @Override
//    protected void finalize() throws Throwable {
//        closeConnection();
//        super.finalize(); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void close() throws Exception {
        closeConnection();
    }
    

}
