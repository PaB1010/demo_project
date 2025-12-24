package com.onedu.demo.member.controllers;

import com.onedu.demo.member.contants.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestJoin {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @Size(min=8, max=40)
    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;

    @NotBlank
    private String zipCode;

    @NotBlank
    private String address;

    private String addressSub;

    @NotBlank
    private String phoneNumber;

    @NotNull
    private Gender gender;

    @NotNull
    private LocalDate birthDt;
}
