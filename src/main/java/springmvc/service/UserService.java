package springmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	public void process(List<String> filePath);

}
