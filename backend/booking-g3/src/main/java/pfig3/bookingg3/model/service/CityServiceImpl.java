package pfig3.bookingg3.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfig3.bookingg3.model.dto.CityDTO;
import pfig3.bookingg3.model.entity.City;
import pfig3.bookingg3.model.repository.ICityRepository;
import pfig3.bookingg3.util.MapperUtil;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService{

    @Autowired
    private ICityRepository cityRepository;

    @Autowired
    private MapperUtil mapperUtil;


    @Override
    public List<CityDTO> findAll() {
        return mapperUtil.mapAll(cityRepository.findAll(), CityDTO.class);
    }

    @Override
    public CityDTO findById(Long id) {
        return mapperUtil.map(cityRepository.findById(id), CityDTO.class);
    }

    @Override
    public CityDTO save(CityDTO city) {
        return mapperUtil.map(cityRepository.save(mapperUtil.map(city, City.class)), CityDTO.class);
    }

    @Override
    public CityDTO update(CityDTO city, Long id) {
        City cityUpdated = cityRepository.findById(id).orElse(null);
        if(cityUpdated == null){
            //error
        }
        cityUpdated.setName(city.getName());
        cityUpdated.setCountry(city.getCountry());
        return mapperUtil.map(cityRepository.save(cityUpdated), CityDTO.class);
    }

    @Override
    public CityDTO delete(Long id) {
        CityDTO cityDeleted = mapperUtil.map(cityRepository.findById(id), CityDTO.class);
        cityRepository.delete(mapperUtil.map(cityDeleted, City.class));
        return cityDeleted;
    }
}
