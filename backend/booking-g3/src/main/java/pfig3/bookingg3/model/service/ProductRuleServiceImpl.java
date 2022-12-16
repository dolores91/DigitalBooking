package pfig3.bookingg3.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfig3.bookingg3.model.dto.ProductDTO;
import pfig3.bookingg3.model.dto.ProductRuleDTO;
import pfig3.bookingg3.model.entity.Product;
import pfig3.bookingg3.model.entity.ProductRule;
import pfig3.bookingg3.model.entity.Rule;
import pfig3.bookingg3.model.repository.IProductRuleRepository;
import pfig3.bookingg3.util.MapperUtil;

import java.util.List;

@Service
public class ProductRuleServiceImpl implements IProductRuleService {

    @Autowired
    private IProductRuleRepository productRuleRepository;

    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public List<ProductRuleDTO> findAll() {
        return mapperUtil.mapAll(productRuleRepository.findAll(),ProductRuleDTO.class);
    }

    @Override
    public List<ProductRuleDTO> findRuleByProduct(Long productId) {
        return mapperUtil.mapAll(productRuleRepository.findRuleByProduct(productId), ProductRuleDTO.class);
    }

    @Override
    public ProductRuleDTO findById(Long id) {
        return mapperUtil.map(productRuleRepository.findById(id), ProductRuleDTO.class);
    }

    @Override
    public ProductRuleDTO save(ProductRuleDTO productRule) {
        ProductRule p = productRuleRepository.save(mapperUtil.map(productRule, ProductRule.class));
        return mapperUtil.map(p, ProductRuleDTO.class);

    }

    @Override
    public ProductRuleDTO update(ProductRuleDTO productRule, Long id) {
        ProductRule productUpdated = productRuleRepository.findById(id).orElse(null);
        if(productUpdated == null){
            //error
        }
        productUpdated.setProduct(mapperUtil.map(productRule.getRule(), Product.class));
        productUpdated.setRule(mapperUtil.map(productRule.getRule(), Rule.class));
        return mapperUtil.map(productRuleRepository.save(productUpdated),ProductRuleDTO.class);
    }

    @Override
    public ProductRuleDTO delete(Long id) {
        ProductRuleDTO productRuleDeleted = mapperUtil.map(productRuleRepository.findById(id), ProductRuleDTO.class);
        productRuleRepository.delete(mapperUtil.map(productRuleDeleted, ProductRule.class));
        return productRuleDeleted;
    }
}