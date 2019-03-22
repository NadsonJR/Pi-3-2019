/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

/**
 *
 * @author mt12732
 */
public class Livro {
    private String NomeLivro;
    private String Autor;
    private String Editora;	
    private String Descricao;
    private float ValorVenda;
    private float ValorCusto;
    private String Categoria;
    private Integer ID;
    private Integer Quantidade;

    public String getNomeLivro() {
        return NomeLivro;
    }

    public void setNomeLivro(String NomeLivro) {
        this.NomeLivro = NomeLivro;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getEditora() {
        return Editora;
    }

    public void setEditora(String Editora) {
        this.Editora = Editora;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public float getValorVenda() {
        return ValorVenda;
    }

    public void setValorVenda(float ValorVenda) {
        this.ValorVenda = ValorVenda;
    }

    public float getValorCusto() {
        return ValorCusto;
    }

    public void setValorCusto(float ValorCusto) {
        this.ValorCusto = ValorCusto;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(Integer Quantidade) {
        this.Quantidade = Quantidade;
    }

    
    public Livro(String NomeLivro, String DescricaoLivro, String Autor, String Editora, float ValorVenda, float ValorCusto, String Categoria, int Quantidade ){
    this.Categoria = Categoria;
    this.NomeLivro = NomeLivro;
    this.Autor = Autor;
    this.Editora = Editora;
    this.Descricao = DescricaoLivro;
    this.ValorVenda = ValorVenda;
    this.ValorCusto = ValorCusto;
    this.Quantidade = Quantidade;
    }
}
