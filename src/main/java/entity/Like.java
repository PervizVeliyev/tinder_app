package entity;

import java.util.Objects;

public class Like {
    private int from;
    private int to;

    public Like(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Like like = (Like) o;
        return from == like.from && to == like.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
