/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

/**
 *
 * @author antonio.ncgjunior
 */
public class Cargos {
    private int idCargo;
    private String NomeCargo;

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getNomeCargo() {
        return NomeCargo;
    }

    public void setNomeCargo(String NomeCargo) {
        this.NomeCargo = NomeCargo;
    }

    public Cargos(int idCargo, String NomeCargo) {
        this.idCargo = idCargo;
        this.NomeCargo = NomeCargo;
    }
    
    
}
