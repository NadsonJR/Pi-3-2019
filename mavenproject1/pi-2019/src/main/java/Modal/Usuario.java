package Modal;

import java.io.Serializable;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Antonio
 */
public class Usuario implements Serializable {

    private Integer ID;
    private String Cargo;
    private String username;
    private String NomeFuncionario;
    private String Nascimento;
    private Integer CPF;
    private String Celular;
    private String Email;
    private String hashSenha;
    
    public Usuario( String nomeCompleto,String username, String senhaAberta, String nivel) {
        this.username = username;
        this.NomeFuncionario = nomeCompleto;
        setSenha(senhaAberta);
        this.Cargo = nivel;
    }
    
    public Usuario() {
    }
    
    public String getNomeFuncionario() {
        return NomeFuncionario;
    }

    public void setNomeFuncionario(String NomeFuncionario) {
        this.NomeFuncionario = NomeFuncionario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String nivel) {
        this.Cargo = nivel;
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
