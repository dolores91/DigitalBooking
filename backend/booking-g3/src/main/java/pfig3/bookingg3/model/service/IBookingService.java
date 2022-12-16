package pfig3.bookingg3.model.service;


import pfig3.bookingg3.model.dto.BookingDTO;

import java.util.List;

public interface IBookingService {
    public List<BookingDTO> findAll();
    public BookingDTO findById(Long id);
    public List<BookingDTO> findByUserId(Long userId);
    public BookingDTO save(BookingDTO booking);
    public BookingDTO update(BookingDTO booking, Long id);
    public BookingDTO delete(Long id);
}
