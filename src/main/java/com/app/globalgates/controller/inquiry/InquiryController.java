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
@RequestMapping("/inquiry")
@RequiredArgsConstructor
@Slf4j
public class InquiryController {

    @GetMapping("/chart")
    public String goToInquiryPage(@AuthenticationPrincipal CustomUserDetails userDetails) {
        if (!isExpert(userDetails)) {
            return "redirect:/main/main";
        }
        return "Inquiry/inquiry-chart";
    }

    @GetMapping("/member-list")
    public String goToInquiryMemberList(@AuthenticationPrincipal CustomUserDetails userDetails) {
        if (!isExpert(userDetails)) {
            return "redirect:/main/main";
        }
        return "Inquiry/Inquiry_list";
    }

    private boolean isExpert(CustomUserDetails userDetails) {
        return userDetails != null && userDetails.getMemberRole() == MemberRole.EXPERT;
    }
}
