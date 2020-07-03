package ua.com.alevel.nix.algorithm.data;

import java.util.Comparator;

/**
 * @author Iehor Funtusov, created 03/07/2020 - 4:11 PM
 */
public class SortMakeCodeByWeight implements Comparator<MakeCode> {

    @Override
    public int compare(MakeCode m1, MakeCode m2) {
        return m1.getWeight() - m2.getWeight();
    }
}
