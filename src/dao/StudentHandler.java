/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bo.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.SQLUtil;

/**
 *
 * @author Pham Van Vung
 */
public class StudentHandler {

    private SQLUtil sqlUtil;

    public StudentHandler() {
        sqlUtil = new SQLUtil();
    }

    public int addStudent(String sName, String sAddress, int clsId, int stfId) {
        String stmStr = String.format("insert into Student(sName, sAddress, chId, stfId) values('%s', '%s', %d, %d)", sName, sAddress, clsId, stfId);
        return sqlUtil.executeUpdate(stmStr);
    }
    
    public List<Student> getStudents(String keyword){
        String stmStr = String.format("select * from Student where sName like '%s'", "%"+keyword+"%");
        List<Student> students = new ArrayList<>();
        ResultSet rs  = sqlUtil.executeQuery(stmStr);
        try {
            while(rs.next()){
                int sId = rs.getInt("sId");
                String sName = rs.getString("sName");
                String sAddress = rs.getString("sAddress");
                int chId = rs.getInt("chId");
                int stfId = rs.getInt("stfId");
                Student s = new Student(sId, sName, sAddress, chId, stfId);
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    public int deleteStudent(int sId){
        String stm = String.format("delete from student where sId = %d", sId);
        return sqlUtil.executeUpdate(stm);
    }
}
