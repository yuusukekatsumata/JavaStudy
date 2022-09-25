package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
   
    @GetMapping
    public String index(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "index";
    }
   
    @GetMapping("new")
    public String newMember(Model model) {
    	Member member = new Member();
        model.addAttribute("member", member);
        return "new";
    }
   
    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        Member member = memberService.findOne(id);
        model.addAttribute("member", member);
        return "edit";
    }
   
    @PostMapping
    public String create(@Valid @ModelAttribute Member member, BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) return "new";
    	memberService.save(member);
        return "redirect:/member";
    }
    
    @PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @Validated @ModelAttribute Member member, BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) return "edit";
    	member.setId(id);
        memberService.save(member);
        return "redirect:/member";
    }
   
    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        memberService.delete(id);
        return "redirect:/member";
    }
}
