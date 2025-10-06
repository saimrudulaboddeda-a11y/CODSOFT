import java.util.*;
class StudentsGradeCalculator
{
public static void main(String[] args){
    try(Scanner sc=new Scanner(System.in);)
    {
    System.out.println("enter the number of students");
    int n=sc.nextInt();
    sc.nextLine();

    String name[]=new String[n];
    int[] rollno=new int[n];
    String subject[][]=new String[n][];
    int marks[][]=new int[n][];
    String grade[]=new String[n];
    int[] totalMarks = new int[n];
    double[] averagePercentage = new double[n];
    String overallGrade[]=new String[n];
    boolean passedAllSubjects=true;
int numsubjects;
    for(int i=0;i<n;i++)// Loop through each student
    {
        System.out.println("enter the details of student:");
        System.out.println("enter the student name");
        name[i]=sc.nextLine();
        System.out.println("enter the rollno of student:");
        rollno[i]=sc.nextInt();
        sc.nextLine();
    System.out.println("enter the number of subjects:");
    numsubjects=sc.nextInt();
    sc.nextLine();
    subject[i] = new String[numsubjects];
    marks[i] = new int[numsubjects];
    overallGrade[i]=""; // Initialize overall grade
    int sum=0;// Initialize sum for each student
for(int j=0;j<numsubjects;j++)// Loop through each subject
{
    System.out.println("enter the subject "+(j+1)+" name:");
    subject[i][j]=sc.nextLine();
    System.out.println("enter the marks obtained by the student in subject:"+(j+1)+ " out of 100");
    marks[i][j]=sc.nextInt();
    sc.nextLine();
    if(marks[i][j]<0 || marks[i][j]>100)// Validate marks input
    {
        System.out.println("invalid marks,please enter marks between 0 to 100");
        j--; // Decrement j to repeat the input for the same subject

    }
    // Assign grade based on individual subject marks
    if(marks[i][j]<0 || marks[i][j]>100){
        System.out.println("invalid marks,please enter marks between 0 to 100");
        j--; // Decrement j to repeat the input for the same subject
    }
   else if(marks[i][j]>80){
        grade[i]="A+";
        System.out.println("passed with A+ grade");
    }
   else if(marks[i][j]>=70){
        grade[i]="A";
        System.out.println("passed with A grade");
    }
  else if(marks[i][j]>=65){
        grade[i]="B+";
        System.out.println("passed with B+ grade");
    }
   else if(marks[i][j]>=60){
        grade[i]="B";
        System.out.println("passed with B grade");
    }
   else if(marks[i][j]>=50){
        grade[i]="C";
        System.out.println("passed with C grade");
    }
    else if(marks[i][j]>=40){
        grade[i]="D";
        System.out.println("passed with D grade");
    }
   else if(marks[i][j]>=35){
        grade[i]="E";
        System.out.println("passed with E grade");
    }
    else if(marks[i][j]<35){

        grade[i]="F";
        System.out.println("failed with F grade");
    }
    if(grade[i]=="F")// Check if the student has failed in any subject
    {
        passedAllSubjects=false;
    }
    if(!passedAllSubjects)
    {
        totalMarks[i]=0;
        averagePercentage[i]=0.0;
        overallGrade[i]="F";
    }
    else if(passedAllSubjects) {
        overallGrade[i]=grade[i]; // Reset overall grade if passed all subjects
        overallGrade[i]=""; // Clear overall grade to be calculated later
    }
}
for( int j=0;j<numsubjects;j++)// Calculate sum of marks for the student
{
    sum+=marks[i][j];
}
// Calculate total and average
totalMarks[i] = sum;
averagePercentage[i] = (double)sum / numsubjects;

    // Assign overall grade based on average
    if(averagePercentage[i]<0 || averagePercentage[i]>100){
        System.out.println("invalid average percentage");
    }
    if(averagePercentage[i]>35 && grade[i]=="F"){
        overallGrade[i]="F";
        System.out.println("failed with F grade");
    }
    if(averagePercentage[i]>=80){
      overallGrade[i]="A+";
    }
    else if(averagePercentage[i]>=70){
        overallGrade[i]="A";
    }
    else if(averagePercentage[i]>=65){
        overallGrade[i]="B+";
    }
    else if(averagePercentage[i]>=60){
        overallGrade[i]="B";
    }
    else if(averagePercentage[i]>=50){
        overallGrade[i]="C";
    }
    else if(averagePercentage[i]>=40){
        overallGrade[i]="D";
    }
    else if(averagePercentage[i]>=35){
       overallGrade[i]="E";
    }
    else{
         overallGrade[i]="F";
    }
}
int i;
for(i=0;i<n;i++)// Assign overall grade based on individual subject grades
{
if(averagePercentage[i]>=35&&grade[i]=="F")
{
    overallGrade[i]="F";
}
}
    for(int K=0;K<n;K++)// Loop through each student to display details
    {
        int k=K;
    {
        display(name[k], rollno[k], subject[k], marks[k], grade[k], totalMarks[k], averagePercentage[k], overallGrade[k]);
    }
    }
}
}
public static void display(String name,int rollno,String[] subject,int[] marks,String grade,int totalMarks,double averagePercentage, String overallGrade)
{
    System.out.println("--------------------------------------------------");
    System.out.println("student grade calculator:");
    System.out.println("--------------------------------------------------");
    System.out.println("name:"+name);
    System.out.println("rollno:"+rollno);
    for(int j=0;j<subject.length;j++) {
        System.out.println("subject:" + subject[j]);
        System.out.println("marks:" + marks[j]);
    }
    System.out.println("total marks and overall grade *based on passed subjets only*:");
    System.out.println("total marks:"+totalMarks);
    double averagePercentageRounded = Math.round(averagePercentage * 100.0) / 100.0; // Round to 2 decimal places
    System.out.println("average percentage:"+averagePercentageRounded+"%");
    int i;
    for(i=0;i<subject.length;i++)
    {
        if(marks[i]<35)
        {
            overallGrade="F";
            System.out.println("overall grade:"+overallGrade);
            System.out.println("failed with F grade");
            break;// Exit the loop if any subject is failed
        }
        else
        {
            System.out.println("overall grade:"+overallGrade);
            System.out.println("passed with "+overallGrade+" grade");
        }
    }
System.out.println("--------------------------------------------------");
}
}
