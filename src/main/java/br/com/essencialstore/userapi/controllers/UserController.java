package br.com.essencialstore.userapi.controllers;

import br.com.essencialstore.userapi.dtos.UserDto;
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
    public static List<UserDto> users = new ArrayList<>();
    @PostConstruct
    public void initiateList(){
      UserDto userDto = new UserDto();
      userDto.setName("Keila Cardoso");
      userDto.setCpf("44455577700");
      userDto.setAddress("Rua Bernardo Silva");
      userDto.setEmail("keila@gmail.com");
      userDto.setContact("932323232");
      userDto.setRegistrationDate(new Date());

      UserDto userDto1 = new UserDto();
      userDto1.setName("Bruna Nascimento");
      userDto1.setCpf("88899977733");
      userDto1.setAddress("Rua Major de Freitas Veiga");
      userDto1.setEmail("bruna@gmail.com");
      userDto1.setContact("947474747");
      userDto1.setRegistrationDate(new Date());

      users.add(userDto);
      users.add(userDto1);

    }

    @GetMapping("/user/")
    public List<UserDto> getUsers(){
        List<UserDto> users = userService.getAll();
        return users;
    }
    @GetMapping("/user/{id}")
    UserDto findById(@PathVariable Long id){
        return userService.findById(id);
    }
    @GetMapping("/user/cpf/{cpf}")
    UserDto findByCpf(@PathVariable String cpf){
        return userService.findByCpf(cpf);
    }
    @GetMapping("/user/search")
    public List<UserDto> queryByName(@RequestParam(name="name", required = true) String name){
        return userService.queryByName(name);
    }
    @PostMapping("/user")
    UserDto newUser(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }
    @DeleteMapping("user/{id}")
    UserDto delete(@PathVariable Long id){
        return userService.delete(id);
    }



}
