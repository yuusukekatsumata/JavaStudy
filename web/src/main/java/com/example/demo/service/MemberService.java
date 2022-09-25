package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class MemberService{
    @Autowired
    MemberRepository repository;
   
    public List<Member> findAll(){
       return repository.findAll();
    }
   
     public Member findOne(Integer id) {
    Optional<Member> member = repository.findById(id);
    if(member.isPresent()) {
       return member.get();
    }else {
       return null;
    }
     }
   
    public Member save(Member member){
       return repository.save(member);
    }
   
    public void delete(Integer id){
       repository.deleteById(id);
    }
}