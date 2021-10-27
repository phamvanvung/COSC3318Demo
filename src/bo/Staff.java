/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

/**
 *
 * @author Pham Van Vung
 */
public class Staff {
    private int stfId;
    private String stfName;

    public Staff(int stfId, String stfName) {
        this.stfId = stfId;
        this.stfName = stfName;
    }

    public int getStfId() {
        return stfId;
    }

    public void setStfId(int stfId) {
        this.stfId = stfId;
    }

    public String getStfName() {
        return stfName;
    }

    public void setStfName(String stfName) {
        this.stfName = stfName;
    }
    
}
