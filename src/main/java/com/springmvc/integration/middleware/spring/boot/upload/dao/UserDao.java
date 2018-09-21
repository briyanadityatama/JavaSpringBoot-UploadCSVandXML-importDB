package com.springmvc.integration.middleware.spring.boot.upload.dao;

import java.util.List;

import javax.xml.bind.JAXBException;

public interface UserDao {
	
	public void process(List<String> filesPath) throws JAXBException ;

}
