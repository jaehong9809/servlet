package Hello.servlet.web.frontcontroller.v3.controller;

import Hello.servlet.domain.member.Member;
import Hello.servlet.domain.member.MemberRepository;
import Hello.servlet.web.frontcontroller.ModelView;
import Hello.servlet.web.frontcontroller.v3.Controllerv3;
import org.springframework.ui.Model;

import java.util.Map;

public class MemberSaveControllerV3 implements Controllerv3 {

    MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);
        return mv;
    }
}
