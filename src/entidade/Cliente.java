package entidade;

public class Cliente {
    private int idCliente;
    private String nomeCliente;
    private String cpfCliente;
    private String rgCliente;
    private String dtnCliente;
    private String foneCliente;
    private String celularCliente;
    private String emailCliente;
    private String endCliente;
    private String bairroCliente;
    private String cidCliente;
    
    //no banco de dados toda variavel está como o campo "ativo" marcado como 1 por default (adicionado automaticamente).
    //Por isso nao consta no sistema como campo para ser cadastrado, apenas atualizado quando for fazer inativação.
    //1 = ativo
    //0 = inativo

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getRgCliente() {
        return rgCliente;
    }

    public void setRgCliente(String rgCliente) {
        this.rgCliente = rgCliente;
    }

    public String getDtnCliente() {
        return dtnCliente;
    }

    public void setDtnCliente(String dtnCliente) {
        this.dtnCliente = dtnCliente;
    }

    public String getFoneCliente() {
        return foneCliente;
    }

    public void setFoneCliente(String foneCliente) {
        this.foneCliente = foneCliente;
    }

    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getEndCliente() {
        return endCliente;
    }

    public void setEndCliente(String endCliente) {
        this.endCliente = endCliente;
    }

    public String getBairroCliente() {
        return bairroCliente;
    }

    public void setBairroCliente(String bairroCliente) {
        this.bairroCliente = bairroCliente;
    }

    public String getCidCliente() {
        return cidCliente;
    }

    public void setCidCliente(String cidCliente) {
        this.cidCliente = cidCliente;
    }

    
}
