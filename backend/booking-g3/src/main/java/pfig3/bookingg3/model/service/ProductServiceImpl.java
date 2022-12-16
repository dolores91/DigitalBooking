package pfig3.bookingg3.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pfig3.bookingg3.model.dto.ProductAttributeDTO;
import pfig3.bookingg3.model.dto.ProductDTO;
import pfig3.bookingg3.model.dto.ProductRuleDTO;
import pfig3.bookingg3.model.dto.RuleDTO;
import pfig3.bookingg3.model.entity.Product;
import pfig3.bookingg3.model.entity.ProductAttribute;
import pfig3.bookingg3.model.repository.IProductAttributeRepository;
import pfig3.bookingg3.model.repository.IProductRepository;
import pfig3.bookingg3.model.repository.IProductRuleRepository;
import pfig3.bookingg3.util.MapperUtil;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IProductAttributeRepository productAttributeRepository;
    @Autowired
    private IProductRuleRepository productRuleRepository;

    @Autowired
    private IProductAttributeService productAttributeService;

    @Autowired
    private MapperUtil mapperUtil;


    @Override
    public Page<ProductDTO> findAll(Pageable pageable) {
        return mapperUtil.mapEntityPageIntoDtoPage(productRepository.findAll(pageable), ProductDTO.class);
    }

    @Override
    public List<ProductDTO> findAll() {
        return mapperUtil.mapAll(productRepository.findAll(), ProductDTO.class);
    }

    @Override
    public ProductDTO findById(Long id) {
        List<ProductAttributeDTO>pa = mapperUtil.mapAll(productAttributeRepository.findByProductId(id), ProductAttributeDTO.class);
        List<ProductRuleDTO> pr = mapperUtil.mapAll(productRuleRepository.findRuleByProduct(id), ProductRuleDTO.class);

//        ProductDTO p = mapperUtil.map(pa,ProductDTO.class);
//        ProductDTO r = mapperUtil.map(pr,ProductDTO.class);

        ProductDTO dProductDTO  = mapperUtil.map(productRepository.findById(id), ProductDTO.class);
        dProductDTO.setProductAttribute(pa);
        dProductDTO.setProductRule(pr);

        return dProductDTO;
    }

    @Override
    public List<ProductDTO> findByCategory(Long categoryId) {
        return mapperUtil.mapAll(productRepository.findByCategory(categoryId), ProductDTO.class);
    }

    @Override
    public List<ProductDTO> findByCity(Long cityId) {
        return mapperUtil.mapAll(productRepository.findByCity(cityId), ProductDTO.class);
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        Product p = productRepository.save(mapperUtil.map(product, Product.class));
        return mapperUtil.map(p, ProductDTO.class);
    }

    @Override
    public ProductDTO update(ProductDTO product, Long id) {
        Product productUpdated = productRepository.findById(id).orElse(null);
        if (productUpdated == null) {
            // error
        }
        Product productNewData = mapperUtil.map(product, Product.class);
        productUpdated.setName(productNewData.getName());
        productUpdated.setMainDescription(productNewData.getMainDescription());
        productUpdated.setDescriptionA(productNewData.getDescriptionA());
        productUpdated.setDescriptionB(productNewData.getDescriptionB());
        productUpdated.setDescriptionC(productNewData.getDescriptionC());
        productUpdated.setDescriptionD(productNewData.getDescriptionD());
        productUpdated.setAddress(productNewData.getAddress());
        productUpdated.setLocation_detail(productNewData.getLocation_detail());
        productUpdated.setLongitude(productNewData.getLongitude());
        productUpdated.setLatitude(productNewData.getLatitude());
        productUpdated.setCity(productNewData.getCity());
        productUpdated.setImageSet(productNewData.getImageSet());
        productUpdated.setCategory(productNewData.getCategory());
//        productUpdated.setRuleSet(productNewData.getRuleSet());
        return mapperUtil.map(productRepository.save(productUpdated), ProductDTO.class);
    }

    @Override
    public ProductDTO delete(long id) {
        ProductDTO productDeleted = mapperUtil.map(productRepository.findById(id), ProductDTO.class);
        productRepository.delete(mapperUtil.map(productDeleted, Product.class));
        return productDeleted;
    }
}
