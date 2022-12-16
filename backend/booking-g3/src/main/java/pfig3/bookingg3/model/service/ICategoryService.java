package pfig3.bookingg3.model.service;

import pfig3.bookingg3.model.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    public List<CategoryDTO> findAll();
    public CategoryDTO findById(Long id);
    public CategoryDTO save(CategoryDTO category);
    public CategoryDTO update (CategoryDTO category, Long id);
    public CategoryDTO delete(Long id);
}
