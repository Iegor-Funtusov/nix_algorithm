package ua.com.alevel.nix.algorithm.data;

/**
 * @author Iehor Funtusov, created 01/07/2020 - 2:32 AM
 */
public class DataContainer<T> {

    private T result;
    private long time;

    public DataContainer() { }

    public DataContainer(T result, long time) {
        this.result = result;
        this.time = time;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
