package com.shoppingmallloyality.login;

public class User {
	private long id;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String mobileNumber;
	private String emailId;
	private String dateOfBirth;
	private String gender;
	private String city;
	private String state;
	private String country;
	private String lastLogin;

	public User() {
		super();
	}

	public User(String userName, String firstName, String lastName,
			String password, String mobileNumber, String emailId,
			String dateOfBirth, String city, String state, String country) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + ", password="
				+ password + ", mobileNumber=" + mobileNumber + ", emailId="
				+ emailId + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", city=" + city + ", state=" + state + ", country="
				+ country + ", lastLogin=" + lastLogin + "]";
	}
}
