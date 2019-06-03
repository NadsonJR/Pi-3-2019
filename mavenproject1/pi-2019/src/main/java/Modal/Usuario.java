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
    private String Senha;
    private String Filial;

    public Usuario(int ID, String Cargo, String username, String NomeFuncionario, String Nascimento, String CPF, String Celular, String Email, String Senha, String Filial) {
        this.ID = ID;
        this.Cargo = Cargo;
        this.username = username;
        this.NomeFuncionario = NomeFuncionario;
        this.Nascimento = Nascimento;
        this.CPF = CPF;
        this.Celular = Celular;
        this.Email = Email;
        this.Senha = Senha;
        this.Filial = Filial;
    }
    
     public Usuario(String NomeFuncionario,String CPF, String Nascimento,String Celular,String Email, String Filial,String username, String Senha,String Cargo) {
        this.Cargo = Cargo;
        this.username = username;
        this.NomeFuncionario = NomeFuncionario;
        this.Nascimento = Nascimento;
        this.CPF = CPF;
        this.Celular = Celular;
        this.Email = Email;
        this.Senha = Senha;
        this.Filial = Filial;
    }
    
    
    public Usuario() {
    }
    
    public String getFilial(){
        return Filial;
    }
    
    public void setFilial(String Filial){
        this.Filial=Filial;
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
        return Senha;
    }

    public void setSenha(String senha) {
        this.Senha = senha;
    }

    
    public boolean validarSenha(String senha) {
        if (senha.equals(Senha)){
        return true;
    }
        return false;
    }

    public boolean verificarPapel(String Cargos) {
        if (Cargo.contains(Cargos)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + "ID=" + ID + ", Cargo=" + Cargo + ", username=" + username + ", NomeFuncionario=" + NomeFuncionario + ", Nascimento=" + Nascimento + ", CPF=" + CPF + ", Celular=" + Celular + ", Email=" + Email + ", Senha=" + Senha + ", Filial=" + Filial + '}';
    }
    
    
    
    
}
