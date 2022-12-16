package pfig3.bookingg3.model.service;


import pfig3.bookingg3.model.dto.RuleCategoryDTO;
import pfig3.bookingg3.model.entity.RuleCategory;

import java.util.List;

public interface IRuleCategoryService {

    public List<RuleCategoryDTO> findAll();
    public RuleCategoryDTO findById(Long id);
    public RuleCategoryDTO save(RuleCategoryDTO ruleCategory);
    public RuleCategoryDTO update(RuleCategoryDTO ruleCategory, Long id);
    public RuleCategoryDTO delete(Long id);

}