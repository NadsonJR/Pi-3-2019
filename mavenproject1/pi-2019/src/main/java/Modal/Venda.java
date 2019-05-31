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
    private String DataVenda;
    private float Valor;
    private String FormaPagamento;
    private String NomeCliente;

    public Venda(int IDCliente, int IDVenda, String DataVenda, float Valor, String FormaPagamento, String NomeCliente) {
        this.IDCliente = IDCliente;
        this.IDVenda = IDVenda;
        this.DataVenda = DataVenda;
        this.Valor = Valor;
        this.FormaPagamento = FormaPagamento;
        this.NomeCliente = NomeCliente;
    }

    public Venda() {
        
    }

    
    
    
    
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

    public String getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(String DataVenda) {
        this.DataVenda = DataVenda;
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

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }
    
    

   
    
    
    
    
     
}
