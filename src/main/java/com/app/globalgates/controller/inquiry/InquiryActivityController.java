package com.app.globalgates.controller.inquiry;

import com.app.globalgates.auth.CustomUserDetails;
import com.app.globalgates.common.enumeration.MemberRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inquiry/activity/**")
@RequiredArgsConstructor
@Slf4j
public class InquiryActivityController {

    @GetMapping("list")
    public String goToInquiryActivityList(@AuthenticationPrincipal CustomUserDetails userDetails) {
        if (userDetails == null || userDetails.getMemberRole() != MemberRole.EXPERT) {
            return "redirect:/main/main";
        }
        return "Inquiry/inquiry_active_list";
    }
}
