package rr.sebrae.apropriacao.app.exceptions.handlers;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.Map;

@RestControllerAdvice
public class GlobalDatabaseExceptionHandler {

    // Tratar erro de DataAccessException
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Map<String, Object>> handleDataAccessException(DataAccessException e) {
        Map<String, Object> errorResponse = Map.of(
                "type", "https://httpstatuses.com/500",
                "title", "Database Error",
                "status", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "detail", "Erro ao acessar o banco de dados: " + e.getMessage(),
                "instance", "/rest/database"
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    // Tratar erro de SQLException
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Map<String, Object>> handleSQLException(SQLException e) {
        Map<String, Object> errorResponse = Map.of(
                "type", "https://httpstatuses.com/500",
                "title", "Database Error",
                "status", HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "detail", "Erro de SQL: " + e.getMessage(),
                "instance", "/rest/database"
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    // Tratar erro genérico de exceção no banco de dados
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
}
