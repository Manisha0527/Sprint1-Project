package com.example.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Utitity.MemberConverter;
import com.example.entities.Book;
import com.example.entities.Member;
import com.example.model.BookDTO;
import com.example.model.MemberDTO;
import com.example.repository.MemberRepository;
import com.example.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
public MemberRepository memberRepository;
	@Autowired
	MemberConverter memberConverter;
	@Override
	public MemberDTO saveMemberInfo(Member member) {
		// TODO Auto-generated method stub
		Member m= memberRepository.save(member);
		return memberConverter.convertToMemberDTO(m);
	}
	@Override
	public List<MemberDTO> getAllMemberInfo() {
		// TODO Auto-generated method stub
		List<Member>members= memberRepository.findAll();
		List<MemberDTO> mtoa=new ArrayList<>();
		for(Member m:members) {
		mtoa.add(memberConverter.convertToMemberDTO(m));
		}
		return mtoa;
	}
	@Override
	public MemberDTO getByMemberId(int mid) {
		// TODO Auto-generated method stub
		Member m= memberRepository.findById(mid).get();
		return memberConverter.convertToMemberDTO(m);
	}
	@Override
	public String deleteMemberInfoById(int mid) {
		// TODO Auto-generated method stub
		memberRepository.deleteById(mid);
		return "Member Deleted";
	}
	@Override
	public MemberDTO updateMemberInfo(int mid, Member member) {
		// TODO Auto-generated method stub
		Member m=memberRepository.findById(mid).get();
		m.setName(member.getName());
		m.setMtype(member.getMtype());
		m.setExpdate(member.getExpdate());
		m.setEdate(member.getEdate());
		m.setAddress(member.getAddress());
		Member mm=memberRepository.save(m);
		return memberConverter.convertToMemberDTO(mm);
	}
}