/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

/**
 *
 * @author nadso
 */
public class Cliente extends Pessoa {
    private String endereco;
    private String complemento;
    private String cidade;
    private String estado;
    private Integer ID;

    public int getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Cliente(String complemento, String endereco, String cidade, String estado, String nome, String sobrenome,String rg, String cpf,int Id) {
        super(nome, sobrenome, cpf, rg);
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
        this.ID = Id;
        
    }

    public Cliente(String complemento, String endereco, String cidade, String estado, String nome, String sobrenome,String rg, String cpf) {
        super(nome, sobrenome, cpf, rg);
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
        
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
