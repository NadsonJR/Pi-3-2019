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
public class ItensCarrinho {
    private int IDLivro;
    private int Quantidade;
    private int IDcarrinho;
    private float Valor;

    public ItensCarrinho(int IDLivro, int Quantidade, int IDcarrinho, float Valor) {
        this.IDLivro = IDLivro;
        this.Quantidade = Quantidade;
        this.IDcarrinho = IDcarrinho;
        this.Valor = Valor;
    }

    public ItensCarrinho() {
        
    }

    public int getIDLivro() {
        return IDLivro;
    }

    public void setIDLivro(int IDLivro) {
        this.IDLivro = IDLivro;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public int getIDcarrinho() {
        return IDcarrinho;
    }

    public void setIDcarrinho(int IDcarrinho) {
        this.IDcarrinho = IDcarrinho;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }
    
    
}
