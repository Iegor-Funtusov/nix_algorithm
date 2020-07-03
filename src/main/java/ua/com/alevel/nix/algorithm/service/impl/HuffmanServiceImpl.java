package ua.com.alevel.nix.algorithm.service.impl;

import org.springframework.stereotype.Service;

import ua.com.alevel.nix.algorithm.data.MakeCode;
import ua.com.alevel.nix.algorithm.data.ResultData;
import ua.com.alevel.nix.algorithm.data.SortMakeCodeByWeight;
import ua.com.alevel.nix.algorithm.data.compress.Huffman;
import ua.com.alevel.nix.algorithm.data.compress.Tree;
import ua.com.alevel.nix.algorithm.service.HuffmanService;
import ua.com.alevel.nix.algorithm.util.AlgorithmUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class HuffmanServiceImpl implements HuffmanService {

    @Override
    public ResultData run(String text) {
        if (text != null && text.length() != 0) {
            Tree.initMakeCodes();
            ResultData resultData = new ResultData();
            resultData.setText(text);
            resultData.setBinaryText(AlgorithmUtil.convertToBinary(text));
            int[] data = new int[text.length()];
            for (int i = 0; i < text.length(); i++) {
                data[i] = text.charAt(i);
            }
            int max = Arrays.stream(data).summaryStatistics().getMax();
            Huffman h = new Huffman(max + 1);
            h.growTree(data);
            h.makeCode();
            text = h.coder(data);
            resultData.setBinaryCompressText(text);
            resultData.setResultText(h.decoder(text));
            List<MakeCode> makeCodes = Tree.getMakeCodes();
            Collections.sort(makeCodes, new SortMakeCodeByWeight());
            resultData.setMakeCodes(makeCodes);
            return resultData;
        } else {
            return null;
        }
    }
}
