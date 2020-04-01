package com.prueba.people;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RutVerificador {

	 public static boolean validar(String rut){
		 			rut = rut.replace(".", "");
			 Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
			 Matcher matcher = pattern.matcher(rut);
				if ( matcher.matches() == false ) return false;
	    	
	        int suma=0;
	        String dvR,dvT;
	        int[] serie = {2,3,4,5,6,7};
	       
	        rut = rut.replace("-", "");
	        dvR = rut.substring(rut.length()-1);
	        for(int i = rut.length()-2;i>=0; i--){
	            suma +=  Integer.valueOf(rut.substring(i, i+1))
	                    *serie[(rut.length()-2-i)%6];
	        }
	        dvT=String.valueOf(11-suma%11);
	        if(dvT.compareToIgnoreCase("10") == 0){
	            dvT = "K";
	        }

	        if(dvT.compareToIgnoreCase(dvR) == 0){
	            return true;
	        } else {
	            return false;
	        }
	    }
	
	

}
	
	
