package br.com.essencialstore.userapi.dtos;

import br.com.essencialstore.userapi.model.User;

public class ConverterDTO {
    public static UserDTO convert(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setAddress(user.getAddress());
        userDTO.setCpf(user.getCpf());
        return userDTO;
    }
}
