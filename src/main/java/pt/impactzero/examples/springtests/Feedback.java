package pt.impactzero.examples.springtests;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Feedback {

	@NotNull
	private String name;

	@NotNull
	@Email
	private String email;

	@NotNull
	@Min(10)
	private String feedback;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the feedback
	 */
	public String getFeedback() {
		return feedback;
	}

	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}
