package com.orgs.orgs.controller.handlers

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorHandlers {

    @ExceptionHandler(value=[IllegalArgumentException::class])
    fun illegalArgumentExceptions(request: HttpServletRequest, exception: Exception): ResponseEntity<ErrorResponse>{
        val errorResponse = ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.message!!)
        return ResponseEntity.badRequest().body(errorResponse)
    }
}

data class ErrorResponse(val statusCode: Int, val message: String)