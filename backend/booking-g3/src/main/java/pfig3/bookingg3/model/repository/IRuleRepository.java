package pfig3.bookingg3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfig3.bookingg3.model.entity.Rule;

import java.util.List;


@Repository
public interface IRuleRepository extends JpaRepository<Rule, Long> {

    public List<Rule> findByRuleCategory(Long ruleCategoryId);
}
