package util;

public class IntegerUtil {

	// number?
	public static boolean isNumber(String str){
		try{
			Integer.parseInt(str);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
