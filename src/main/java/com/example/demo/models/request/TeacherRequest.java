package com.example.demo.models.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class TeacherRequest {

    @NonNull
    private String fullName;

    @NonNull
    private String phone;

    @NonNull
    private String email;

    @NonNull
    private Instant dateOfBirth;

    @NonNull
    public String gender;

    private String address;

    private String status;
}
