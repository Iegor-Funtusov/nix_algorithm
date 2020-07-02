package ua.com.alevel.nix.algorithm.service;

import ua.com.alevel.nix.algorithm.data.DataContainer;

import java.util.List;

/**
 * @author Iehor Funtusov, created 01/07/2020 - 2:09 AM
 */
public interface AlgorithmComplexityService {

    DataContainer<Integer> orderConstant(int capacity);
    DataContainer<Integer> orderLinear(int capacity);
    DataContainer<Integer> orderLogarithmic(int capacity, int find);
    DataContainer<List<Integer>> orderLinearLogarithmic(String stream);
}
