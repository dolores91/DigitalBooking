package pfig3.bookingg3.model.service;

import pfig3.bookingg3.model.dto.RuleDTO;

import java.util.List;

public interface IRuleService  {

    public List<RuleDTO> findAll();

    public RuleDTO findById(Long id);

    public List<RuleDTO> findByRuleCategory(Long ruleCategoryId);

    public RuleDTO save(RuleDTO rule);

    public RuleDTO update(RuleDTO rule, Long id);

    public RuleDTO delete(Long id);
}
