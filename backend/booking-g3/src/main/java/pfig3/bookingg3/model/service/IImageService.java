package pfig3.bookingg3.model.service;


import pfig3.bookingg3.model.dto.BookingDTO;
import pfig3.bookingg3.model.dto.ImageDTO;

import java.util.List;

public interface IImageService {

    public List<ImageDTO> findAll();
    public ImageDTO findById(Long id);
    public ImageDTO save(ImageDTO image);
    public ImageDTO update(ImageDTO image, Long id);
    public ImageDTO delete(Long id);
    public List<ImageDTO> findByProductId(Long productId);
}
