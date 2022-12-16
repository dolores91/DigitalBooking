package pfig3.bookingg3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pfig3.bookingg3.model.entity.Product;
import pfig3.bookingg3.model.entity.ProductRule;

import java.util.List;

public interface IProductRuleRepository extends JpaRepository<ProductRule, Long> {
    public List<ProductRule> findRuleByProduct(Long productId);

}
