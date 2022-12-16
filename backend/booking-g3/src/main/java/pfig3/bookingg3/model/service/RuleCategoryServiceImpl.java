package pfig3.bookingg3.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfig3.bookingg3.model.dto.RuleCategoryDTO;
import pfig3.bookingg3.model.entity.RuleCategory;
import pfig3.bookingg3.model.repository.IRuleCategoryRepository;
import pfig3.bookingg3.util.MapperUtil;

import java.util.List;

@Service
public class RuleCategoryServiceImpl implements IRuleCategoryService {


    @Autowired
    private IRuleCategoryRepository ruleCategoryRepository;
    @Autowired
    MapperUtil mapperUtil;


    @Override
    public List<RuleCategoryDTO> findAll() {
        return mapperUtil.mapAll(ruleCategoryRepository.findAll(), RuleCategoryDTO.class);
    }

    @Override
    public RuleCategoryDTO findById(Long id) {
        return mapperUtil.map(ruleCategoryRepository.findById(id), RuleCategoryDTO.class);
    }

    @Override
    public RuleCategoryDTO save(RuleCategoryDTO ruleCategory) {
        return mapperUtil.map(ruleCategoryRepository.save(mapperUtil.map(ruleCategory, RuleCategory.class)), RuleCategoryDTO.class);
    }

    @Override
    public RuleCategoryDTO update(RuleCategoryDTO ruleCategory, Long id) {
        RuleCategory ruleCategoryUpdated = ruleCategoryRepository.findById(id).orElse(null);
        if(ruleCategoryUpdated == null){
            //error
        }
        ruleCategoryUpdated.setTitle(ruleCategory.getTitle());
        ruleCategoryUpdated.setDescription(ruleCategory.getDescription());
        return mapperUtil.map(ruleCategoryRepository.save(ruleCategoryUpdated), RuleCategoryDTO.class);
    }

    @Override
    public RuleCategoryDTO delete(Long id) {
        RuleCategoryDTO ruleCategoryDeleted = mapperUtil.map(ruleCategoryRepository.findById(id), RuleCategoryDTO.class);
        ruleCategoryRepository.delete(mapperUtil.map(ruleCategoryDeleted, RuleCategory.class));
        return null;
    }
}
