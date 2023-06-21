package bean;

public class Lojista {
        private int idLojista;
        private String nomeFantasia;
        private String documento;
        private String licencaEmpresarial;
        private String nomeResponsavel;
        private int idUsuario;
        private int idEndereco;
    
    // Construtores, getters e setters
        public Lojista(String nomeFantasia, String licencaEmpresarial, String documento, String nomeResponsavel) {
        this.nomeFantasia = nomeFantasia;
        this.licencaEmpresarial = licencaEmpresarial;
        this.documento = documento;
        this.nomeResponsavel = nomeResponsavel;

        }

        public Lojista() {
            
        }
    

    public int getIdLojista() {
        return idLojista;
    }

    public void setIdLojista(int idLojista) {
        this.idLojista = idLojista;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getLicencaEmpresarial() {
        return licencaEmpresarial;
    }

    public void setLicencaEmpresarial(String licencaEmpresarial) {
        this.licencaEmpresarial = licencaEmpresarial;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
}
