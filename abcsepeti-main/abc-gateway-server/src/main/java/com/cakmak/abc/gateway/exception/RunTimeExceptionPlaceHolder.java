package com.cakmak.abc.gateway.exception;

/**
 * @author: Halil Cakmak, Date : 2019-05-20
 */
public class RunTimeExceptionPlaceHolder extends RuntimeException {

  int httpStatus;

  public RunTimeExceptionPlaceHolder(String message, int httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
  }

  public int getHttpStatus() {
    return httpStatus;
  }

}
