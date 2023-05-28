package ma.sir.is.service.impl.admin;

import ma.sir.is.bean.core.FactureCharge;
import ma.sir.is.bean.history.FactureChargeHistory;
import ma.sir.is.dao.criteria.core.FactureChargeCriteria;
import ma.sir.is.dao.criteria.history.FactureChargeHistoryCriteria;
import ma.sir.is.dao.facade.core.FactureChargeDao;
import ma.sir.is.dao.facade.history.FactureChargeHistoryDao;
import ma.sir.is.dao.specification.core.FactureChargeSpecification;
import ma.sir.is.service.facade.admin.FactureChargeAdminService;
import ma.sir.is.zynerator.service.AbstractServiceImpl;
import ma.sir.is.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.is.zynerator.util.VelocityPdf;
import ma.sir.is.ws.dto.FactureChargeDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.is.service.facade.admin.DeclarationIsAdminService ;
import ma.sir.is.service.facade.admin.SocieteAdminService ;


import java.util.List;
@Service
public class FactureChargeAdminServiceImpl extends AbstractServiceImpl<FactureCharge,FactureChargeHistory, FactureChargeCriteria, FactureChargeHistoryCriteria, FactureChargeDao,
FactureChargeHistoryDao> implements FactureChargeAdminService {
    public static final String TEMPLATE = "template/factureCharge.vm";
    public static final String FILE_NAME = "factureCharge.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(FactureChargeDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<FactureCharge> findBySocieteId(Long id){
        return dao.findBySocieteId(id);
    }
    public int deleteBySocieteId(Long id){
        return dao.deleteBySocieteId(id);
    }
    public List<FactureCharge> findByDeclarationIsId(Long id){
        return dao.findByDeclarationIsId(id);
    }
    public int deleteByDeclarationIsId(Long id){
        return dao.deleteByDeclarationIsId(id);
    }



    public void configure() {
        super.configure(FactureCharge.class,FactureChargeHistory.class, FactureChargeHistoryCriteria.class, FactureChargeSpecification.class);
    }

    @Autowired
    private DeclarationIsAdminService declarationIsService ;
    @Autowired
    private SocieteAdminService societeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public FactureChargeAdminServiceImpl(FactureChargeDao dao, FactureChargeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}