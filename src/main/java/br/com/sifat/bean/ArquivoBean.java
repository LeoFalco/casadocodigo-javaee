package br.com.sifat.bean;

import br.com.sifat.dao.ArquivoDao;
import br.com.sifat.model.Arquivo;
import org.primefaces.model.UploadedFile;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class ArquivoBean {

    @Inject
    private ArquivoDao arquivoDao;

    private Arquivo arquivo = new Arquivo();

    private UploadedFile file;

    public void upload() {

        arquivo.setArquivo(file.getContents());
        arquivo.setContentType(file.getContentType());
        arquivo.setNome(file.getFileName());
        arquivo.setTamanho(file.getSize());

        arquivoDao.salvar(arquivo);

    }

    public ArquivoDao getArquivoDao() {
        return arquivoDao;
    }

    public void setArquivoDao(ArquivoDao arquivoDao) {
        this.arquivoDao = arquivoDao;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
}
