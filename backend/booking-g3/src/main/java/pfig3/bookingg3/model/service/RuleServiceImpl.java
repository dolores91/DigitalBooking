package pfig3.bookingg3.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfig3.bookingg3.model.dto.ProductDTO;
import pfig3.bookingg3.model.dto.RuleDTO;
import pfig3.bookingg3.model.entity.Rule;
import pfig3.bookingg3.model.repository.IRuleRepository;
import pfig3.bookingg3.util.MapperUtil;

import java.util.List;

@Service
public class RuleServiceImpl implements IRuleService{

    @Autowired
    private IRuleRepository ruleRepository;

    @Autowired
    private MapperUtil mapperUtil;


    @Override
    public List<RuleDTO> findAll() {
        return mapperUtil.mapAll(ruleRepository.findAll(), RuleDTO.class);
    }

    @Override
    public RuleDTO findById(Long id) {
        return mapperUtil.map(ruleRepository.findById(id), RuleDTO.class);
    }

    @Override
    public List<RuleDTO> findByRuleCategory(Long ruleCategoryId) {
        return mapperUtil.mapAll(ruleRepository.findByRuleCategory(ruleCategoryId), RuleDTO.class);
    }

    @Override
    public RuleDTO save(RuleDTO rule) {
        return mapperUtil.map(ruleRepository.save(mapperUtil.map(rule, Rule.class)), RuleDTO.class);
    }

    @Override
    public RuleDTO update(RuleDTO rule, Long id) {
        Rule ruleUpdated = ruleRepository.findById(id).orElse(null);
        if(ruleUpdated == null){
            //error
        }
        ruleUpdated.setName(rule.getName());
        ruleUpdated.setDescription(rule.getDescription());
        ruleUpdated.setFine(rule.getFine());
        return mapperUtil.map(ruleRepository.save(ruleUpdated), RuleDTO.class);
    }

    @Override
    public RuleDTO delete(Long id) {
        RuleDTO ruleDeleted = mapperUtil.map(ruleRepository.findById(id), RuleDTO.class);
        ruleRepository.delete(mapperUtil.map(ruleDeleted, Rule.class));
        return ruleDeleted;
    }
}
