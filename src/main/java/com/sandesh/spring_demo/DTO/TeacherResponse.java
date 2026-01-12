package com.sandesh.spring_demo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponse {
    private Long id;
    private String name;
    private String subject;
    private String email;
    private String phone;
}
