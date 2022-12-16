package pfig3.bookingg3.model.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {
    private Long id;
    private String name;
    private String country;
}
