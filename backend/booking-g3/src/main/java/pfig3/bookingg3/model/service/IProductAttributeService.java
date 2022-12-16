package pfig3.bookingg3.model.service;

import pfig3.bookingg3.model.dto.ProductAttributeDTO;

import java.util.List;

public interface IProductAttributeService {

    public List<ProductAttributeDTO> findAll();
    public ProductAttributeDTO findById(Long id);
    public ProductAttributeDTO save(ProductAttributeDTO productAttribute);

    public List<ProductAttributeDTO> findByProductId(Long id);

    public ProductAttributeDTO update(ProductAttributeDTO productAttribute, Long id);
    public ProductAttributeDTO delete(Long id);

}
