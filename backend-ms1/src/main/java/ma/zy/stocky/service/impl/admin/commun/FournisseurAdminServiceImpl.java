package ma.zy.stocky.service.impl.admin.commun;


import ma.zy.stocky.bean.core.commun.Fournisseur;
import ma.zy.stocky.dao.criteria.core.commun.FournisseurCriteria;
import ma.zy.stocky.dao.facade.core.commun.FournisseurDao;
import ma.zy.stocky.dao.specification.core.commun.FournisseurSpecification;
import ma.zy.stocky.service.facade.admin.commun.FournisseurAdminService;
import ma.zy.stocky.zynerator.service.AbstractServiceImpl;
import ma.zy.stocky.zynerator.service.Attribute;
import ma.zy.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zy.stocky.zynerator.util.VelocityPdf;
import ma.zy.stocky.ws.dto.commun.FournisseurDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class FournisseurAdminServiceImpl extends AbstractServiceImpl<Fournisseur, FournisseurCriteria, FournisseurDao> implements FournisseurAdminService {
    public static final String TEMPLATE = "template/fournisseur.vm";
    public static final String FILE_NAME = "fournisseur.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("reference"));

    ATTRIBUTES.add(new Attribute("nom"));

    ATTRIBUTES.add(new Attribute("prenom"));

    ATTRIBUTES.add(new Attribute("telephone"));

    ATTRIBUTES.add(new Attribute("email"));

    ATTRIBUTES.add(new Attribute("description"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(FournisseurDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public Fournisseur findByReferenceEntity(Fournisseur t){
        return  dao.findByPrenom(t.getPrenom());
    }




    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(Fournisseur.class, FournisseurSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public FournisseurAdminServiceImpl(FournisseurDao dao) {
        super(dao);
    }

}
