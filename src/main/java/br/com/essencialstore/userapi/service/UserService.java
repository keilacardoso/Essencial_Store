package br.com.essencialstore.userapi.service;

import br.com.essencialstore.userapi.dtos.UserDTO;
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

    public List<UserDTO> getAll(){
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::convert).collect(Collectors.toList());
    }

    public UserDTO findById(long userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return UserDTO.convert(user.get());
        }
        return null;
    }
    public UserDTO save(UserDTO userDto){
        User user = userRepository.save(User.convert(userDto));
        return UserDTO.convert(user);
    }
    public UserDTO delete(long userId){
        Optional<User> user = userRepository.findById((userId));
        if(user.isPresent()){
            userRepository.delete(user.get());
        }
        return null;
    }
    public UserDTO findByCpf(String cpf){
        User user = userRepository.findByCpf(cpf);
        if(user != null){
            return UserDTO.convert(user);
        }
        return null;
    }
    public List<UserDTO> queryByName(String name){
        List<User> users = userRepository.queryByNameLike(name);
        return users.stream().map(UserDTO::convert).collect(Collectors.toList());
    }
}
