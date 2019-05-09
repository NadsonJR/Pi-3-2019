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
public class Filial {
    private int IDFilial;
    private String CNPJ;
    private String Razao;
    private String CEP;
    private String Cidade;
    private String Estado;
    private String Endereco;
    private String Complemento;
    private String Contato;

    public Filial(String CNPJ, String Razao, String CEP, String Cidade, String Estado, String Endereco, String Complemento, String Contato) {
        this.CNPJ = CNPJ;
        this.Razao = Razao;
        this.CEP = CEP;
        this.Cidade = Cidade;
        this.Estado = Estado;
        this.Endereco = Endereco;
        this.Complemento = Complemento;
        this.Contato = Contato;
    }

    
    public int getIDFilial() {
        return IDFilial;
    }

    public void setIDFilial(int IDFilial) {
        this.IDFilial = IDFilial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(int String) {
        this.CNPJ = CNPJ;
    }

    public String getRazao() {
        return Razao;
    }

    public void setRazao(String Razao) {
        this.Razao = Razao;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public String getContato() {
        return Contato;
    }

    public void setContato(String Contato) {
        this.Contato = Contato;
    }
    
   
}
