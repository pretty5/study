package exception;

/*
*@ClassName:ScoreException
 @Description:TODO
 @Author:
 @Date:2018/7/17 15:39 
 @Version:v1.0
*/
public class ScoreException extends Exception {

    private int score;

    public ScoreException(int score){
        this.score=score;
    }

    public ScoreException(String message, int score){
        super(message);
        this.score=score;
    }

    @Override
    public String getMessage() {
        return super.getMessage()+"你看看的你的成绩："+score;
    }

    @Override
    public String toString() {
        return "ScoreException{" +
                "score=" + score +
                '}';
    }

}
