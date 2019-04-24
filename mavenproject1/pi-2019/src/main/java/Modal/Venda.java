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
     
    private int IDCliente;
    private int IDVenda;
    private Date DataVenda;
    private int IDLivro;
    private int QuantidadeLivro;
    private float Valor;
    private String FormaPagamento;

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public int getIDVenda() {
        return IDVenda;
    }

    public void setIDVenda(int IDVenda) {
        this.IDVenda = IDVenda;
    }

    public Date getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(Date DataVenda) {
        this.DataVenda = DataVenda;
    }

    public int getIDLivro() {
        return IDLivro;
    }

    public void setIDLivro(int IDLivro) {
        this.IDLivro = IDLivro;
    }

    public int getQuantidadeLivro() {
        return QuantidadeLivro;
    }

    public void setQuantidadeLivro(int QuantidadeLivro) {
        this.QuantidadeLivro = QuantidadeLivro;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }

    public String getFormaPagamento() {
        return FormaPagamento;
    }

    public void setFormaPagamento(String FormaPagamento) {
        this.FormaPagamento = FormaPagamento;
    }

    public Venda(int IDCliente, int IDVenda, Date DataVenda, int IDLivro, int QuantidadeLivro, float Valor, String FormaPagamento) {
        this.IDCliente = IDCliente;
        this.IDVenda = IDVenda;
        this.DataVenda = DataVenda;
        this.IDLivro = IDLivro;
        this.QuantidadeLivro = QuantidadeLivro;
        this.Valor = Valor;
        this.FormaPagamento = FormaPagamento;
    }
    
    
    
    
     
}
