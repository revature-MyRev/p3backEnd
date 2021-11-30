package com.revature.myrev.model;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dipanjali Ghosh
 * */

import org.junit.jupiter.api.Test;

class UsersTest {

	@Test
	void usersConstructorTest() {
		Users testUser = new Users();
		assertNotNull(testUser, "Constructor failed");
	}

	@Test
	void userIDGetterTest() {
		Users testUser = new Users();
		assertEquals(0, testUser.getUserId());
	}

	@Test
	void userIDSetterTest() {
		int test = 1;
		Users testUser = new Users();
		testUser.setUserId(test);
		assertEquals(test, testUser.getUserId());
	}

	@Test
	void ageGetterTest() {
		Users testUser = new Users();
		assertEquals(0, testUser.getAge());
	}

	@Test
	void ageSetterTest() {
		int test = 26;
		Users testUser = new Users();
		testUser.setAge(test);
		assertEquals(test, testUser.getAge());
	}

	@Test
	void userNameGetterTest() {
		Users testUser = new Users();
		assertNull(testUser.getUserName(), "testUser.username not null");
	}

	@Test
	void userNameSetterTest() {
		String test = "testUserName";
		Users testUser = new Users();
		testUser.setUserName(test);
		assertEquals(0, testUser.getUserName().compareTo(test));
	}

	@Test
	void passwordGetterTest() {
		Users testUser = new Users();
		assertNull(testUser.getPassword(), "testUser.password not null");
	}

	@Test
	void passwordSetterTest() {
		String test = "testPassword";
		Users testUser = new Users();
		testUser.setPassword(test);
		assertEquals(0, testUser.getPassword().compareTo(test));
	}

	@Test
	void genderGetterTest() {
		Users testUser = new Users();
		assertNull(testUser.getGender(), "testUser.gender not null");
	}

	@Test
	void genderSetterTest() {
		String test = "Non-Binary";
		Users testUser = new Users();
		testUser.setGender(test);
		assertEquals(0, testUser.getGender().compareTo(test));
	}

	@Test
	void photoGetterTest() {
		Users testUser = new Users();
		assertNull(testUser.getPhoto(), "testUser.photo not null");
	}

	@Test
	void photoSetterTest() {
		String test = "testPhoto.jpg";
		Users testUser = new Users();
		testUser.setPhoto(test);
		assertEquals(0, testUser.getPhoto().compareTo(test));
	}

	@Test
	void emailGetterTest() {
		Users testUser = new Users();
		assertNull(testUser.getEmail(), "testUser.email not null");
	}

	@Test
	void emailSetterTest() {
		String test = "first.last@revature.net";
		Users testUser = new Users();
		testUser.setEmail(test);
		assertEquals(0, testUser.getEmail().compareTo(test));
	}

	@Test
	void firstNameGetterTest() {
		Users testUser = new Users();
		assertNull(testUser.getFirstName(), "testUser.firstName not null");
	}

	@Test
	void firstNameSetterTest() {
		String test = "First";
		Users testUser = new Users();
		testUser.setFirstName(test);
		assertEquals(0, testUser.getFirstName().compareTo(test));
	}

	@Test
	void lastNameGetterTest() {
		Users testUser = new Users();
		assertNull(testUser.getLastName(), "testUser.lastName not null");
	}

	@Test
	void lastNameSetterTest() {
		String test = "Last";
		Users testUser = new Users();
		testUser.setLastName(test);
		assertEquals(0, testUser.getLastName().compareTo(test));
	}

	@Test
	void middleNameGetterTest() {
		Users testUser = new Users();
		assertNull(testUser.getMiddleName(), "testUser.middleName not null");
	}

	@Test
	void middleNameSetterTest() {
		String test = "Middle";
		Users testUser = new Users();
		testUser.setMiddleName(test);
		assertEquals(0, testUser.getMiddleName().compareTo(test));
	}

	@Test
	void jobTitleGetterTest() {
		Users testUser = new Users();
		assertNull(testUser.getJobTitle(), "testUser.jobTitle not null");
	}

	@Test
	void jobTitleSetterTest() {
		String test = "testJobTitle";
		Users testUser = new Users();
		testUser.setJobTitle(test);
		assertEquals(0, testUser.getJobTitle().compareTo(test));
	}

	@Test
	void usersToStringTest() {
		String test = "User [userId=" + "0" + ", age=" + "0" + ", userName=" + "null" + ", gender=" + "null"
				+ ", photo=" + "null" + ", email=" + "null" + ", firstName=" + "null" + ", lastName=" + "null"
				+ ", middleName=" + "null" + ", jobTitle=" + "null" + "]";
		Users testUser = new Users();
//		System.out.println("test = " + test);	// These two print statements were added to figure out just what happens with toString
//		System.out.println("testUser.toString() = " + testUser);
		assertEquals(0, testUser.toString().compareTo(test));
	}

	@Test
	void usersConstructorWithParamsTest() {
		int userId = 1;
		int age = 26;
		String userName = "testUserName";
		String password = "testPassword";
		String gender = "Non-binary";
		String photo = "testPhoto.jpg";
		String email = "first.last@revature.net";
		String firstName = "First";
		String lastName = "Last";
		String middleName = "Middle";
		String jobTitle = "testJobTitle";
		String test = "User [userId=" + userId + ", age=" + age + ", userName=" + userName + ", gender=" + gender
				+ ", photo=" + photo + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", jobTitle=" + jobTitle + "]";
		Users testUser = new Users(userId, age, userName, password, gender, photo, email, firstName, lastName,
				middleName, jobTitle);
		assertEquals(0, testUser.toString().compareTo(test));
	}
}
