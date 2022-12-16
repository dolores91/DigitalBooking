package pfig3.bookingg3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pfig3.bookingg3.model.entity.Product;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByCategory(Long categoryId);
    public List<Product> findByCity(Long cityId);

    public List<Product> findProductByCityAndDates(Long cityId, LocalDate checkInDate, LocalDate checkOutDate);
    public List<Product> findProductByDates(LocalDate checkInDate,LocalDate checkOutDate);

}
