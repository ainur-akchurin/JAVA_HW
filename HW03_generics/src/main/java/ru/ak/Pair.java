package ru.ak;

import java.util.Objects;

public class Pair <F, S>{

    private F first;
    private S second;

    private Pair(F first, S second){
        this.first = first;
        this.second = second;
    }

    public static <F,S> Pair<F,S> of(F fisrt, S second){
        return new Pair<>(fisrt,second);
    }

    public F getFirst(){
        return this.first;
    }

    public S getSecond(){
        return this.second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(getFirst(), pair.getFirst()) &&
                Objects.equals(getSecond(), pair.getSecond());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond());
    }
}
