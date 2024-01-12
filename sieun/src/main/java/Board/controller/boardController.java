package Board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class boardController {
    private final boardService boardService;

    @GetMapping("/boards/post")
    public String postForm() {
        return "post";
    }

    @PostMapping("/boards/post")
    public String article(@ModelAttribute boardDto boardDto) {
        System.out.println("boardDto = " + boardDto );
        boardService.post(boardDto);
        return "index";
    }

    @GetMapping("boards/")
    public String findAll(Model model) {
        List<boardDto> boardDtoList = boardService.findAll();
        model.addAttribute("boardList", boardDtoList);
        return "list";
    }

    @GetMapping("/boards/{id}")
    public String findById(@PathVariable Long id, Model model) {
        boardDto boardDto = boardService.finById(id);
        model.addAttribute("board", boardDto);
        return "detail";
    }

    @GetMapping("boards/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        boardDto boardDto = boardService.finById(id);
        model.addAttribute("boardUpdate", boardDto);
        return "update";
    }

    @PostMapping("/boards/update")
    public String update(@ModelAttribute boardDto boardDto, Model model) {
        boardDto board = boardService.update(boardDto);
        model.addAttribute("board", board);
        return "detail";
    }

    @GetMapping("/boards/delete/{id}")
    public String delete(@PathVariable Long id) {
        boardService.delete(id);
        return "redirect:/boards/";
    }

}
