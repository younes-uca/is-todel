package ma.sir.is.service.facade.admin;

import java.util.List;
import ma.sir.is.bean.core.CompteComptable;
import ma.sir.is.dao.criteria.core.CompteComptableCriteria;
import ma.sir.is.dao.criteria.history.CompteComptableHistoryCriteria;
import ma.sir.is.zynerator.service.IService;

import ma.sir.is.ws.dto.CompteComptableDto;
import org.springframework.http.HttpEntity;

public interface CompteComptableAdminService extends  IService<CompteComptable,CompteComptableCriteria, CompteComptableHistoryCriteria>  {

    List<CompteComptable> findBySousClassComptableId(Long id);
    int deleteBySousClassComptableId(Long id);

    HttpEntity<byte[]> createPdf(CompteComptableDto dto) throws Exception;


}
