package springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import springmvc.model.User;
import springmvc.utils.CommonUtils;

@Component
public class UserDaoImpl implements UserDao {
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}


	public void process(List<String> filesPath) {
		List<User> list = new ArrayList<User>();
		
		//read data
		for(String filePath : filesPath) {
			if(CommonUtils.getFileExtension(filePath).equals("csv")) {
				//read csv file
			} else if(CommonUtils.getFileExtension(filePath).equals("xml")) {
				//read xml file
			}
		}
	}

}
