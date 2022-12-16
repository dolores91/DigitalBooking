package pfig3.bookingg3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfig3.bookingg3.model.entity.Favorite;

@Repository
public interface IFavoriteRepository extends JpaRepository<Favorite, Long> {
    public long countByProductAndCustomer(Long productId, Long userId);
}
