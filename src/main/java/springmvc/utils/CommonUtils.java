package springmvc.utils;

public class CommonUtils {
	
	public static String getFileExtension(String name) {
		if(name.lastIndexOf(".") != -1 && name.lastIndexOf(".") != 0) {
			return name.substring(name.lastIndexOf(".") + 1);
		} else {
			return "";
		}
	}

}
