package com.yaalis.savefarmer.savefarmer.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FarmerBean {

	@Id
	private String id;
	private String name;
	private String loanAmount;
	private String monthsDue;
	private double amountPending;
	private int contributorsCount;
	private String accountNumber;
	private int age;
	private String reason;

	public double getAmountPending() {
		return amountPending;
	}

	public void setAmountPending(double amountPending) {
		this.amountPending = amountPending;
	}

	public int getContributorsCount() {
		return contributorsCount;
	}

	public void setContributorsCount(int contributorsCount) {
		this.contributorsCount = contributorsCount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getMonthsDue() {
		return monthsDue;
	}

	public void setMonthsDue(String monthsDue) {
		this.monthsDue = monthsDue;
	}

}
