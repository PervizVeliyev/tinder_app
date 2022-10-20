package utility;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;
import java.util.UUID;

public class Session {
    private static final String COOKIE_NAME = "user_id";

    public static Optional<Cookie> findUser(HttpServletRequest rq) {
        Cookie[] cookies = rq.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(COOKIE_NAME)) {
                    return Optional.of(cookie);
                }
            }
        }
        return Optional.empty();
    }

    public static Cookie findOrThrow(HttpServletRequest rq) {
        return findUser(rq)
                .orElseThrow(() -> new RuntimeException("Something went wrong!"));
    }

    public static Cookie newRandom() {
        return new Cookie(COOKIE_NAME, UUID.randomUUID().toString());
    }

}
