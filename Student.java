public class Student {
    private String studentId; 
    private String response; 


    public Student(String studentId) 
    {
        this.studentId = studentId;
    }

    public String getStudentId() 
    {
        return studentId;
    }

    public String getResponse() 
    {
        return response;
    }

    public void setResponse(String response) 
    {
        this.response = response;
    }
}
