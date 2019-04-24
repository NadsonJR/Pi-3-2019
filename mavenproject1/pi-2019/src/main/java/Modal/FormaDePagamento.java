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
public class FormaDePagamento {
    private int IdPagamento;
    private String Descricao;

    public int getIdPagamento() {
        return IdPagamento;
    }

    public void setIdPagamento(int IdPagamento) {
        this.IdPagamento = IdPagamento;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public FormaDePagamento(int IdPagamento, String Descricao) {
        this.IdPagamento = IdPagamento;
        this.Descricao = Descricao;
    }
    
    
}
