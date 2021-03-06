package codesquad.security;

import codesquad.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class SecurityControllerAdvice {
    private static final Logger log = LoggerFactory.getLogger(SecurityControllerAdvice.class);

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public void emptyResultData() {
        log.debug("EntityNotFoundException is happened!");
    }

    @ExceptionHandler(UnAuthorizedException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public void unAuthorized() {
        log.debug("UnAuthorizedException is happened!");
    }

    @ExceptionHandler(UnAuthenticationException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public void unAuthentication() {
        log.debug("UnAuthenticationException is happened!");
    }

    @ExceptionHandler(CannotUpdateException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public void cannotUpdateException(){
        log.debug("cannotUpdateException is happened!");
    }

    @ExceptionHandler(CannotDeleteException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public void CannotDeleteException(){
        log.debug("cannotDeleteException is happened!");
    }

    @ExceptionHandler(CannotApplyException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public void CannotApplyException(){
        log.debug("CannotApplyException is happened!");
    }
}
