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
public class Cohort {

    private int chId;
    private String chName;

    public Cohort(int clsId, String clsName) {
        this.chId = clsId;
        this.chName = clsName;
    }

    public int getChId() {
        return chId;
    }

    public void setChId(int chId) {
        this.chId = chId;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    @Override
    public String toString() {
        return chName;
    }

}
