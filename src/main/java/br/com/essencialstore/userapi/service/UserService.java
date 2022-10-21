package br.com.essencialstore.userapi.service;

import br.com.essencialstore.userapi.dtos.UserDto;
import br.com.essencialstore.userapi.model.User;
import br.com.essencialstore.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAll(){
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDto::convert).collect(Collectors.toList());
    }

    public UserDto findById(long userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return UserDto.convert(user.get());
        }
        return null;
    }
    public UserDto save(UserDto userDto){
        User user = userRepository.save(User.convert(userDto));
        return UserDto.convert(user);
    }
    public UserDto delete(long userId){
        Optional<User> user = userRepository.findById((userId));
        if(user.isPresent()){
            userRepository.delete(user.get());
        }
        return null;
    }
    public UserDto findByCpf(String cpf){
        User user = userRepository.findByCpf(cpf);
        if(user != null){
            return UserDto.convert(user);
        }
        return null;
    }
    public List<UserDto> queryByName(String name){
        List<User> users = userRepository.queryByNameLike(name);
        return users.stream().map(UserDto::convert).collect(Collectors.toList());
    }
}
