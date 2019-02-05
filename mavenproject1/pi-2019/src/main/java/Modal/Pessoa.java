/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

/**
 *
 * @author Matheus
 */
public abstract class Pessoa {
   
    private String nome;
    private String sobrenome;
    private String cpf;
    private String rg;

    public Pessoa(String nome, String sobrenome,  String cpf, String rg) {
        this.sobrenome = sobrenome;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Pessoa() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    
}