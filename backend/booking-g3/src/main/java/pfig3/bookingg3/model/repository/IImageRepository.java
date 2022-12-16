package pfig3.bookingg3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfig3.bookingg3.model.entity.Image;
import pfig3.bookingg3.model.entity.Product;

import java.util.List;

@Repository
public interface IImageRepository extends JpaRepository<Image,Long> {

    public List<Image> findByProductId(Long productId);
}
