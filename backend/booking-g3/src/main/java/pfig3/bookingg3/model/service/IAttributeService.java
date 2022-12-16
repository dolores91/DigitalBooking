package pfig3.bookingg3.model.service;

import pfig3.bookingg3.model.dto.AttributeDTO;

import java.util.List;

public interface IAttributeService {

    public List<AttributeDTO> findAll();
    public AttributeDTO findById(Long id);
    public AttributeDTO save(AttributeDTO attribute);
    public AttributeDTO update(AttributeDTO attribute, Long id);

    public AttributeDTO delete(Long id);

}
