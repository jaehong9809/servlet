package Hello.servlet.web.frontcontroller.v2.controller;

import Hello.servlet.domain.member.Member;
import Hello.servlet.domain.member.MemberRepository;
import Hello.servlet.web.frontcontroller.MyView;
import Hello.servlet.web.frontcontroller.v2.Controllerv2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements Controllerv2 {
    MemberRepository memberRepository=MemberRepository.getInstance();
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);

        return new MyView("/WEB-INF/views/members.jsp");
    }
}
