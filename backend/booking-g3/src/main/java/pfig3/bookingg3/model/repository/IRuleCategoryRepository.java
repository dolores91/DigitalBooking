package pfig3.bookingg3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfig3.bookingg3.model.entity.RuleCategory;

@Repository
public interface IRuleCategoryRepository extends JpaRepository<RuleCategory, Long> {

}
