package Hello.servlet.web.frontcontroller.v3.controller;

import Hello.servlet.domain.member.Member;
import Hello.servlet.domain.member.MemberRepository;
import Hello.servlet.web.frontcontroller.ModelView;
import Hello.servlet.web.frontcontroller.v3.Controllerv3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements Controllerv3 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);

        return mv;
    }
}
