package com.room414.textanalyzer.application.counters.wordcounter;

/**
 * @author Alexander Melashchenko
 * @version 1.0 17 Feb 2017
 */
public class Pair<T extends Comparable, T1 extends Comparable> implements Comparable<Pair<T, T1>> {
    private static final int HASH_CODE_INITIAL_VALUE = 17;
    private static final int HASH_CODE_MULTIPLIER = 37;

    private T firstValue;
    private T1 secondValue;

    public Pair() {
    }

    public Pair(T firstValue, T1 secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public T getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(T firstValue) {
        this.firstValue = firstValue;
    }

    public T1 getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(T1 secondValue) {
        this.secondValue = secondValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        Pair<T, T1> pair = (Pair<T, T1>) o;

        return pair.firstValue == this.firstValue && pair.secondValue == this.secondValue;
    }

    @Override
    public int hashCode() {
        int result = HASH_CODE_INITIAL_VALUE;

        result = HASH_CODE_MULTIPLIER * result + firstValue.hashCode();
        result = HASH_CODE_MULTIPLIER * result + secondValue.hashCode();

        return result;
    }

    @Override
    public int compareTo(Pair<T, T1> tt1Pair) {
        return this.secondValue.compareTo(tt1Pair.secondValue) == 0 ?
                this.secondValue.compareTo(tt1Pair.secondValue) :
                this.firstValue.compareTo(tt1Pair.firstValue);
    }
}
