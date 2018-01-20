package com.yaalis.savefarmer.savefarmer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaalis.savefarmer.savefarmer.bean.FarmerBean;
import com.yaalis.savefarmer.savefarmer.bean.UserBean;

@Service
public class AppService {

	@Autowired
	MyrepositoryFarmerBean repo;

	public List<FarmerBean> fetchFarmerDetails() {
		List<FarmerBean> farmerDetails = new ArrayList<>();
		try {
			repo.findAll().forEach(farmerDetails::add);
		} catch (Exception e) {
			e.getMessage();
		}
		return farmerDetails;
	}

	public List<FarmerBean> fetchFarmerIndividualDetails(String farmerID) {
		List<FarmerBean> farmerDetails = new ArrayList<>();
		FarmerBean details = new FarmerBean();
		try {

			details.setId(repo.findOne(farmerID).getId());
			details.setAccountNumber(repo.findOne(farmerID).getAccountNumber());
			details.setAge(repo.findOne(farmerID).getAge());
			details.setAmountPending(repo.findOne(farmerID).getAmountPending());
			details.setContributorsCount(repo.findOne(farmerID).getContributorsCount());
			details.setLoanAmount(repo.findOne(farmerID).getLoanAmount());
			details.setMonthsDue(repo.findOne(farmerID).getMonthsDue());
			details.setName(repo.findOne(farmerID).getName());
			details.setReason(repo.findOne(farmerID).getReason());
			farmerDetails.add(details);
		} catch (Exception e) {
			e.getMessage();
		}
		return farmerDetails;
	}

	@Autowired
	MyrepositoryUserDonated user;

	public String saveDonatedUser(UserBean bean) {
		boolean flag = false;
		String transactionMessage = null;
		String farmerId = bean.getFarmerId();
		double amount = bean.getAmountPaid();
		try {
			transactionMessage = updateFarmerBeanValues(farmerId, amount);
			if (repo.findOne(farmerId) != null) {
				user.save(bean);
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		if (flag) {
			return "Transaction Completed, " + transactionMessage;
		} else {
			return "Error in Transaction, " + transactionMessage;
		}
	}

	public String updateFarmerBeanValues(String identifier, double amount) {
		boolean flagValue;
		try {
			FarmerBean fB = repo.findOne(identifier);
			fB.setAmountPending(fB.getAmountPending() - amount);
			fB.setContributorsCount(fB.getContributorsCount() + 1);
			repo.save(fB);
			flagValue = true;
		} catch (Exception e) {
			flagValue = false;
			e.getMessage();
		}
		if (flagValue) {
			return "Updation Done Successfully";
		} else {
			return "Error in Updation";
		}

	}

	public List<UserBean> fetchAllContributors() {
		List<UserBean> uBean = new ArrayList<>();
		try {
			user.findAll().forEach(uBean::add);
		} catch (Exception e) {
			e.getMessage();
		}
		return uBean;
	}

}
