package com.technoplus.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.technoplus.cursomc.services.exceptions.DataIntegrityException;
import com.technoplus.cursomc.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	   @ExceptionHandler(ObjectNotFoundException.class)
       public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
    	   StandardError  err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),System.currentTimeMillis());
    	   
    	   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
       }
	   
	   @ExceptionHandler(DataIntegrityException.class)
	   public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request){
		   StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),System.currentTimeMillis());
		   
		   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		   
	   }
	   
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	   public ResponseEntity<StandardError>  validation(MethodArgumentNotValidException e, HttpServletRequest request){
		  ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		   
		  //acessar toda lista de error impressa na tela
		  for(ObjectError x : e.getBindingResult().getAllErrors()) {
			  System.out.print(x);
			    err.addError(x.getObjectName(),x.getDefaultMessage());
		  }
		 
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		   
	   }
	   
} 
 