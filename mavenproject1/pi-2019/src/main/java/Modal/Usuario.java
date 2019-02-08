package Modal;


/**
 *
 * @author Matheus
 */
public class Usuario extends Pessoa {
    private Integer ID;
    private String nivel;
    private String username;
    private String senha;

    public Usuario(String nome, String senhaAberta) {
        super.getNome();
        setSenha(senhaAberta);

    }

    public Usuario(String nivel, String nome, String cpf, String rg, String sobrenome, String ID) {
        super(nome, sobrenome, cpf, rg);
        this.nivel = nivel;
        
    }

    public Usuario() {
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


    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
