package com.example.NasaBase.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SpaceVehicle implements Comparable<SpaceVehicle> {
    private double price;
    private final int size;

    public SpaceVehicle(int size, double price) {
        this.size = size;
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(SpaceVehicle o) {
        return Double.compare(o.getPrice(), this.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SpaceVehicle that = (SpaceVehicle) o;

        return new EqualsBuilder().append(price, that.price).append(size, that.size).isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("price", price)
                .append("size", size)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(price).append(size).toHashCode();
    }
}
