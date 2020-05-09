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
                var cart = cartRepository.findByActiveAndUser_Id(true, user.getId());
                modelAndView.addObject("itemsCount", cart.getItemsCount());
                modelAndView.addObject("totalPrice", cart.getTotalPrice());
            } else {
                modelAndView.addObject("itemsCount", 0);
                modelAndView.addObject("totalPrice", 0);
            }
        }
    }
}
