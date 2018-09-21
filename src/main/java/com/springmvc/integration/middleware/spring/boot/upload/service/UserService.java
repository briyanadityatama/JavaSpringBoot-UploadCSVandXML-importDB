package com.springmvc.integration.middleware.spring.boot.upload.service;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	public void process(List<String> filePath) throws JAXBException;

}
