package ma.zy.stocky.service.impl.admin.commun;


import ma.zy.stocky.bean.core.commun.Marque;
import ma.zy.stocky.dao.criteria.core.commun.MarqueCriteria;
import ma.zy.stocky.dao.facade.core.commun.MarqueDao;
import ma.zy.stocky.dao.specification.core.commun.MarqueSpecification;
import ma.zy.stocky.service.facade.admin.commun.MarqueAdminService;
import ma.zy.stocky.zynerator.service.AbstractServiceImpl;
import ma.zy.stocky.zynerator.service.Attribute;
import ma.zy.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zy.stocky.zynerator.util.VelocityPdf;
import ma.zy.stocky.ws.dto.commun.MarqueDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class MarqueAdminServiceImpl extends AbstractServiceImpl<Marque, MarqueCriteria, MarqueDao> implements MarqueAdminService {
    public static final String TEMPLATE = "template/marque.vm";
    public static final String FILE_NAME = "marque.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("reference"));

    ATTRIBUTES.add(new Attribute("libelle"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(MarqueDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public Marque findByReferenceEntity(Marque t){
        return  dao.findByLibelle(t.getLibelle());
    }




    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(Marque.class, MarqueSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public MarqueAdminServiceImpl(MarqueDao dao) {
        super(dao);
    }

}
