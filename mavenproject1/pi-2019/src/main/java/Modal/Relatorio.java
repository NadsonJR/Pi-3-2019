/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Adaulan
 */
public class Relatorio {

    private int IDVenda;
    private String nomeCliente;
    private String dataVenda;
    private String nomeLivro;
    private int quantidade;
    private float valorUnitario;
    private float valor;
    private float valorTotal;
    private String formaPagamento;

    public Relatorio() {
    }

    public Relatorio(int IDVenda, String nomeCliente, String dataVenda, String nomeLivro, int quantidade, float valorUnitario, float valor, float valorTotal, String formaPagamento) {
        this.IDVenda = IDVenda;
        this.nomeCliente = nomeCliente;
        this.dataVenda = dataVenda;
        this.nomeLivro = nomeLivro;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valor = valor;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }

    public int getIDVenda() {
        return IDVenda;
    }

    public void setIDVenda(int IDVenda) {
        this.IDVenda = IDVenda;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return "Relatorio{" + "IDVenda=" + IDVenda + ", nomeCliente=" + nomeCliente + ", dataVenda=" + dataVenda + ", nomeLivro=" + nomeLivro + ", quantidade=" + quantidade + ", valor=" + valor + ", valorTotal=" + valorTotal + '}';
    }

    public String formatDataVenda(String data) {
        String dia, mes, ano, dataBr;
        dia = data.substring(8);
        mes = data.substring(5, 7);
        ano = data.substring(0, 4);
        dataBr = dia + "/" + mes + "/" + ano;
        return dataBr;
    }

    public float formatToFloat(String preco) {
        float precoNovo;
        String precoFormatado;
        precoFormatado = preco.replaceAll("\\.", "").replaceAll("\\,", ".").replaceAll("R", "").replaceAll("\\$", "");
        precoNovo = Float.parseFloat(precoFormatado);
        return precoNovo;
    }

    public String formatToReal(float preco) {
        Locale ptBr = new Locale("pt", "Br");
        NumberFormat nf = NumberFormat.getCurrencyInstance(ptBr);
        String formatado = nf.format(preco);
        return formatado;
    }

}
