package lk.ijse.security_backend.exception;

import io.jsonwebtoken.ExpiredJwtException;
import lk.ijse.security_backend.dto.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.NameNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIResponse handleUseNameNotFoundException(Exception e) {
        return new APIResponse(
                HttpStatus.NOT_FOUND.value(),
                "Username not found",
                e.getMessage()
        );
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public APIResponse handleBadCredentialsException(BadCredentialsException e) {
        return new APIResponse(
                HttpStatus.UNAUTHORIZED.value(),
                "Username or password is incorrect",
                e.getMessage()
        );
    }

    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public APIResponse handleExpiredJwtException(ExpiredJwtException e) {
        return new APIResponse(
                HttpStatus.UNAUTHORIZED.value(),
                "expired token",
                e.getMessage()
        );
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public APIResponse handleRuntimeException(RuntimeException e) {
        return new APIResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "error occurred",
                e.getMessage()
        );
    }

}