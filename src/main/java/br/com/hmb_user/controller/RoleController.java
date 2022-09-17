package br.com.hmb_user.controller;

import br.com.hmb_user.dto.RoleDto;
import br.com.hmb_user.model.RoleModel;
import br.com.hmb_user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/role")
public class RoleController {


    @Autowired
    RoleService roleService;


    @PostMapping("")
    public ResponseEntity createClient(@RequestBody RoleDto roleDto){

        RoleModel role = roleService.save(roleDto);

        return new ResponseEntity(role, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        return new ResponseEntity(roleService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity findAll(){
        return new ResponseEntity(roleService.findAll(),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) throws Exception {
        roleService.delete(id);
        return new ResponseEntity("Produto " + id + " excluido com sucesso", HttpStatus.OK);
    }
}
