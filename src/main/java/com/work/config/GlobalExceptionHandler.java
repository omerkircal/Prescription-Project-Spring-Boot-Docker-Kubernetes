package com.work.config;

import com.work.utils.REnum;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class, TransactionSystemException.class,
            ConstraintViolationException.class, DataIntegrityViolationException.class, HttpMessageConversionException.class,
            UnexpectedRollbackException.class})
    protected ResponseEntity<Object> myFnc(Exception ex) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        if (ex instanceof IllegalArgumentException) {
            IllegalArgumentException illegalArgumentException = (IllegalArgumentException) ex;
            hm.put(REnum.status, false);
            hm.put(REnum.error, illegalArgumentException.getMessage());
        }
        if (ex instanceof UnexpectedRollbackException) {
            UnexpectedRollbackException unexpectedRollbackException = (UnexpectedRollbackException) ex;
            hm.put(REnum.status, false);
            hm.put(REnum.error, unexpectedRollbackException.getMessage());
        }
        if (ex instanceof HttpMessageConversionException) {
            HttpMessageConversionException httpMessageConversionException = (HttpMessageConversionException) ex;
            hm.put(REnum.status, false);
            hm.put(REnum.error, httpMessageConversionException.getMessage());
        }
        if (ex instanceof IllegalStateException) {
            IllegalStateException illegalStateException = (IllegalStateException) ex;
            hm.put(REnum.status, false);
            hm.put(REnum.error, illegalStateException.getMessage());
        }
        if (ex instanceof TransactionSystemException) {
            TransactionSystemException transactionSystemException = (TransactionSystemException) ex;
            hm.put(REnum.status, false);
            hm.put(REnum.error, transactionSystemException.getMessage());
        }
        if (ex instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) ex;
            hm.put(REnum.status, false);
            hm.put(REnum.error, constraintViolationException.getMessage());
        }
        if (ex instanceof DataIntegrityViolationException) {
            DataIntegrityViolationException dataIntegrityViolationException = (DataIntegrityViolationException) ex;
            hm.put(REnum.status, false);
            hm.put(REnum.error, dataIntegrityViolationException.getMessage());
        }
        return new ResponseEntity<>(hm, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        List<FieldError> errors = ex.getFieldErrors();
        List<Map<String, String>> lss = new ArrayList<>();
        for (FieldError item : errors) {
            Map<String, String> hmx = new HashMap<>();
            String fieldName = item.getField();
            String message = item.getDefaultMessage();
            hmx.put(fieldName, message);
            lss.add(hmx);
        }
        hm.put(REnum.status, false);
        hm.put(REnum.error, lss);
        return new ResponseEntity<>(hm, HttpStatus.BAD_REQUEST);
    }
}