package  ma.zy.stocky.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zy.stocky.zynerator.util.StringUtil;
import ma.zy.stocky.zynerator.converter.AbstractConverter;
import ma.zy.stocky.zynerator.util.DateUtil;
import ma.zy.stocky.bean.core.commun.Marque;
import ma.zy.stocky.ws.dto.commun.MarqueDto;

@Component
public class MarqueConverter extends AbstractConverter<Marque, MarqueDto> {


    public  MarqueConverter(){
        super(Marque.class, MarqueDto.class);
    }

    @Override
    public Marque toItem(MarqueDto dto) {
        if (dto == null) {
            return null;
        } else {
        Marque item = new Marque();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public MarqueDto toDto(Marque item) {
        if (item == null) {
            return null;
        } else {
            MarqueDto dto = new MarqueDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
