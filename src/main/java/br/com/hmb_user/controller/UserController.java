package br.com.hmb_user.controller;

import br.com.hmb_user.dto.UserDto;
import br.com.hmb_user.model.UserModel;
import br.com.hmb_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("")
    public ResponseEntity createClient(@RequestBody UserDto userDto){

        UserModel user = userService.save(userDto);

        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        return new ResponseEntity(userService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity findAll(){
        return new ResponseEntity(userService.findAll(),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) throws Exception {
        userService.delete(id);
        return new ResponseEntity("Usuario " + id + " excluido com sucesso", HttpStatus.OK);
    }
}
