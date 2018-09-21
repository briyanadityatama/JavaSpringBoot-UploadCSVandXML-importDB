package springmvc.service;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;

import springmvc.dao.UserDao;

public class UserserviceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	public void process(List<String> filePath) throws JAXBException {
		userDao.process(filePath);
				
	}
	

}
