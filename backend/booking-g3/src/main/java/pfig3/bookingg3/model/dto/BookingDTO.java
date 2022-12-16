package pfig3.bookingg3.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfig3.bookingg3.model.dto.jwt.UserDTO;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingDTO {
    private Long id;
    private LocalTime checkInTime;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private ProductDTO product;
    private UserDTO user;
}
