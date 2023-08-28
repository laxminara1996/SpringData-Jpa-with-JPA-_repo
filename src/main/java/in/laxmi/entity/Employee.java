package in.laxmi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "empl_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer empId;
	private String empName;
	private Integer empSalary;
	private String empGender;
	private String dept;
	@CreationTimestamp
	@Column(name="createdDate", updatable=false)
	private LocalDate createdDate;
	@UpdateTimestamp
	@Column(name="updatedDare",insertable=false)
	private LocalDate updatedDate;
}
