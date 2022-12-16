package pfig3.bookingg3.model.service.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfig3.bookingg3.model.dto.jwt.RoleDTO;
import pfig3.bookingg3.model.entity.jwt.Role;
import pfig3.bookingg3.model.repository.jwt.IRoleRepository;
import pfig3.bookingg3.util.MapperUtil;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private MapperUtil mapperUtil;

    @Override
    public List<RoleDTO> findAll() {
        return mapperUtil.mapAll(roleRepository.findAll(), RoleDTO.class);
    }

    @Override
    public RoleDTO findById(Long id) {
        return mapperUtil.map(roleRepository.findById(id), RoleDTO.class);
    }

    @Override
    public RoleDTO save(RoleDTO role) {
        return mapperUtil.map(roleRepository.save(mapperUtil.map(role, Role.class)), RoleDTO.class);
    }

    @Override
    public RoleDTO update(RoleDTO role, Long id) { Role roleUpdated = roleRepository.findById(id).orElse(null);
        if (roleUpdated == null) {
            // error
        }
        roleUpdated.setName(role.getName());
        roleUpdated.setActive(role.getActive());

        return mapperUtil.map(roleRepository.save(roleUpdated), RoleDTO.class);
    }

    @Override
    public RoleDTO delete(Long id) {
        RoleDTO roleDeleted = mapperUtil.map(roleRepository.findById(id), RoleDTO.class);
        roleRepository.delete(mapperUtil.map(roleDeleted, Role.class));
        return roleDeleted;
    }
}