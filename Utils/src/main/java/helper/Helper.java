package helper;

import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class Helper {

	/**
	 * Generating Alphabets String randomly.
	 * 
	 * @param length
	 * @return
	 */
	public static String generateRandomAlphabetsString(int length) {
		Random rd = new Random();
		String aphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			sb.append(aphaNumericString.charAt(rd.nextInt(aphaNumericString
					.length())));
		}

		return sb.toString();
	}

	/**
	 * Generating key value pair from given string in format (a=b,c=d,e=f)
	 * 
	 * @param input
	 * @param param
	 * @return Map.
	 */
	public static Map<String, String> generate_key_value(String input,
			Map<String, String> param) {
		// TODO Auto-generated method stub
		String temp = "";
		if (input.indexOf("=") != -1) {

			if (input.indexOf(",") != -1) {
				temp = input.substring(0, input.indexOf(",")).trim();
				input = input.substring(input.indexOf(",") + 1, input.length());
			} else {
				temp = input.trim();
				input = "";
			}

			param.put(temp.substring(0, temp.indexOf("=")).trim(),
					temp.substring(temp.indexOf("=") + 1, temp.length()));

			return generate_key_value(input, param);
		} else
			return param;
	}

	/**
	 * Picking "," separated from given string and putting in list
	 * 
	 * @param input
	 * @return List.
	 */
	public static LinkedList remove_comma_delimeter(String input) {
		// TODO Auto-generated method stub
		LinkedList data = new LinkedList();
		if (input.contains(",")) {
			while (input.indexOf(",") != -1) {
				data.add(input.substring(0, input.indexOf(",")));
				input = input.substring(input.indexOf(",") + 1, input.length());
			}

		} else
			data.add(input);

		return data;
	}
}