package br.com.essencialstore.userapi.controllers;

import br.com.essencialstore.userapi.dtos.UserDTO;
import br.com.essencialstore.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    public static List<UserDTO> users = new ArrayList<>();
    @PostConstruct
    public void initiateList(){
      UserDTO userDto = new UserDTO();
      userDto.setName("Keila Cardoso");
      userDto.setCpf("44455577700");
      userDto.setAddress("Rua Bernardo Silva");
      userDto.setEmail("keila@gmail.com");
      userDto.setContact("932323232");
      userDto.setRegistrationDate(new Date());

      UserDTO userDTO1 = new UserDTO();
      userDTO1.setName("Bruna Nascimento");
      userDTO1.setCpf("88899977733");
      userDTO1.setAddress("Rua Major de Freitas Veiga");
      userDTO1.setEmail("bruna@gmail.com");
      userDTO1.setContact("947474747");
      userDTO1.setRegistrationDate(new Date());

      users.add(userDto);
      users.add(userDTO1);

    }

    @GetMapping("/user/")
    public List<UserDTO> getUsers(){
        List<UserDTO> users = userService.getAll();
        return users;
    }
    @GetMapping("/user/{id}")
    UserDTO findById(@PathVariable Long id){
        return userService.findById(id);
    }
    @GetMapping("/user/cpf/{cpf}")
    UserDTO findByCpf(@PathVariable String cpf){
        return userService.findByCpf(cpf);
    }
    @GetMapping("/user/search")
    public List<UserDTO> queryByName(@RequestParam(name="name", required = true) String name){
        return userService.queryByName(name);
    }
    @PostMapping("/user")
    UserDTO newUser(@RequestBody UserDTO userDto){
        return userService.save(userDto);
    }
    @DeleteMapping("user/{id}")
    UserDTO delete(@PathVariable Long id){
        return userService.delete(id);
    }



}
