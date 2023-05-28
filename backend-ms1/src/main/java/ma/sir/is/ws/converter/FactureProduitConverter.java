package  ma.sir.is.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.is.zynerator.util.StringUtil;
import ma.sir.is.zynerator.converter.AbstractConverter;
import ma.sir.is.zynerator.util.DateUtil;
import ma.sir.is.bean.history.FactureProduitHistory;
import ma.sir.is.bean.core.FactureProduit;
import ma.sir.is.ws.dto.FactureProduitDto;

@Component
public class FactureProduitConverter extends AbstractConverter<FactureProduit, FactureProduitDto, FactureProduitHistory> {

    @Autowired
    private SocieteConverter societeConverter ;
    private boolean societe;

    public  FactureProduitConverter(){
        super(FactureProduit.class, FactureProduitDto.class, FactureProduitHistory.class);
    }

    @Override
    public FactureProduit toItem(FactureProduitDto dto) {
        if (dto == null) {
            return null;
        } else {
        FactureProduit item = new FactureProduit();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateFacuture()))
                item.setDateFacuture(DateUtil.stringEnToDate(dto.getDateFacuture()));
            if(StringUtil.isNotEmpty(dto.getIce()))
                item.setIce(dto.getIce());
            if(StringUtil.isNotEmpty(dto.getMontantHt()))
                item.setMontantHt(dto.getMontantHt());
            if(StringUtil.isNotEmpty(dto.getMontantTtc()))
                item.setMontantTtc(dto.getMontantTtc());
            if(StringUtil.isNotEmpty(dto.getMontantTva()))
                item.setMontantTva(dto.getMontantTva());
            if(this.societe && dto.getSociete()!=null)
                item.setSociete(societeConverter.toItem(dto.getSociete())) ;



        return item;
        }
    }

    @Override
    public FactureProduitDto toDto(FactureProduit item) {
        if (item == null) {
            return null;
        } else {
            FactureProduitDto dto = new FactureProduitDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateFacuture()!=null)
                dto.setDateFacuture(DateUtil.dateTimeToString(item.getDateFacuture()));
            if(StringUtil.isNotEmpty(item.getIce()))
                dto.setIce(item.getIce());
            if(StringUtil.isNotEmpty(item.getMontantHt()))
                dto.setMontantHt(item.getMontantHt());
            if(StringUtil.isNotEmpty(item.getMontantTtc()))
                dto.setMontantTtc(item.getMontantTtc());
            if(StringUtil.isNotEmpty(item.getMontantTva()))
                dto.setMontantTva(item.getMontantTva());
        if(this.societe && item.getSociete()!=null) {
            dto.setSociete(societeConverter.toDto(item.getSociete())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.societe = value;
    }


    public SocieteConverter getSocieteConverter(){
        return this.societeConverter;
    }
    public void setSocieteConverter(SocieteConverter societeConverter ){
        this.societeConverter = societeConverter;
    }
    public boolean  isSociete(){
        return this.societe;
    }
    public void  setSociete(boolean societe){
        this.societe = societe;
    }
}
