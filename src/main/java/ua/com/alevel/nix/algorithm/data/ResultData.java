package ua.com.alevel.nix.algorithm.data;

import java.util.List;

/**
 * @author Iehor Funtusov, created 03/07/2020 - 4:09 PM
 */
public class ResultData {

    private String text;
    private String resultText;
    private String binaryText;
    private String binaryCompressText;
    private List<MakeCode> makeCodes;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public String getBinaryText() {
        return binaryText;
    }

    public void setBinaryText(String binaryText) {
        this.binaryText = binaryText;
    }

    public String getBinaryCompressText() {
        return binaryCompressText;
    }

    public void setBinaryCompressText(String binaryCompressText) {
        this.binaryCompressText = binaryCompressText;
    }

    public List<MakeCode> getMakeCodes() {
        return makeCodes;
    }

    public void setMakeCodes(List<MakeCode> makeCodes) {
        this.makeCodes = makeCodes;
    }
}
