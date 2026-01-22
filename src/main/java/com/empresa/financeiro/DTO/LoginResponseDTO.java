package com.empresa.financeiro.DTO;


public class LoginResponseDTO {

    private String email;

    public LoginResponseDTO(String email) {
        this.email = email;
    }

    public LoginResponseDTO() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
