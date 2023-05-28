package ma.sir.is.service.facade.admin;

import java.util.List;
import ma.sir.is.bean.core.FactureCharge;
import ma.sir.is.dao.criteria.core.FactureChargeCriteria;
import ma.sir.is.dao.criteria.history.FactureChargeHistoryCriteria;
import ma.sir.is.zynerator.service.IService;

import ma.sir.is.ws.dto.FactureChargeDto;
import org.springframework.http.HttpEntity;

public interface FactureChargeAdminService extends  IService<FactureCharge,FactureChargeCriteria, FactureChargeHistoryCriteria>  {

    List<FactureCharge> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<FactureCharge> findByDeclarationIsId(Long id);
    int deleteByDeclarationIsId(Long id);

    HttpEntity<byte[]> createPdf(FactureChargeDto dto) throws Exception;


}
