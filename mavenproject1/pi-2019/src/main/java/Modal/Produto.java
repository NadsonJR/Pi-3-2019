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
public class Produto {
    private String NomeProduto;
    private String DescricaoProduto;
    private int PrecoProduto;
    private String CategoriaProduto;
    private Integer ID;
    private Integer QuantidadeProduto;

    public Integer getQuantidadeProduto() {
        return QuantidadeProduto;
    }

    public void setQuantidadeproduto(Integer QuantidadeProduto) {
        this.QuantidadeProduto = QuantidadeProduto;
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String NomeProduto) {
        this.NomeProduto = NomeProduto;
    }

    public String getDescricaoProduto() {
        return DescricaoProduto;
    }

    public void setDescricaoProduto(String DescricaoProduto) {
        this.DescricaoProduto = DescricaoProduto;
    }

    public int getPrecoProduto() {
        return PrecoProduto;
    }

    public void setPrecoProduto(int PrecoProduto) {
        this.PrecoProduto = PrecoProduto;
    }

    public String getCategoriaProduto() {
        return CategoriaProduto;
    }

    public void setCategoriaProduto(String CategoriaProduto) {
        this.CategoriaProduto = CategoriaProduto;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public Produto(String NomeProduto , String DescricaoProduto, int PrecoProduto, String Categoria, int QuantidadeProduto, int ID ){
    this.CategoriaProduto = Categoria;
    this.NomeProduto = NomeProduto;
    this.DescricaoProduto = DescricaoProduto;
    this.PrecoProduto = PrecoProduto;
    this.QuantidadeProduto = QuantidadeProduto;
    }
}
