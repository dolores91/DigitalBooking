package pfig3.bookingg3.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfig3.bookingg3.model.dto.CategoryDTO;
import pfig3.bookingg3.model.entity.Category;
import pfig3.bookingg3.model.repository.ICategoryRepository;
import pfig3.bookingg3.util.MapperUtil;

import java.util.List;


@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    MapperUtil mapperUtil;


    @Override
    public List<CategoryDTO> findAll() {
        return mapperUtil.mapAll(categoryRepository.findAll(),CategoryDTO.class);
    }

    @Override
    public CategoryDTO findById(Long id) {
        return mapperUtil.map(categoryRepository.findById(id), CategoryDTO.class);
    }

    @Override
    public CategoryDTO save(CategoryDTO category) {
        return mapperUtil.map(categoryRepository.save(mapperUtil.map(category, Category.class)), CategoryDTO.class);
    }

    @Override
    public CategoryDTO update(CategoryDTO category, Long id) {
        Category categoryUpdated = categoryRepository.findById(id).orElse(null);
        if(categoryUpdated == null){
            //error
        }
        categoryUpdated.setTitle(category.getTitle());
        categoryUpdated.setDescription(category.getDescription());
        categoryUpdated.setUrl(category.getUrl());
        return mapperUtil.map(categoryRepository.save(categoryUpdated), CategoryDTO.class);
    }

    @Override
    public CategoryDTO delete(Long id) {
        CategoryDTO categoryDeleted = mapperUtil.map(categoryRepository.findById(id), CategoryDTO.class);
        categoryRepository.delete(mapperUtil.map(categoryDeleted, Category.class));
        return categoryDeleted;
    }
}
