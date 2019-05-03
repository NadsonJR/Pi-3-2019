/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

/**
 *
 * @author vitor.rsilva16
 */
public class Relatorio {
    private String Nome;
    private int IDRelatorio;
    private String DataVenda;
    private float valor;
    private String DescricaoPagamento;

    public Relatorio(String Nome, int IDRelatorio, String DataVenda, float valor, String DescricaoPagamento) {
        this.Nome = Nome;
        this.IDRelatorio = IDRelatorio;
        this.DataVenda = DataVenda;
        this.valor = valor;
        this.DescricaoPagamento = DescricaoPagamento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getIDRelatorio() {
        return IDRelatorio;
    }

    public void setIDRelatorio(int IDRelatorio) {
        this.IDRelatorio = IDRelatorio;
    }

    public String getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(String DataVenda) {
        this.DataVenda = DataVenda;
    }

    public String getDescricaoPagamento() {
        return DescricaoPagamento;
    }

    public void setDescricaoPagamento(String DescricaoPagamento) {
        this.DescricaoPagamento = DescricaoPagamento;
    }
    
    
    
}
