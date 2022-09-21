package br.com.hmb_user.service;

import br.com.hmb_user.dto.RoleDto;
import br.com.hmb_user.dto.UserDto;
import br.com.hmb_user.model.RoleModel;
import br.com.hmb_user.model.UserModel;
import br.com.hmb_user.repository.UserRepository;
import br.com.hmb_user.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleService roleService;

    public UserModel save(UserDto userDto){
        UserModel user = new UserModel();
        List<RoleModel> roles = new ArrayList<>();
        BeanUtils.copyProperties(userDto, user);

        for (RoleDto dto: userDto.getRoles()) {
            user.getRoles().add(roleService.findById(dto.getId()).get());
        }
        BeanUtils.copyProperties(userDto.getRoles(), user.getRoles());
        return userRepository.save(user);
    }

    public Optional<UserModel> findById(Long id){
        return userRepository.findById(id);
    }

    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

    public void delete(Long id) throws Exception{
        Optional<UserModel> user = findById(id);
        if(user.get().getId() != null){
            userRepository.delete(user.get());
        }else{
            throw new Exception("User não existe!");
        }
    }
}
