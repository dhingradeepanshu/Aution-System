package com.iiht.training.auction.dto;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.iiht.training.auction.entity.CustomerEntity;

public class CustomerDto {

	private Long id;
    
    @NotNull
    @Size(min=3, max=100)
	private String username;
    
    @NotNull
    @Size(min=3, max=100)
	private String password;
    
    @NotNull
    @Size(min=3, max=100)
    @Email
	private String email;
    
    @NotNull
    private Long phoneNumber;
    
	@NotNull
    @Size(min=3, max=100)
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, email, id, password, phoneNumber, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDto other = (CustomerDto) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(username, other.username);
	}

    public CustomerEntity toCustomerEntity(){
        CustomerEntity entity = new CustomerEntity();

        entity.setUsername(this.username);
        entity.setPassword(this.password);
        entity.setEmail(this.email);
        entity.setPhoneNumber(this.phoneNumber);
        entity.setAddress(this.address);
        
        return entity;
    }
	
}
