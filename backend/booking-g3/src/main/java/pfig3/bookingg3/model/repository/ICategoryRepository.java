package pfig3.bookingg3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfig3.bookingg3.model.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
