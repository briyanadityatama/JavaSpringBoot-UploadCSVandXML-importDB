package com.springmvc.integration.middleware.spring.boot.upload.service;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.integration.middleware.spring.boot.upload.dao.UserDao;

public class UserserviceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	public void process(List<String> filePath) throws JAXBException {
		userDao.process(filePath);
				
	}
	

}
