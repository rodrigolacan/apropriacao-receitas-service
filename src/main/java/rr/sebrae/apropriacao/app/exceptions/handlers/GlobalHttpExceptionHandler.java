package rr.sebrae.apropriacao.app.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import rr.sebrae.apropriacao.app.exceptions.http.ResourceNotFoundException;

import java.util.Map;

@RestControllerAdvice
public class GlobalHttpExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception e) {
        Map<String, Object> errorResponse = Map.of(
                "type", "https://httpstatuses.com/500",
                "title", "Internal Server Error",
                "status", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "detail", "Ocorreu um erro interno: " + e.getMessage(),
                "instance", "/rest"
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(NoHandlerFoundException ex) {
        Map<String, Object> errorResponse = Map.of(
                "type", "https://httpstatuses.com/404",
                "title", "Not Found",
                "status", HttpStatus.NOT_FOUND.value(),
                "detail", "A URL solicitada não foi encontrada",
                "instance", ex.getRequestURL()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex) {
        Map<String, Object> errorResponse = Map.of(
                "type", "https://httpstatuses.com/405",
                "title", "Method Not Allowed",
                "status", HttpStatus.METHOD_NOT_ALLOWED.value(),
                "detail", "O método HTTP " + ex.getMethod() + " não é suportado para esta solicitação",
                "instance", "/rest"  // Isso pode ser ajustado conforme a URL da sua API
        );

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorResponse);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException e) {
        Map<String, Object> errorResponse = Map.of(
                "type", "https://httpstatuses.com/404",
                "title", "Resource Not Found",
                "status", HttpStatus.NOT_FOUND.value(),
                "detail", e.getMessage(),
                "instance", "/rest"
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String, Object>> handleBadCredentialsException(BadCredentialsException ex) {
        Map<String, Object> errorResponse = Map.of(
                "type", "https://httpstatuses.com/401",
                "title", "Unauthorized",
                "status", HttpStatus.UNAUTHORIZED.value(),
                "detail", "Credenciais inválidas: " + ex.getMessage(),
                "instance", "/rest"
        );

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }
}
