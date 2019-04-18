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
    private String CEP;
    private String Telefone;
    private String Celular;
    private String Email;
    private boolean status;

    public int getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Cliente(String cep,String complemento, String endereco, String cidade, String estado, String nome, String sobrenome,String rg, String cpf,int Id, String dataNascimento, String Email, String Telefone, String Celular) {
        super(nome, sobrenome, cpf, rg, dataNascimento);
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
        this.ID = Id;
        this.Celular= Celular;
        this.Telefone = Telefone;
        this.Email = Email;
        this.CEP = cep;
        
    }
    

    public Cliente(String cep,String complemento, String endereco, String cidade, String estado, String nome, String sobrenome,String rg, String cpf,String dataNascimento, String Email, String Telefone, String Celular) {
        super(nome, sobrenome, cpf, rg, dataNascimento);
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
        this.Celular= Celular;
        this.Telefone = Telefone;
        this.Email = Email;
        this.CEP = cep;
        
    }

    public String getCEP() {
        return CEP;
    }

        public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
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
