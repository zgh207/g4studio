package org.g4studio.core.web.util;

/**
 * Web系统主题色系配置
 * 
 * @author 熊春
 * @since 2008-09-22
 */
public class ThemeUtils {
	
	/**
	 * 获取和主题色匹配的深色系
	 */
	public static String getColor1(String theme){
		String color1 = "white";
		if (theme.equalsIgnoreCase("lightRed")) {
			color1 = "#F8D1E3";
		}else if (theme.equalsIgnoreCase("default")) {
			color1 = "#92BDE7";
		}else if (theme.equalsIgnoreCase("lightYellow")) {
			color1 = "#E3BC92";
		}else if (theme.equalsIgnoreCase("gray")) {
			color1 = "#CCC7CC";
		}else if (theme.equalsIgnoreCase("lightGreen")) {
			color1 = "#A1F7B5";
		}else if (theme.equalsIgnoreCase("purple2")) {
			color1 = "#D5B7F1";
		}
		return color1;
	}
	
	/**
	 * 获取和主题色匹配的中色系
	 */
	public static String getColor2(String theme){
		String color2 = "white";
		if (theme.equalsIgnoreCase("lightRed")) {
			color2 = "#FCE3FB";
		}else if (theme.equalsIgnoreCase("default")) {
			color2 = "#BCD6F0";
		}else if (theme.equalsIgnoreCase("lightYellow")) {
			color2 = "#ECD2B6";
		}else if (theme.equalsIgnoreCase("gray")) {
			color2 = "#D5D2D5";
		}else if (theme.equalsIgnoreCase("lightGreen")) {
			color2 = "#BDF9CB";
		}else if (theme.equalsIgnoreCase("purple2")) {
			color2 = "#E1CCF5";
		}
		return color2;
	}
	
	/**
	 * 获取和主题色匹配的浅色系
	 */
	public static String getColor3(String theme){
		String color3 = "white";
		if (theme.equalsIgnoreCase("lightRed")) {
			color3 = "#FCF3FB";
		}else if (theme.equalsIgnoreCase("default")) {
			color3 = "#D5E6F6";
		}else if (theme.equalsIgnoreCase("lightYellow")) {
			color3 = "#F6E9DB";
		}else if (theme.equalsIgnoreCase("gray")) {
			color3 = "#E9E7E9";
		}else if (theme.equalsIgnoreCase("lightGreen")) {
			color3 = "#E3FCE9";
		}else if (theme.equalsIgnoreCase("purple2")) {
			color3 = "#F0E5FA";
		}
		return color3;
	}
}
