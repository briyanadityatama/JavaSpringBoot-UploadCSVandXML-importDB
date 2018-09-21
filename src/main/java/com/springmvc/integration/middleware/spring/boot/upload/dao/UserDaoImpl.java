package com.springmvc.integration.middleware.spring.boot.upload.dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

import com.springmvc.integration.middleware.spring.boot.upload.model.User;
import com.springmvc.integration.middleware.spring.boot.upload.utils.CommonUtils;

@Component
public class UserDaoImpl implements UserDao {
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}


	public void process(List<String> filesPath) throws JAXBException {
		List<User> list = new ArrayList<User>();
		
		//read data
		for(String filePath : filesPath) {
			if(CommonUtils.getFileExtension(filePath).equals("csv")) {
				//read csv file
				list.addAll(CommonUtils.readCsv(filePath));
			} else if(CommonUtils.getFileExtension(filePath).equals("xml")) {
				//read xml file
				list.addAll(CommonUtils.readXml(filePath));
			}
		}
		//import data
		importData(list);
	}
	
	public void importData(List<User> list) {
		String sql = "INSERT INTO user(id,name) VALUES (:id, :name)";
		
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(list.toArray());
		
		namedParameterJdbcTemplate.batchUpdate(sql, batch);
	}

}
