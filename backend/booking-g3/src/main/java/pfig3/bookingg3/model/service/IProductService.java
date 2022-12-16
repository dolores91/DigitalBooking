package pfig3.bookingg3.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pfig3.bookingg3.model.dto.ProductDTO;


import java.util.List;

public interface IProductService {

    public Page<ProductDTO> findAll(Pageable pageable);
    public List<ProductDTO> findAll();

    public ProductDTO findById(Long id);
    public List<ProductDTO> findByCategory(Long categoryId);

    public List<ProductDTO> findByCity(Long cityId);

    public ProductDTO save(ProductDTO product);

    public ProductDTO update(ProductDTO product, Long id);

    public ProductDTO delete (long id);
}
