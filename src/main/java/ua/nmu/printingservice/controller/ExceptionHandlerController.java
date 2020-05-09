package ua.nmu.printingservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.nmu.printingservice.exeptions.EntryNotFoundException;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(Model model, AccessDeniedException exception) {
        log.warn(exception.getMessage(), exception);

        model.addAttribute("status", "403");
        model.addAttribute("errorMsg", "Access denied");
        return "/error/errorPage";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntryNotFoundException.class)
    public String handleEntryNotFoundException(Model model, EntryNotFoundException exception) {
        log.warn(exception.getMessage(), exception);

        model.addAttribute("status", "404");
        model.addAttribute("errorMsg", exception.getMessage());
        return "/error/errorPage";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String handleError(Exception exception, Model model) {
        log.error(exception.getMessage(), exception);

        ResponseStatus annotation = AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class);
        if (annotation != null) {
            model.addAttribute("status", annotation.value().value());
            model.addAttribute("errorMsg", annotation.value().getReasonPhrase());
        } else {
            model.addAttribute("status", "500");
            model.addAttribute("errorMsg", "Oops... something went wrong :-(");
        }

        return "/error/errorPage";
    }

}
