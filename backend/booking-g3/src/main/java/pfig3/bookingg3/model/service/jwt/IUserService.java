package pfig3.bookingg3.model.service.jwt;

import pfig3.bookingg3.model.dto.jwt.UserDTO;

import java.util.List;

public interface IUserService {

    public UserDTO findByEmail(String email);
    public List<UserDTO> findAll();
    public UserDTO findById(Long id);
    public UserDTO save(UserDTO user);
    public UserDTO update(UserDTO user, Long id);
    public UserDTO delete(Long id);
}
