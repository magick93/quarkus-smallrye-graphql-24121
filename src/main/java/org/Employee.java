package org;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {
    @Id
	@GeneratedValue
	@EqualsAndHashCode.Include
    private Long id;
    private String firstName;
	private String lastName;
	private String position;
	private int salary;
	private int age;
}
