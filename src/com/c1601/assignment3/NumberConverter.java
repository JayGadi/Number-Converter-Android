package com.c1601.assignment3;

public class NumberConverter {
  
	//convert input value to decimal value
  public String toDecimal(String t){
	  
	  //error check
	  if(t.length() > 2){
		  
		  String prefix = t.substring(0,2);
		  String suffix = t.substring(2); 
		  
		  if(prefix.equals("h:")){
			  Integer outputDecimal = Integer.parseInt(suffix,16);
			  return outputDecimal.toString();
		  }
		  else if(prefix.equals("b:")){
			  Integer outputDecimal = Integer.parseInt(suffix,2);
			  return outputDecimal.toString();
		  }
		  else if(prefix.equals("d:")){
			  return suffix;
		  }
		  else{
			  return "error";
		  }
	  }
	  else{
		  return "error";
	  }
}
  	
  //change input value to binary value
  public String toBinary(String t){
	  
	  //error check
	  if(t.length() > 2){
		  String prefix = t.substring(0,2);
		  String suffix = t.substring(2); 
		  if(prefix.equals("d:")){
			  return Integer.toBinaryString(Integer.parseInt(suffix));
		  }
		  else if(prefix.equals("h:")){
			  return Integer.toBinaryString(Integer.parseInt(suffix,16));
		  }
		  else if(prefix.equals("b:")){
			  return suffix;
		  }
		  else{
			  return "error";
		  }
	  	}
	  	else{
	  		return "error";
	  	}
  }
  
  //change input value to hex value
  public String toHex(String t){
	  
	  //error check
	  if(t.length() > 2){
		  String prefix = t.substring(0,2);
		  String suffix = t.substring(2); 
		  if(prefix.equals("d:")){
			  return (Integer.toHexString(Integer.parseInt(suffix))).toUpperCase();
		  }
		  else if(prefix.equals("b:")){
			  return (Integer.toHexString(Integer.parseInt(suffix,2))).toUpperCase();
		  }
		  else if(prefix.equals("h:")){
			  return suffix;
		  }
		  else{
			  return "error";
		  }
	  }
	  else{
		  return "error";
	  }
  }
}