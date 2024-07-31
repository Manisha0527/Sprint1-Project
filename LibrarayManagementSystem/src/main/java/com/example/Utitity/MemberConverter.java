package com.example.Utitity;

import org.springframework.beans.BeanUtils;

import com.example.entities.Member;
import com.example.model.MemberDTO;

public class MemberConverter {
	public Member convertToMemberEntity(MemberDTO memberDTO) {
		Member member=new Member();
		if(memberDTO!=null) {
			BeanUtils.copyProperties(memberDTO, member);
		}
		
		return member;
	}
	public MemberDTO convertToMemberDTO(Member member) {
		
		MemberDTO memberDTO=new MemberDTO();
		if(member!=null) {
			
			BeanUtils.copyProperties(member, memberDTO);
		}
		return memberDTO;
	}

}
