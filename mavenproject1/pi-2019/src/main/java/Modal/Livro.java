/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

import java.util.Date;

/**
 *
 * @author mt12732
 */
public class Livro {
    private String nomelivro;
    private String Autor;
    private String Editora;	
    private String Descricao;
    private float ValorVenda;
    private float ValorCusto;
    private String Categoria;
    private Integer ID;
    private Integer Quantidade;
    private String DataCadastro;

    public String getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(String DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public String getNomeLivro() {
        return nomelivro;
    }

    public void setNomeLivro(String NomeLivro) {
        this.nomelivro = NomeLivro;
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

    
    public Livro(String NomeLivro, String DescricaoLivro, String Autor, String Editora, float ValorVenda, float ValorCusto, String Categoria, int Quantidade, String DataCadastro ){
    this.Categoria = Categoria;
    this.nomelivro = NomeLivro;
    this.Autor = Autor;
    this.Editora = Editora;
    this.Descricao = DescricaoLivro;
    this.ValorVenda = ValorVenda;
    this.ValorCusto = ValorCusto;
    this.Quantidade = Quantidade;
    this.DataCadastro =  DataCadastro;
    }
    
        public Livro(String NomeLivro, String DescricaoLivro, String Autor, String Editora, float ValorVenda, float ValorCusto, String Categoria, int Quantidade, String DataCadastro, int id ){
    this.Categoria = Categoria;
    this.nomelivro = NomeLivro;
    this.Autor = Autor;
    this.Editora = Editora;
    this.Descricao = DescricaoLivro;
    this.ValorVenda = ValorVenda;
    this.ValorCusto = ValorCusto;
    this.Quantidade = Quantidade;
    this.DataCadastro =  DataCadastro;
    this.ID = id;
    }

    public Livro(String nomelivro, String Autor, String Editora,float ValorVenda,Integer ID, Integer Quantidade) {
        this.nomelivro = nomelivro;
        this.Autor = Autor;
        this.Editora = Editora;
        this.ValorVenda = ValorVenda;
        this.ID = ID;
        this.Quantidade = Quantidade;
    }
    
        
}
