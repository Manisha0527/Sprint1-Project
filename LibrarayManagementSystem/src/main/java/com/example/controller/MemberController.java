package com.example.controller;
//when want to add own methods then we have to add controller nad service package;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Utitity.MemberConverter;
import com.example.entities.Member;
import com.example.model.MemberDTO;
import com.example.service.MemberService;
import ch.qos.logback.core.pattern.Converter;


@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired
private MemberService memberService;
	@Autowired
	MemberConverter memberConverter;
	@PostMapping("/add")
	ResponseEntity<MemberDTO> add(@RequestBody MemberDTO memberDTO) {
		  final	Member member=memberConverter.convertToMemberEntity(memberDTO);
			return new  ResponseEntity<MemberDTO>(memberService.saveMemberInfo(member),HttpStatus.CREATED);
	}
		@GetMapping("/getAll")
		public List<MemberDTO> getAllMemberInfo(){
			return memberService.getAllMemberInfo();
		}
		@GetMapping("/getByMemberId/{mId}")
		public MemberDTO getByMemberId(@PathVariable("mId")  int mid) {
			
			
			return memberService.getByMemberId(mid);
		}

		@DeleteMapping("/deleteMemberById/{mId}")
		public String deleteMemberById(@PathVariable("mId")  int mid ) {
			// TODO Auto-generated method stub
			return memberService.deleteMemberInfoById(mid);
		}

	   @PutMapping("/updateMember/{mId}")
		public MemberDTO updateMember( @PathVariable("mId") int mid,@RequestBody Member member) {
			// TODO Auto-generated method stub
		   return memberService.updateMemberInfo(mid, member);
		}
	}


