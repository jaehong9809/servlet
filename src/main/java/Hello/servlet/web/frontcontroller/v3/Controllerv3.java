package Hello.servlet.web.frontcontroller.v3;

import Hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface Controllerv3 {
    ModelView process(Map<String, String> paramMap);
}
