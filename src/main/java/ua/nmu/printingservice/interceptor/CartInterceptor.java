package ua.nmu.printingservice.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ua.nmu.printingservice.persistence.repository.CartRepository;
import ua.nmu.printingservice.security.model.SecurityUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class CartInterceptor extends HandlerInterceptorAdapter {

    private final CartRepository cartRepository;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        if (modelAndView != null) {
            var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (!"anonymousUser".equals(principal)) {
                SecurityUser user = (SecurityUser) principal;
                int itemsCount = cartRepository.findByActiveAndUser_Id(true, user.getId()).getItemsCount();
                modelAndView.addObject("cartItemsCount", itemsCount);
            }
        }
    }
}
