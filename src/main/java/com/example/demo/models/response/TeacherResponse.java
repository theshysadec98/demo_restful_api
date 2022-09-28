package com.example.demo.models.response;

import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@Getter
@Setter
public class TeacherResponse {

    private String fullName;

    private String phone;

    private String email;

    private Instant dateOfBirth;

    public String gender;

    private String address;

    private String status;

    private Instant createDate;

    private String createBy;

    private Instant updateDate;

    private String updateBy;
}
