package br.com.hmb_user.service;

import br.com.hmb_user.dto.RoleDto;
import br.com.hmb_user.model.RoleModel;
import br.com.hmb_user.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public RoleModel save(RoleDto roleDto){
        RoleModel role = new RoleModel();
        BeanUtils.copyProperties(roleDto, role);
        return roleRepository.save(role);
    }

    public Optional<RoleModel> findById(Long id){
        return roleRepository.findById(id);
    }

    //public List<RoleModel> findAllByState(Long idState){        return roleRepository.getAllByState(idState);   }

    public List<RoleModel> findAll(){
        return roleRepository.findAll();
    }

    public void delete(Long id) throws Exception{
        Optional<RoleModel> role = findById(id);
        if(role.get().getId() != null){
            roleRepository.delete(role.get());
        }else{
            throw new Exception("Role não existe!");
        }
    }
}
