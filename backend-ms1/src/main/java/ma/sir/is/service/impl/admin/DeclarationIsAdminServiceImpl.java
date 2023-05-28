package ma.sir.is.service.impl.admin;

import ma.sir.is.bean.core.DeclarationIs;
import ma.sir.is.bean.history.DeclarationIsHistory;
import ma.sir.is.dao.criteria.core.DeclarationIsCriteria;
import ma.sir.is.dao.criteria.history.DeclarationIsHistoryCriteria;
import ma.sir.is.dao.facade.core.DeclarationIsDao;
import ma.sir.is.dao.facade.history.DeclarationIsHistoryDao;
import ma.sir.is.dao.specification.core.DeclarationIsSpecification;
import ma.sir.is.service.facade.admin.DeclarationIsAdminService;
import ma.sir.is.zynerator.service.AbstractServiceImpl;
import ma.sir.is.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.is.zynerator.util.VelocityPdf;
import ma.sir.is.ws.dto.DeclarationIsDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.is.bean.core.FactureCharge;
import ma.sir.is.bean.core.FactureProduit;

import ma.sir.is.service.facade.admin.FactureChargeAdminService ;
import ma.sir.is.service.facade.admin.TauxIsAdminService ;
import ma.sir.is.service.facade.admin.SocieteAdminService ;
import ma.sir.is.service.facade.admin.FactureProduitAdminService ;


import java.util.List;
@Service
public class DeclarationIsAdminServiceImpl extends AbstractServiceImpl<DeclarationIs,DeclarationIsHistory, DeclarationIsCriteria, DeclarationIsHistoryCriteria, DeclarationIsDao,
DeclarationIsHistoryDao> implements DeclarationIsAdminService {
    public static final String TEMPLATE = "template/declarationIs.vm";
    public static final String FILE_NAME = "declarationIs.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(DeclarationIsDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public DeclarationIs create(DeclarationIs t) {
        super.create(t);
        if (t.getFactureCharges() != null) {
                t.getFactureCharges().forEach(element-> {
                    element.setDeclarationIs(t);
                    factureChargeService.create(element);
            });
        }
        if (t.getFactureProduit() != null) {
                t.getFactureProduit().forEach(element-> {
                    element.setDeclarationIs(t);
                    factureProduitService.create(element);
            });
        }
        return t;
    }

    public DeclarationIs findWithAssociatedLists(Long id){
        DeclarationIs result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setFactureCharges(factureChargeService.findByDeclarationIsId(id));
            result.setFactureProduit(factureProduitService.findByDeclarationIsId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        factureChargeService.deleteByDeclarationIsId(id);
        factureProduitService.deleteByDeclarationIsId(id);
    }


    public void updateWithAssociatedLists(DeclarationIs declarationIs){
    if(declarationIs !=null && declarationIs.getId() != null){
            List<List<FactureCharge>> resultFactureCharges= factureChargeService.getToBeSavedAndToBeDeleted(factureChargeService.findByDeclarationIsId(declarationIs.getId()),declarationIs.getFactureCharges());
            factureChargeService.delete(resultFactureCharges.get(1));
            ListUtil.emptyIfNull(resultFactureCharges.get(0)).forEach(e -> e.setDeclarationIs(declarationIs));
            factureChargeService.update(resultFactureCharges.get(0),true);
            List<List<FactureProduit>> resultFactureProduit= factureProduitService.getToBeSavedAndToBeDeleted(factureProduitService.findByDeclarationIsId(declarationIs.getId()),declarationIs.getFactureProduit());
            factureProduitService.delete(resultFactureProduit.get(1));
            ListUtil.emptyIfNull(resultFactureProduit.get(0)).forEach(e -> e.setDeclarationIs(declarationIs));
            factureProduitService.update(resultFactureProduit.get(0),true);
    }
    }


    public List<DeclarationIs> findBySocieteId(Long id){
        return dao.findBySocieteId(id);
    }
    public int deleteBySocieteId(Long id){
        return dao.deleteBySocieteId(id);
    }
    public List<DeclarationIs> findByTauxIsId(Long id){
        return dao.findByTauxIsId(id);
    }
    public int deleteByTauxIsId(Long id){
        return dao.deleteByTauxIsId(id);
    }



    public void configure() {
        super.configure(DeclarationIs.class,DeclarationIsHistory.class, DeclarationIsHistoryCriteria.class, DeclarationIsSpecification.class);
    }

    @Autowired
    private FactureChargeAdminService factureChargeService ;
    @Autowired
    private TauxIsAdminService tauxIsService ;
    @Autowired
    private SocieteAdminService societeService ;
    @Autowired
    private FactureProduitAdminService factureProduitService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public DeclarationIsAdminServiceImpl(DeclarationIsDao dao, DeclarationIsHistoryDao historyDao) {
        super(dao, historyDao);
    }

}