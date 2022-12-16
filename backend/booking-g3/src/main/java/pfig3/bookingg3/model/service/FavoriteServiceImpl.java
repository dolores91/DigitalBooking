package pfig3.bookingg3.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfig3.bookingg3.model.dto.FavoriteDTO;
import pfig3.bookingg3.model.entity.Favorite;
import pfig3.bookingg3.model.repository.IFavoriteRepository;
import pfig3.bookingg3.util.MapperUtil;

import java.util.List;
import java.util.Map;
@Service
public class FavoriteServiceImpl implements IFavoriteService {

    @Autowired
    private IFavoriteRepository favoriteRepository;

    @Autowired
    private MapperUtil mapperUtil;


    @Override
    public List<FavoriteDTO> findAll() {
        return mapperUtil.mapAll(favoriteRepository.findAll(), FavoriteDTO.class);
    }

    @Override
    public FavoriteDTO findById(Long id) {
        return mapperUtil.map(favoriteRepository.findById(id), FavoriteDTO.class);
    }

    @Override
    public long countByProductAndCustomer(Long productId, Long userId) {
        return favoriteRepository.countByProductAndCustomer(productId, userId);
    }

    @Override
    public FavoriteDTO save(FavoriteDTO favorite) {
        return mapperUtil.map(favoriteRepository.save(mapperUtil.map(favorite, Favorite.class)), FavoriteDTO.class);
    }

    @Override
    public FavoriteDTO update(FavoriteDTO favorite, Long id) {
        Favorite favoriteUpdated = favoriteRepository.findById(id).orElse(null);
        if (favoriteUpdated == null) {
            // error
        }
        Favorite favoriteNewData = mapperUtil.map(favorite, Favorite.class);
        favoriteUpdated.setUser(favoriteNewData.getUser());
        favoriteUpdated.setProduct(favoriteNewData.getProduct());
        return mapperUtil.map(favoriteRepository.save(favoriteUpdated), FavoriteDTO.class);
    }

    @Override
    public FavoriteDTO delete(Long id) {
        FavoriteDTO bookingDeleted = mapperUtil.map(favoriteRepository.findById(id), FavoriteDTO.class);
        favoriteRepository.delete(mapperUtil.map(bookingDeleted, Favorite.class));
        return bookingDeleted;
    }
}
