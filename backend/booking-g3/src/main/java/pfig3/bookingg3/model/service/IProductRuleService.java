package pfig3.bookingg3.model.service;

import pfig3.bookingg3.model.dto.ProductRuleDTO;

import java.util.List;

public interface IProductRuleService {

    public List<ProductRuleDTO> findAll();

    public List<ProductRuleDTO> findRuleByProduct(Long productId);

    public ProductRuleDTO findById(Long id);

    public ProductRuleDTO save(ProductRuleDTO productRule);

    public ProductRuleDTO update(ProductRuleDTO productRule, Long id);

    public ProductRuleDTO delete(Long id);



}