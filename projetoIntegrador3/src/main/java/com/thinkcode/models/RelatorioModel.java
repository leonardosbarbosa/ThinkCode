package com.thinkcode.models;

/**
 *
 * @author Gustavo Nascimento
 */
public class RelatorioModel {

    private int idProduto;
    private int idUsuario; // Chave estrangeira
    private int idFilial; // Chave estrangeira
    private String nomeProduto;
    private String qtdProduto;
    private int Valor;
    private VendaModel venda;
    private int idVenda;
    private ProdutoModel produtoModel;
    private String filialNome;
    private String usuarioNome;
    private String cpfCnpj;
    private int pagamento;
    private int parcelas;
    private Double total;
    private String data;
    private String NomeProduto;
    private int QuantidadeProduto;
    private Double ValorProduto;
    private int idVendedor;
    private String CpfCliente;
    private int idPagamento;
    private String formaPagamento;
    private String nomeCliente;
    private String descricao;
    private String tipoProduto;

    public RelatorioModel() {

    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    public void setProduto(ProdutoModel _produto) {
        this.produtoModel = _produto;
    }

    public ProdutoModel getProduto() {
        return this.produtoModel;
    }

    public void setIdVenda(int _idVenda) {
        this.idVenda = _idVenda;
    }

    public int getIdVenda() {
        return this.idVenda;
    }

    public void setfilialNome(String filialNome) {
        this.filialNome = filialNome;
    }

    public String getfilialNome() {
        return this.filialNome;
    }

    public void setusuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getusuarioNome() {
        return this.usuarioNome;
    }

    public void setcpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getcpfCnpj() {
        return this.cpfCnpj;
    }

    public int getpagamento() {
        return this.pagamento;
    }

    public void setpagamento(int pagamento) {
        this.pagamento = pagamento;
    }

    public int getparcelas() {
        return this.parcelas;
    }

    public void setparcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public Double gettotal() {
        return this.total;
    }

    public void settotal(Double total) {
        this.total = total;
    }

    public void setdata(String data) {
        this.data = data;
    }

    public String getdata() {
        return this.data;
    }

    public void setNomeProduto(String _produto) {
        this.NomeProduto = _produto;
    }

    public String getNomeProduto() {
        return this.NomeProduto;
    }

    public Double getValorProduto() {
        return this.ValorProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.ValorProduto = valorProduto;
    }

    public int getQuantidadeProduto() {
        return this.QuantidadeProduto;
    }

    public void setQuantidadeProduto(int qtd) {
        this.QuantidadeProduto = qtd;
    }

    public int getidVendedor() {
        return this.idVendedor;
    }

    public void setidVendedor(int _idVendedor) {
        this.idVendedor = _idVendedor;
    }

    public String getCpfCliente() {
        return this.CpfCliente;
    }

    public void setCpfCliente(String CpfCliente) {
        this.CpfCliente = CpfCliente;
    }

    public int getidPagamento() {
        return this.idPagamento;
    }

    public void setidPagamento(int _idPagamento) {
        this.idPagamento = _idPagamento;
    }

    public String getformaPagamento() {
        return this.formaPagamento;
    }

    public void setformaPagamento(String _formaPagamento) {
        this.formaPagamento = _formaPagamento;
    }

    public String getnomeCliente() {
        return this.nomeCliente;
    }

    public void setnomeCliente(String _nomeCliente) {
        this.nomeCliente = _nomeCliente;
    }
    public String getdescricao() {
        return this.descricao;
    }

    public void setdescricao(String _descricao) {
        this.descricao = _descricao;
    }
    
    public String gettipoProduto() {
        return this.tipoProduto;
    }

    public void settipoProduto(String _tipoProduto) {
        this.tipoProduto = _tipoProduto;
    }
    

}
