package Hello.servlet.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.rmi.server.ServerCloneException;

public interface Controllerv1 {

    void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

}
