package lianxi;

public class Score {
    private  int chinese;
    private  int math;
    private  int sum;

    public Score(int chinese, int math) {
        this.chinese = chinese;
        this.math = math;
        this.sum = chinese+math;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Score{" +
                "chinese=" + chinese +
                ", math=" + math +
                ", sum=" + sum +
                '}';
    }
}
