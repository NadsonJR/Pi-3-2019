/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

import java.util.Date;
import java.util.List;

/**
 *
 * @author mt12732
 */
public class Venda {
     private int idVenda;
     private Date DataCadastroVenda;
     private List IDLivro;
     private String tipoPagamento;
     private float ValorVenda;
     private String NomeCliente;
     private int IDcliente;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
    public Date getDataCadastroVenda() {
        return DataCadastroVenda;
    }

    public void setDataCadastroVenda(Date DataCadastroVenda) {
        this.DataCadastroVenda = DataCadastroVenda;
    }

    public List getIDLivro() {
        return IDLivro;
    }

    public void setIDLivro(List IDLivro) {
        this.IDLivro = IDLivro;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public float getValorVenda() {
        return ValorVenda;
    }

    public void setValorVenda(float ValorVenda) {
        this.ValorVenda = ValorVenda;
    }

    public int getIDcliente() {
        return IDcliente;
    }

    public void setIDcliente(int IDcliente) {
        this.IDcliente = IDcliente;
    }

    public Venda(int idVenda, Date DataCadastroVenda, List IDLivro, String tipoPagamento, float ValorVenda, int IDcliente) {
        this.idVenda = idVenda;
        this.DataCadastroVenda = DataCadastroVenda;
        this.IDLivro = IDLivro;
        this.tipoPagamento = tipoPagamento;
        this.ValorVenda = ValorVenda;
        this.IDcliente = IDcliente;
    }
     
}
