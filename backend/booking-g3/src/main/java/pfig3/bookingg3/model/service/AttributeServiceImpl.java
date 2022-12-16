package pfig3.bookingg3.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfig3.bookingg3.model.dto.AttributeDTO;
import pfig3.bookingg3.model.entity.Attribute;
import pfig3.bookingg3.model.repository.IAttributeRepository;
import pfig3.bookingg3.util.MapperUtil;

import java.util.List;

@Service
public class AttributeServiceImpl implements IAttributeService {

    @Autowired
    private IAttributeRepository attributeRepository;

    @Autowired
    private MapperUtil mapperUtil;


    @Override
    public List<AttributeDTO> findAll() {
        return mapperUtil.mapAll(attributeRepository.findAll(), AttributeDTO.class);
    }

    @Override
    public AttributeDTO findById(Long id) {
        return mapperUtil.map(attributeRepository.findById(id), AttributeDTO.class);
    }

    @Override
    public AttributeDTO save(AttributeDTO attribute) {
        return mapperUtil.map(attributeRepository.save(mapperUtil.map(attribute, Attribute.class)), AttributeDTO.class);
    }

    @Override
    public AttributeDTO update(AttributeDTO attribute, Long id) {
        Attribute attributeUpdated = attributeRepository.findById(id).orElse(null);
        if (attributeUpdated == null) {
            // error
        }
        attributeUpdated.setName(attribute.getName());
        attributeUpdated.setType(attribute.getType());
        attributeUpdated.setIcon(attribute.getIcon());
        return mapperUtil.map(attributeRepository.save(attributeUpdated), AttributeDTO.class);
    }

    @Override
    public AttributeDTO delete(Long id) {
        AttributeDTO policyDeleted = mapperUtil.map(attributeRepository.findById(id), AttributeDTO.class);
        attributeRepository.delete(mapperUtil.map(policyDeleted, Attribute.class));
        return policyDeleted;
    }
}
