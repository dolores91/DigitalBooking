package pfig3.bookingg3.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfig3.bookingg3.model.dto.BookingDTO;
import pfig3.bookingg3.model.entity.Booking;
import pfig3.bookingg3.model.repository.IBookingRepository;
import pfig3.bookingg3.util.MapperUtil;

import java.util.List;

@Service
public class BookingServiceImpl implements IBookingService {
    @Autowired
    private IBookingRepository bookingRepository;

    @Autowired
    private MapperUtil mapperUtil;


    @Override
    public List<BookingDTO> findAll() {
        return mapperUtil.mapAll(bookingRepository.findAll(), BookingDTO.class);
    }

    @Override
    public BookingDTO findById (Long id){
        return mapperUtil.map(bookingRepository.findById(id), BookingDTO.class);
    }

    @Override
    public List<BookingDTO> findByUserId(Long id) {
        return mapperUtil.mapAll(bookingRepository.findByUserId(id), BookingDTO.class);
    }

//       SAve a booking --> This will have the available products already filtered by date and city (check (SearchFiltersController.java)

    @Override
    public BookingDTO save(BookingDTO booking) {
        return mapperUtil.map(bookingRepository.save(mapperUtil.map(booking, Booking.class)), BookingDTO.class);
    }

    @Override
    public BookingDTO update(BookingDTO booking, Long id) {
        Booking bookingUpdated = bookingRepository.findById(id).orElse(null);
            if (bookingUpdated == null) {
                // error
            }
            Booking bookingNewData = mapperUtil.map(booking, Booking.class);
            bookingUpdated.setCheckInTime(bookingNewData.getCheckInTime());
            bookingUpdated.setCheckInDate(bookingNewData.getCheckInDate());
            bookingUpdated.setCheckOutDate(bookingNewData.getCheckOutDate());
            bookingUpdated.setUser(bookingNewData.getUser());
            bookingUpdated.setProduct(bookingNewData.getProduct());
            return mapperUtil.map(bookingRepository.save(bookingUpdated), BookingDTO.class);
    }

    @Override
    public BookingDTO delete(Long id) {
        BookingDTO bookingDeleted = mapperUtil.map(bookingRepository.findById(id), BookingDTO.class);
        bookingRepository.delete(mapperUtil.map(bookingDeleted, Booking.class));
        return bookingDeleted;
    }
}