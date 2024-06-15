import java.util.List;

public class Question 
{
    public enum QuestionType { SINGLE, MULTIPLE, TRUE_FALSE }

    private QuestionType type; 
    private List<String> options; // List of possible answers

    public Question(QuestionType type, List<String> options) 
    {
        this.type = type;
        this.options = options;
    }

    public QuestionType getType() 
    {
        return type;
    }

    public List<String> getOptions() 
    {
        return options;
    }
}
