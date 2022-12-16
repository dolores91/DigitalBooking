package pfig3.bookingg3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfig3.bookingg3.model.entity.ProductAttribute;

import java.util.List;

@Repository
public interface IProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {

    public List<ProductAttribute> findByProductId(Long id);
}
