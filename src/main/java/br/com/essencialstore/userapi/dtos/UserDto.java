package br.com.essencialstore.userapi.dtos;

import br.com.essencialstore.userapi.model.User;

import java.util.Date;

public class UserDto {

    private String name;
    private String cpf;
    private String address;
    private String email;
    private String contact;
    private Date registrationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public static UserDto convert(User user){
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setCpf(user.getCpf());
        userDto.setAddress(user.getAddress());
        userDto.setEmail(user.getEmail());
        userDto.setContact(user.getContact());
        userDto.setRegistrationDate(user.getRegistrationDate());
        return userDto;

    }
}
