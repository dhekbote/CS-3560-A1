import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationDriver 
{
    public static void main(String[] args) 
    {
        List<String> multiStudentResponse = new ArrayList<>();
        multiStudentResponse.add("A");
        multiStudentResponse.add("B");
        multiStudentResponse.add("C");
        multiStudentResponse.add("D");
        Question mcQuestion = new Question(Question.QuestionType.SINGLE, multiStudentResponse);

        // I made true and false options a separate category, hope it is ok
        List<String> tfStudentResponse = new ArrayList<>();
        tfStudentResponse.add("True");
        tfStudentResponse.add("False");
        Question tfQuestion = new Question(Question.QuestionType.TRUE_FALSE, tfStudentResponse);


        VotingService votingService = new VotingService();
        
        // multiple choice questions
        votingService.configureQuestion(mcQuestion);
        List<Student> students = simulateResponses(multiStudentResponse, 100);
        submitResponses(students, votingService);
        votingService.displayResults(); 

        // true/false questions
        votingService.configureQuestion(tfQuestion);
        students = simulateResponses(tfStudentResponse, 100);
        submitResponses(students, votingService);
        votingService.displayResults(); 
    }

    private static List<Student> simulateResponses(List<String> options, int numStudents) 
    {
        Random random = new Random();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < numStudents; i++) 
        {
            Student student = new Student("Student" + i);
            String randomResponse = options.get(random.nextInt(options.size()));
            student.setResponse(randomResponse);
            students.add(student);
        }
        return students;
    }

    private static void submitResponses(List<Student> students, VotingService votingService) 
    {
        for (Student student : students) 
        {
            votingService.submitResponse(student, student.getResponse());
        }
    }
}
