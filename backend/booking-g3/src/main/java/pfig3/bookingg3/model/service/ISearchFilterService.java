package pfig3.bookingg3.model.service;

import pfig3.bookingg3.model.dto.ProductDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ISearchFilterService {

    public List<ProductDTO> findProductByCityAndDates(Long cityId, LocalDate checkInDate, LocalDate checkOutDate);
    public List<ProductDTO> findProductByDates(LocalDate checkOutDate, LocalDate checkInDate);

}