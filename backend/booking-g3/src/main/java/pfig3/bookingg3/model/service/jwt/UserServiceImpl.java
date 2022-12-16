package pfig3.bookingg3.model.service.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfig3.bookingg3.model.dto.jwt.UserDTO;
import pfig3.bookingg3.model.entity.jwt.User;
import pfig3.bookingg3.model.repository.jwt.IUserRepository;
import pfig3.bookingg3.util.MapperUtil;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {


    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public UserDTO findByEmail(String email) {
        return mapperUtil.map(userRepository.findByEmail(email), UserDTO.class);
    }

    @Override
    public List<UserDTO> findAll() {
        return mapperUtil.mapAll(userRepository.findAll(), UserDTO.class);
    }

    @Override
    public UserDTO findById(Long id) {
        return  mapperUtil.map(userRepository.findById(id), UserDTO.class);
    }

    @Override
    public UserDTO save(UserDTO user) {
        return mapperUtil.map(userRepository.save(mapperUtil.map(user, User.class)), UserDTO.class);
    }

    @Override
    public UserDTO update(UserDTO user, Long id) { User userUpdated = userRepository.findById(id).orElse(null);
        if (userUpdated == null) {
            // error
        }
        User userNewData = mapperUtil.map(user, User.class);
        userUpdated.setName(userNewData.getName());
        userUpdated.setIdNumber(userNewData.getIdNumber());
        userUpdated.setEmail(userNewData.getEmail());
        userUpdated.setSurname(userNewData.getSurname());
        userUpdated.setPassword(userNewData.getPassword());
        userUpdated.setRole(userNewData.getRole());
        return mapperUtil.map(userRepository.save(userUpdated), UserDTO.class);
    }

    @Override
    public UserDTO delete(Long id) {
        UserDTO userDeleted = mapperUtil.map(userRepository.findById(id), UserDTO.class);
        userRepository.delete(mapperUtil.map(userDeleted, User.class));
        return userDeleted;
    }
}
