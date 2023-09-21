package Hello.servlet.web.frontcontroller.v3.controller;

import Hello.servlet.web.frontcontroller.ModelView;
import Hello.servlet.web.frontcontroller.v3.Controllerv3;

import java.util.Map;

public class MemberFormControllerV3 implements Controllerv3 {
    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
