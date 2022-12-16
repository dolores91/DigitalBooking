package pfig3.bookingg3.model.service;

import pfig3.bookingg3.model.dto.CityDTO;

import java.util.List;

public interface ICityService {
    public List<CityDTO> findAll();
    public CityDTO findById(Long id);
    public CityDTO save(CityDTO city);
    public CityDTO update(CityDTO city, Long id);
    public CityDTO delete(Long id);
}
