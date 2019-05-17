/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author nadso
 */
public class Usuario {

    private int ID;
    private String Cargo;
    private String username;
    private String NomeFuncionario;
    private String Nascimento;
    private String CPF;
    private String Celular;
    private String Email;
    private String hashSenha;
    private int IDFilial;
    

    public Usuario(String NomeFuncionario, String CPF, String Nascimento, String Celular, String Email,int idFilial, String username, String senhaAberta, String Cargo) {
        this.IDFilial = idFilial;
        this.Cargo = Cargo;
        this.username = username;
        this.NomeFuncionario = NomeFuncionario;
        this.Nascimento = Nascimento;
        this.CPF = CPF;
        this.Celular = Celular;
        this.Email = Email;
        setSenha(senhaAberta);
    }

    public Usuario() {
    }
    
    public Integer getidFilial(){
        return IDFilial;
    }
    
    public void setidFilial(Integer IDFilial){
        this.IDFilial=IDFilial;
    }
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNomeFuncionario() {
        return NomeFuncionario;
    }

    public void setNomeFuncionario(String NomeFuncionario) {
        this.NomeFuncionario = NomeFuncionario;
    }

    public String getNascimento() {
        return Nascimento;
    }

    public void setNascimento(String Nascimento) {
        this.Nascimento = Nascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
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

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String senha) {
        this.hashSenha = senha;
    }

    public void setSenha(String senhaAberta) {
        this.hashSenha = BCrypt.hashpw(senhaAberta, BCrypt.gensalt());
    }

    public boolean validarSenha(String senhaAberta) {
        return BCrypt.checkpw(senhaAberta, hashSenha);
    }

    public boolean verificarPapel(String Cargos) {
        if (Cargo.contains(Cargos)) {
            return true;
        } else {
            return false;
        }
    }
}
