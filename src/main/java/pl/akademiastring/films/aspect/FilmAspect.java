package pl.akademiastring.films.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.akademiastring.films.service.EmailServiceIml;
import pl.akademiastring.films.service.FilmService;

@Aspect
@Component
public class FilmAspect {

    @Value("${send.email.to}")
    private String to;
    private EmailServiceIml emailServiceIml;
    private FilmService filmService;

    @Autowired
    public FilmAspect(EmailServiceIml emailServiceIml, FilmService filmService) {
        this.emailServiceIml = emailServiceIml;
        this.filmService = filmService;
    }

    @Around("@annotation(FilmAnno)")
    private void sendMailWithAddedFilm(ProceedingJoinPoint joinPoint) throws Throwable {
        joinPoint.proceed();
        String text = filmService.getFilms().toString();
        String subject = "Film list from app";
        emailServiceIml.sendMessage(to, subject, text);

    }
}
