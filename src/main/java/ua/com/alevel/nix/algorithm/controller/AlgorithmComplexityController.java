package ua.com.alevel.nix.algorithm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.alevel.nix.algorithm.data.DataContainer;
import ua.com.alevel.nix.algorithm.service.AlgorithmComplexityService;

import java.util.List;

/**
 * @author Iehor Funtusov, created 01/07/2020 - 1:58 AM
 */

@Controller
@RequestMapping(path = { "/", "/algorithm_complexity" })
public class AlgorithmComplexityController {

    private final AlgorithmComplexityService algorithmComplexityService;

    public AlgorithmComplexityController(AlgorithmComplexityService algorithmComplexityService) {
        this.algorithmComplexityService = algorithmComplexityService;
    }

    @GetMapping
    public String getAlgorithmComplexityPage() {
        return "algorithm_complexity";
    }

    @PostMapping("/orderConstant")
    public ResponseEntity<DataContainer<Integer>> orderConstant(@RequestBody int input) {
        return ResponseEntity.ok(algorithmComplexityService.orderConstant(input));
    }

    @PostMapping("/orderLinear")
    public ResponseEntity<DataContainer<Integer>> orderLinear(@RequestBody int input) {
        return ResponseEntity.ok(algorithmComplexityService.orderLinear(input));
    }

    @PostMapping("/orderLogarithmic")
    public ResponseEntity<DataContainer<Integer>> orderLogarithmic(@RequestBody String input) {
        String[] inputString = input.split(" ");
        int capacity = Integer.parseInt(inputString[0]);
        int find = Integer.parseInt(inputString[1]);
        return ResponseEntity.ok(algorithmComplexityService.orderLogarithmic(capacity, find));
    }

    @PostMapping("/orderLinearLogarithmic")
    public ResponseEntity<DataContainer<List<Integer>>> orderLinearLogarithmic(@RequestBody String input) {
        return ResponseEntity.ok(algorithmComplexityService.orderLinearLogarithmic(input));
    }
}
