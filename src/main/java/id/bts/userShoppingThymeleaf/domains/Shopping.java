package id.bts.userShoppingThymeleaf.domains;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Shopping extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 629242692742436856L;

	private LocalDate createddate;
	private String name;

	public LocalDate getCreateddate() {
		return createddate;
	}

	public void setCreateddate(LocalDate createddate) {
		this.createddate = createddate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
