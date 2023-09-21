package Hello.servlet.web.frontcontroller.v1;

import Hello.servlet.web.frontcontroller.v1.Controller.MemberFormControllerV1;
import Hello.servlet.web.frontcontroller.v1.Controller.MemberListControllerV1;
import Hello.servlet.web.frontcontroller.v1.Controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {
    private Map<String, Controllerv1> controllerv1Map = new HashMap<>();

    public FrontControllerServletV1() {
        controllerv1Map.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerv1Map.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerv1Map.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        Controllerv1 controllerv1 = controllerv1Map.get(requestURI);
        if(controllerv1==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controllerv1.process(request, response);

    }
}
