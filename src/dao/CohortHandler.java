/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bo.Cohort;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.SQLUtil;

/**
 *
 * @author Pham Van Vung
 */
public class CohortHandler {
    private SQLUtil sqlUtil;
    public CohortHandler() {
        sqlUtil = new SQLUtil();
    }
    public List<Cohort> loadStudents() {
        List<Cohort> scs = new ArrayList<>();
        try {
            String stmStr = "select * from Cohort";
            ResultSet rsCohorts = sqlUtil.executeQuery(stmStr);
            while (rsCohorts.next()) {
                int chId = rsCohorts.getInt("chId");
                String chName = rsCohorts.getString("chName");
                Cohort sc = new Cohort(chId, chName);
                scs.add(sc);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return scs;
    }
    
}
