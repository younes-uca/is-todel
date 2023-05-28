package ma.sir.is.service.impl.admin;

import ma.sir.is.bean.core.DeclarationTva;
import ma.sir.is.bean.history.DeclarationTvaHistory;
import ma.sir.is.dao.criteria.core.DeclarationTvaCriteria;
import ma.sir.is.dao.criteria.history.DeclarationTvaHistoryCriteria;
import ma.sir.is.dao.facade.core.DeclarationTvaDao;
import ma.sir.is.dao.facade.history.DeclarationTvaHistoryDao;
import ma.sir.is.dao.specification.core.DeclarationTvaSpecification;
import ma.sir.is.service.facade.admin.DeclarationTvaAdminService;
import ma.sir.is.zynerator.service.AbstractServiceImpl;
import ma.sir.is.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.is.zynerator.util.VelocityPdf;
import ma.sir.is.ws.dto.DeclarationTvaDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.is.service.facade.admin.TauxRetardTvaAdminService ;
import ma.sir.is.service.facade.admin.SocieteAdminService ;


import java.util.List;
@Service
public class DeclarationTvaAdminServiceImpl extends AbstractServiceImpl<DeclarationTva,DeclarationTvaHistory, DeclarationTvaCriteria, DeclarationTvaHistoryCriteria, DeclarationTvaDao,
DeclarationTvaHistoryDao> implements DeclarationTvaAdminService {
    public static final String TEMPLATE = "template/declarationTva.vm";
    public static final String FILE_NAME = "declarationTva.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(DeclarationTvaDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<DeclarationTva> findBySocieteId(Long id){
        return dao.findBySocieteId(id);
    }
    public int deleteBySocieteId(Long id){
        return dao.deleteBySocieteId(id);
    }
    public List<DeclarationTva> findByTauxRetardTvaId(Long id){
        return dao.findByTauxRetardTvaId(id);
    }
    public int deleteByTauxRetardTvaId(Long id){
        return dao.deleteByTauxRetardTvaId(id);
    }



    public void configure() {
        super.configure(DeclarationTva.class,DeclarationTvaHistory.class, DeclarationTvaHistoryCriteria.class, DeclarationTvaSpecification.class);
    }

    @Autowired
    private TauxRetardTvaAdminService tauxRetardTvaService ;
    @Autowired
    private SocieteAdminService societeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public DeclarationTvaAdminServiceImpl(DeclarationTvaDao dao, DeclarationTvaHistoryDao historyDao) {
        super(dao, historyDao);
    }

}