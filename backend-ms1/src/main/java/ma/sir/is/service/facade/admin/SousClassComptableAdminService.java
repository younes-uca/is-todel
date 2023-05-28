package ma.sir.is.service.facade.admin;

import java.util.List;
import ma.sir.is.bean.core.SousClassComptable;
import ma.sir.is.dao.criteria.core.SousClassComptableCriteria;
import ma.sir.is.dao.criteria.history.SousClassComptableHistoryCriteria;
import ma.sir.is.zynerator.service.IService;

import ma.sir.is.ws.dto.SousClassComptableDto;
import org.springframework.http.HttpEntity;

public interface SousClassComptableAdminService extends  IService<SousClassComptable,SousClassComptableCriteria, SousClassComptableHistoryCriteria>  {

    List<SousClassComptable> findByClassComptableId(Long id);
    int deleteByClassComptableId(Long id);

    HttpEntity<byte[]> createPdf(SousClassComptableDto dto) throws Exception;


}
