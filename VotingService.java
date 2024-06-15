import java.util.HashMap;
import java.util.Map;

public class VotingService {
    private Question question; 
    private Map<String, String> submissions; 

    public VotingService() 
    {
        submissions = new HashMap<>();
    }

    public void configureQuestion(Question question) 
    {
        this.question = question;
    }

    public void submitResponse(Student student, String response) 
    {
        if (question.getOptions().contains(response)) 
        {
            submissions.put(student.getStudentId(), response);
        }
    }

    public void displayResults() 
    {
        Map<String, Integer> result = new HashMap<>();
        // Count responses
        for (String response : submissions.values()) 
        {
            result.put(response, result.getOrDefault(response, 0) + 1);
        }

        // print
        for (Map.Entry<String, Integer> entry : result.entrySet()) 
        {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
