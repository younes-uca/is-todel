package  ma.sir.is.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.is.zynerator.util.StringUtil;
import ma.sir.is.zynerator.converter.AbstractConverter;
import ma.sir.is.zynerator.util.DateUtil;
import ma.sir.is.bean.history.ClassComptableHistory;
import ma.sir.is.bean.core.ClassComptable;
import ma.sir.is.ws.dto.ClassComptableDto;

@Component
public class ClassComptableConverter extends AbstractConverter<ClassComptable, ClassComptableDto, ClassComptableHistory> {


    public  ClassComptableConverter(){
        super(ClassComptable.class, ClassComptableDto.class, ClassComptableHistory.class);
    }

    @Override
    public ClassComptable toItem(ClassComptableDto dto) {
        if (dto == null) {
            return null;
        } else {
        ClassComptable item = new ClassComptable();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());


        return item;
        }
    }

    @Override
    public ClassComptableDto toDto(ClassComptable item) {
        if (item == null) {
            return null;
        } else {
            ClassComptableDto dto = new ClassComptableDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
