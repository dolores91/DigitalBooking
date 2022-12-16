package pfig3.bookingg3.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfig3.bookingg3.model.dto.ImageDTO;
import pfig3.bookingg3.model.entity.Image;
import pfig3.bookingg3.model.repository.IImageRepository;
import pfig3.bookingg3.util.MapperUtil;

import java.util.List;


@Service
public class ImageServiceImpl implements IImageService{

    @Autowired IImageRepository imageRepository;

    @Autowired MapperUtil mapperUtil;


    @Override
    public List<ImageDTO> findAll() {return mapperUtil.mapAll(imageRepository.findAll(), ImageDTO.class);
    }

    @Override
    public ImageDTO findById(Long id) {
        return mapperUtil.map(imageRepository.findById(id), ImageDTO.class);
    }

    @Override
    public ImageDTO save(ImageDTO image) {
        return mapperUtil.map(imageRepository.save(mapperUtil.map(image, Image.class)), ImageDTO.class);
    }

    @Override
    public ImageDTO update(ImageDTO image, Long id) {
        Image imageUpdated = imageRepository.findById(id).orElse(null);
        if(imageUpdated == null){
            //error
        }
        Image imageNewData = mapperUtil.map(image, Image.class);
        imageUpdated.setTitle(imageNewData.getTitle());
        imageUpdated.setDescription(imageNewData.getDescription());
        imageUpdated.setUrl(imageNewData.getDescription());
        imageUpdated.setProduct_idproduct(imageNewData.getProduct_idproduct());
        return mapperUtil.map(imageRepository.save(imageUpdated), ImageDTO.class);
    }


    public ImageDTO delete(Long id) {
        ImageDTO imageDeleted = mapperUtil.map(imageRepository.findById(id), ImageDTO.class);
        imageRepository.delete(mapperUtil.map(imageDeleted, Image.class));
        return imageDeleted;
    }

    @Override
    public List<ImageDTO> findByProductId(Long productId) {
        return mapperUtil.mapAll(imageRepository.findByProductId(productId), ImageDTO.class);
    }

}
