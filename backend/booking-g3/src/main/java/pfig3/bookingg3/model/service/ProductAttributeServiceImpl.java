package pfig3.bookingg3.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfig3.bookingg3.model.dto.ProductAttributeDTO;
import pfig3.bookingg3.model.entity.Attribute;
import pfig3.bookingg3.model.entity.Product;
import pfig3.bookingg3.model.entity.ProductAttribute;
import pfig3.bookingg3.model.repository.IProductAttributeRepository;
import pfig3.bookingg3.util.MapperUtil;

import java.util.List;

@Service
public class ProductAttributeServiceImpl implements IProductAttributeService {

    @Autowired
    private IProductAttributeRepository productAttributeRepository;

    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public List<ProductAttributeDTO> findAll() {
        return mapperUtil.mapAll(productAttributeRepository.findAll(), ProductAttributeDTO.class);
    }

    @Override
    public ProductAttributeDTO findById(Long id) {
        return mapperUtil.map(productAttributeRepository.findById(id), ProductAttributeDTO.class);
    }

    @Override
    public ProductAttributeDTO save(ProductAttributeDTO productAttribute) {
        ProductAttribute p = productAttributeRepository.save(mapperUtil.map(productAttribute, ProductAttribute.class));
        return mapperUtil.map(p, ProductAttributeDTO.class);
    }

    @Override
    public List<ProductAttributeDTO> findByProductId(Long id) {
        return mapperUtil.mapAll(productAttributeRepository.findByProductId(id), ProductAttributeDTO.class);
    }

    @Override
    public ProductAttributeDTO update(ProductAttributeDTO productAttribute, Long id) {
        ProductAttribute productUpdated = productAttributeRepository.findById(id).orElse(null);
        if (productUpdated == null) {
            // error
        }
//        productUpdated.setProduct(mapperUtil.map(productAttribute.getProduct(), Product.class));
        productUpdated.setAttribute(mapperUtil.map(productAttribute.getAttribute(), Attribute.class));
        return mapperUtil.map(productAttributeRepository.save(productUpdated), ProductAttributeDTO.class);
    }

    @Override
    public ProductAttributeDTO delete(Long id) {
        ProductAttributeDTO productAttributeDeleted = mapperUtil.map(productAttributeRepository.findById(id), ProductAttributeDTO.class);
        productAttributeRepository.delete(mapperUtil.map(productAttributeDeleted, ProductAttribute.class));
        return productAttributeDeleted;
    }
}
