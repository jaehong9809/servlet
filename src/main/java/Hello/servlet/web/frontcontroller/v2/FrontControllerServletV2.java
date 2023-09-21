package Hello.servlet.web.frontcontroller.v2;

import Hello.servlet.web.frontcontroller.MyView;
import Hello.servlet.web.frontcontroller.v1.Controllerv1;
import Hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import Hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import Hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {
    private Map<String, Controllerv2> controllerv1Map = new HashMap<>();

    public FrontControllerServletV2() {
        controllerv1Map.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerv1Map.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerv1Map.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        Controllerv2 controllerv2 = controllerv1Map.get(requestURI);
        if(controllerv2==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        MyView view = controllerv2.process(request, response);
        view.render(request, response);
    }
}
