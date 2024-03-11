package com.myLearning.springBoot.mailer.service;


public interface IPurchaseOrder {

	public String purchase(String[] items, Double[] price, String[] toEmail) throws Exception;

}
