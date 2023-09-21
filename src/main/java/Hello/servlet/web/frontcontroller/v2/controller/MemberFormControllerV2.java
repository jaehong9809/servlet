package Hello.servlet.web.frontcontroller.v2.controller;

import Hello.servlet.web.frontcontroller.MyView;
import Hello.servlet.web.frontcontroller.v2.Controllerv2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV2 implements Controllerv2 {
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
