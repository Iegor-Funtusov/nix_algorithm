package ua.com.alevel.nix.algorithm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.com.alevel.nix.algorithm.service.HuffmanService;

@Controller
@RequestMapping("/huffman")
public class HuffmanController {

    private final HuffmanService huffmanService;

    public HuffmanController(HuffmanService huffmanService) {
        this.huffmanService = huffmanService;
    }

    @GetMapping
    public String init() {
        return "huffman";
    }

    @PostMapping
    public String run(@ModelAttribute("text") String text, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("res", huffmanService.run(text));
        return "redirect:/huffman";
    }
}
