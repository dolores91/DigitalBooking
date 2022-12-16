package pfig3.bookingg3.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfig3.bookingg3.model.dto.ProductAttributeDTO;
import pfig3.bookingg3.model.dto.ProductDTO;
import pfig3.bookingg3.model.dto.ProductRuleDTO;
import pfig3.bookingg3.model.repository.IProductRepository;
import pfig3.bookingg3.util.MapperUtil;

import java.time.LocalDate;
import java.util.List;

@Service
public class SearchFilterServiceImpl implements ISearchFilterService{

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private MapperUtil mapperUtil;


    @Override
    public List<ProductDTO> findProductByCityAndDates(Long cityId, LocalDate checkInDate, LocalDate checkOutDate) {
        return mapperUtil.mapAll(productRepository.findProductByCityAndDates(cityId, checkInDate, checkOutDate), ProductDTO.class);
    }

    @Override
    public List<ProductDTO> findProductByDates(LocalDate checkInDate, LocalDate checkOutDate) {
        return mapperUtil.mapAll(productRepository.findProductByDates(checkInDate, checkOutDate), ProductDTO.class);
    }




}
