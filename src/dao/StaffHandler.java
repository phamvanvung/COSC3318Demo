/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bo.Staff;
import java.sql.ResultSet;
import utils.SQLUtil;

/**
 *
 * @author Pham Van Vung
 */
public class StaffHandler {

    private SQLUtil sqlUtil;

    public StaffHandler() {
        this.sqlUtil = new SQLUtil();
    }

    public Staff login(String username, String password) {
        Staff stf = null;
        String stm = String.format("select stfId, stfName from Staff where stfUsername='%s' and stfPassword='%s'", username, password);
        ResultSet rsStaff = sqlUtil.executeQuery(stm);
        try {
            if (rsStaff!=null && rsStaff.next()) {
                int stfId = rsStaff.getInt("stfId");
                String stfName = rsStaff.getString("stfName");
                stf = new Staff(stfId, stfName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return stf;
    }
}
