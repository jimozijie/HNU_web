package cn.shuangzeit.szweb.controller;

import cn.shuangzeit.szweb.domain.Notice;
import cn.shuangzeit.szweb.repository.NoticeRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
@CrossOrigin
public class NoticeController {
    private final  NoticeRepository noticeRepository;
    @GetMapping("/notices")
    public String listNotice(Model model){
        val list=noticeRepository.findAll();
        model.addAttribute("notices",list);
        return "noticeList";
    }
}
