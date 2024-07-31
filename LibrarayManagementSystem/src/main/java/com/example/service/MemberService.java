package com.example.service;

import java.util.List;

import com.example.entities.Member;
import com.example.model.MemberDTO;

public interface MemberService {
	public MemberDTO saveMemberInfo(Member member);
	public List<MemberDTO> getAllMemberInfo();
	MemberDTO getByMemberId(int mid);
	String deleteMemberInfoById(int mid);
	MemberDTO updateMemberInfo(int mid,Member member);
}
