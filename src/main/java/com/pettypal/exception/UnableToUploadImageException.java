package com.pettypal.exception;


public class UnableToUploadImageException extends RuntimeException{
 	/**
	 * 
	 */
	private static final long serialVersionUID = 9060751397339719682L;
	
	private String message = "Unable to upload this image ";
	
 	public UnableToUploadImageException() {}
	
	public UnableToUploadImageException( String message) {
		

		if (message != null) this.message = message;
		
	}
	
	public String getFullMessage() {
		return (message);
	}
	
	
@Override
public String getLocalizedMessage() {
	// TODO Auto-generated method stub
	return super.getLocalizedMessage();
}


}
