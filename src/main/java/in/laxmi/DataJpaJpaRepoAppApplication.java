package in.laxmi;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import ch.qos.logback.core.net.SyslogOutputStream;
import in.laxmi.entity.Employee;
import in.laxmi.repo.EmployeeRepository;

@SpringBootApplication
public class DataJpaJpaRepoAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(DataJpaJpaRepoAppApplication.class, args);
	   EmployeeRepository repository = ctxt.getBean(EmployeeRepository.class);
	System.out.println(repository.getClass().getName());
	
	
	/*Employee e1 = new Employee(2,"rani",30000,"female","testing");
	Employee e2 = new Employee(3,"raju",30000,"female","associate");
	Employee e3 = new Employee(4,"ramu",30000,"male","develop");
	Employee e4 = new Employee(5,"nag",30000,"male","manager");
	Employee e5 = new Employee(6,"soheil",30000,"male","devops");

	repository.saveAll(Arrays.asList(e1,e2,e3,e4,e5));*/
	
	//sorting using Jpa repository methods
	Sort sorting = Sort.by("empName","empSalary").descending();
	List<Employee> emps = repository.findAll(sorting);
	emps.forEach(System.out::println);
	
	//display pagable 
	int pageNo = 2;
	PageRequest pr = PageRequest.of(pageNo-1,3);
	Page<Employee> emp = repository.findAll(pr);
	emp.forEach(System.out::println);
	
	//By using query By example(QBE)
	Employee em = new Employee();
	em.setEmpGender("female");
	em.setDept("hr");
	Example<Employee> of = Example.of(em);
	List<Employee> all = repository.findAll(of);
	all.forEach(System.out::println);
	//by using generators
	Employee emp1 = new Employee();
	emp1.setEmpName("ramanji");
	emp1.setEmpSalary(17000);
	emp1.setEmpGender("male");
	emp1.setDept("sales");
	repository.save(emp1);
	
	
	}


}
