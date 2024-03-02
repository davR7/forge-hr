package com.davr7.mspayroll.domain;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Job implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String profession;
    private Double dailyIncome;
    private Set<Employee> employees = new HashSet<>();

    public Job(String id, String profession, Double dailyIncome) {
        this.id = id;
        this.profession = profession;
        this.dailyIncome = dailyIncome;
    }
}
