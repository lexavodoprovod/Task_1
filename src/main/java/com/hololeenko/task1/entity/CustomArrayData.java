package com.hololeenko.task1.entity;


public class CustomArrayData {

    private int max;
    private int min;
    private int sum;
    private int avg;

    public CustomArrayData(int max, int min, int sum, int avg) {
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.avg = avg;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomArrayData that = (CustomArrayData) o;
        return max == that.max && min == that.min && sum == that.sum && avg == that.avg;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(max);
        result = 31 * result + Integer.hashCode(min);
        result = 31 * result + Integer.hashCode(sum);
        result = 31 * result + Double.hashCode(avg);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomArrayData{");
        sb.append("max=").append(max);
        sb.append(", min=").append(min);
        sb.append(", sum=").append(sum);
        sb.append(", avg=").append(avg);
        sb.append('}');
        return sb.toString();
    }
}
