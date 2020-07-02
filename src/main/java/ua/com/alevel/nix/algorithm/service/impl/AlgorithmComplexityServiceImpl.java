package ua.com.alevel.nix.algorithm.service.impl;

import org.springframework.stereotype.Service;

import ua.com.alevel.nix.algorithm.data.DataContainer;
import ua.com.alevel.nix.algorithm.service.AlgorithmComplexityService;
import ua.com.alevel.nix.algorithm.util.AlgorithmUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Iehor Funtusov, created 01/07/2020 - 2:09 AM
 */
@Service
public class AlgorithmComplexityServiceImpl implements AlgorithmComplexityService {

    @Override
    public DataContainer<Integer> orderConstant(int capacity) {
        int[] arr = new int[capacity];
        long start = System.currentTimeMillis();
        int res = arr.length;
        long end = System.currentTimeMillis() - start;
        return new DataContainer<>(res, end);
    }

    @Override
    public DataContainer<Integer> orderLinear(int capacity) {
        int[] arr = new int[capacity];
        int sum = 0;
        long start = System.currentTimeMillis();
        for (int i : arr) {
            sum += i;
        }
        long end = System.currentTimeMillis() - start;
        return new DataContainer<>(sum, end);
    }

    @Override
    public DataContainer<Integer> orderLogarithmic(int capacity, int find) {
        int[] arr = new int[capacity];
        for (int i : arr) {
            arr[i] = i;
        }
        long start = System.currentTimeMillis();
        int res = AlgorithmUtil.binarySearch(arr, find, arr[0], arr.length - 1);
        long end = System.currentTimeMillis() - start;
        return new DataContainer<>(res, end);
    }

    @Override
    public DataContainer<List<Integer>> orderLinearLogarithmic(String stream) {
        int[] arr = AlgorithmUtil.getArrayByNumberStream(stream);
        long start = System.currentTimeMillis();
        int[] res = AlgorithmUtil.sortMergeArray(arr);
        long end = System.currentTimeMillis() - start;
        List<Integer> integerList =  Arrays.stream(res).boxed().collect(Collectors.toList());
        return new DataContainer<>(integerList, end);
    }
}
