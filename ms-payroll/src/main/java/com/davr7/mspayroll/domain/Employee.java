package com.davr7.mspayroll.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Employee  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private Job job;
}
