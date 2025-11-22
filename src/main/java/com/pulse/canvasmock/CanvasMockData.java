package com.pulse.canvasmock;

import java.util.List;
import java.util.ArrayList;

public class CanvasMockData {

    // Singleton instance
    private static CanvasMockData instance;

    //List of courses, containing assignments which contain student results
    private List<CanvasCourse> courses;

    // Constructor
    private CanvasMockData() {
        // Initialize list of courses
        courses = new ArrayList<>();

        // Course 1 - EA & SOA
        CanvasCourse course1 = new CanvasCourse();
        course1.setCourseId("D0031N");
        course1.setCourseName("Enterprise Architecture & SOA");

        // List of assignments
        course1.setAssignments(new ArrayList<>());

            // First assignment in course 1
            CanvasAssignment assignment1 = new CanvasAssignment();
            assignment1.setAssignmentName("0005 - Inlämningsuppgifter");

                // List of student results for assignment 1
                assignment1.setResults(new ArrayList<>());

                // Student results for assignment 1
                CanvasStudentResult s1a = new CanvasStudentResult();
                s1a.setStudentID("annand-1");
                s1a.setStudentName("Anna Andersson");
                s1a.setCanvasGrade("G");

                CanvasStudentResult s2a = new CanvasStudentResult();
                s2a.setStudentID("bjober-1");
                s2a.setStudentName("Björn Berg");
                s2a.setCanvasGrade("G");

                CanvasStudentResult s3a = new CanvasStudentResult();
                s3a.setStudentID("ceccar-1");
                s3a.setStudentName("Cecilia Carlsson");
                s3a.setCanvasGrade("U");

                CanvasStudentResult s4a = new CanvasStudentResult();
                s4a.setStudentID("davdom-1");
                s4a.setStudentName("David Domare");
                s4a.setCanvasGrade("G");

                // Add student results to assignment 1
                assignment1.getResults().add(s1a);
                assignment1.getResults().add(s2a);
                assignment1.getResults().add(s3a);
                assignment1.getResults().add(s4a);

            // Add assignment 1 to course
            course1.getAssignments().add(assignment1);

            // Second assignment in course 1
            CanvasAssignment assignment2 = new CanvasAssignment();
            assignment2.setAssignmentName("0006 - Projekt");

                // List of student results for assignment 2
                assignment2.setResults(new ArrayList<>());

                CanvasStudentResult s1b = new CanvasStudentResult();
                s1b.setStudentID("annand-1");
                s1b.setStudentName("Anna Andersson");
                s1b.setCanvasGrade("VG");

                CanvasStudentResult s2b = new CanvasStudentResult();
                s2b.setStudentID("bjober-1");
                s2b.setStudentName("Björn Berg");
                s2b.setCanvasGrade("VG");

                CanvasStudentResult s3b = new CanvasStudentResult();
                s3b.setStudentID("ceccar-1");
                s3b.setStudentName("Cecilia Carlsson");
                s3b.setCanvasGrade("G");

                CanvasStudentResult s4b = new CanvasStudentResult();
                s4b.setStudentID("davdom-1");
                s4b.setStudentName("David Domare");
                s4b.setCanvasGrade("G");

                // Add student results to assignment 2
                assignment2.getResults().add(s1b);
                assignment2.getResults().add(s2b);
                assignment2.getResults().add(s3b);
                assignment2.getResults().add(s4b);

            // Add assignment 2 to course
            course1.getAssignments().add(assignment2);
        
        // Course 2 - Data Mining
        CanvasCourse course2 = new CanvasCourse();
        course2.setCourseId("D0025E");
        course2.setCourseName("Data Mining");

        // List of assignments
        course2.setAssignments(new ArrayList<>());

            // First assignment in course 2
            CanvasAssignment assignment3 = new CanvasAssignment();
            assignment3.setAssignmentName("0001 - Projektuppgifter/Individuella uppgifter");

                // List of student results for assignment 3
                assignment3.setResults(new ArrayList<>());

                CanvasStudentResult s1c = new CanvasStudentResult();
                s1c.setStudentID("annand-1");
                s1c.setStudentName("Anna Andersson");
                s1c.setCanvasGrade("G");

                CanvasStudentResult s2c = new CanvasStudentResult();
                s2c.setStudentID("bjober-1");
                s2c.setStudentName("Björn Berg");
                s2c.setCanvasGrade("G");

                CanvasStudentResult s3c = new CanvasStudentResult();
                s3c.setStudentID("ceccar-1");
                s3c.setStudentName("Cecilia Carlsson");
                s3c.setCanvasGrade("G");

                CanvasStudentResult s4c = new CanvasStudentResult();
                s4c.setStudentID("davdom-1");
                s4c.setStudentName("David Domare");
                s4c.setCanvasGrade("U");

                // Add student results to assignment 3
                assignment3.getResults().add(s1c);
                assignment3.getResults().add(s2c);
                assignment3.getResults().add(s3c);
                assignment3.getResults().add(s4c);
            
            // Add assignment 3 to course 2
            course2.getAssignments().add(assignment3);

            // Second assignment in course 2
            CanvasAssignment assignment4 = new CanvasAssignment();
            assignment4.setAssignmentName("0002 - Tentamen");

                // List of student results for assignment 4
                assignment4.setResults(new ArrayList<>());

                CanvasStudentResult s1d = new CanvasStudentResult();
                s1d.setStudentID("annand-1");
                s1d.setStudentName("Anna Andersson");
                s1d.setCanvasGrade("G");

                CanvasStudentResult s2d = new CanvasStudentResult();
                s2d.setStudentID("bjober-1");
                s2d.setStudentName("Björn Berg");
                s2d.setCanvasGrade("G");

                CanvasStudentResult s3d = new CanvasStudentResult();
                s3d.setStudentID("ceccar-1");
                s3d.setStudentName("Cecilia Carlsson");
                s3d.setCanvasGrade("VG");

                CanvasStudentResult s4d = new CanvasStudentResult();
                s4d.setStudentID("davdom-1");
                s4d.setStudentName("David Domare");
                s4d.setCanvasGrade("U");

                // Add student results to assignment 4
                assignment4.getResults().add(s1d);
                assignment4.getResults().add(s2d);
                assignment4.getResults().add(s3d);
                assignment4.getResults().add(s4d);

            // Add assignment 4 to course 2
            course2.getAssignments().add(assignment4);


        // Course 3 - Forskningsmetoder inom informationssystem
        CanvasCourse course3 = new CanvasCourse();
        course3.setCourseId("D0023E");
        course3.setCourseName("Forskningsmetoder inom informationssystem");

        // List of assignments
        course3.setAssignments(new ArrayList<>());

            // First assignment in course 3
            CanvasAssignment assignment5 = new CanvasAssignment();
            assignment5.setAssignmentName("0003 - Individuell uppgift");

                // List of student results for assignment 5
                assignment5.setResults(new ArrayList<>());

                CanvasStudentResult s1e = new CanvasStudentResult();
                s1e.setStudentID("annand-1");
                s1e.setStudentName("Anna Andersson");
                s1e.setCanvasGrade("G");

                CanvasStudentResult s2e = new CanvasStudentResult();
                s2e.setStudentID("bjober-1");
                s2e.setStudentName("Björn Berg");
                s2e.setCanvasGrade("G");

                CanvasStudentResult s3e = new CanvasStudentResult();
                s3e.setStudentID("ceccar-1");
                s3e.setStudentName("Cecilia Carlsson");
                s3e.setCanvasGrade("G");

                CanvasStudentResult s4e = new CanvasStudentResult();
                s4e.setStudentID("davdom-1");
                s4e.setStudentName("David Domare");
                s4e.setCanvasGrade("G");

                // Add student results to assignment 5
                assignment5.getResults().add(s1e);
                assignment5.getResults().add(s2e);
                assignment5.getResults().add(s3e);
                assignment5.getResults().add(s4e);

            // Add assignment 5 to course 3
            course3.getAssignments().add(assignment5);

            // Second assignment in course 3
            CanvasAssignment assignment6 = new CanvasAssignment();
            assignment6.setAssignmentName("0004 - Projekt");

                // List of student results for assignment 6
                assignment6.setResults(new ArrayList<>());

                CanvasStudentResult s1f = new CanvasStudentResult();
                s1f.setStudentID("annand-1");
                s1f.setStudentName("Anna Andersson");
                s1f.setCanvasGrade("VG");

                CanvasStudentResult s2f = new CanvasStudentResult();
                s2f.setStudentID("bjober-1");
                s2f.setStudentName("Björn Berg");
                s2f.setCanvasGrade("VG");

                CanvasStudentResult s3f = new CanvasStudentResult();
                s3f.setStudentID("ceccar-1");
                s3f.setStudentName("Cecilia Carlsson");
                s3f.setCanvasGrade("VG");

                CanvasStudentResult s4f = new CanvasStudentResult();
                s4f.setStudentID("davdom-1");
                s4f.setStudentName("David Domare");
                s4f.setCanvasGrade("VG");

                // Add student results to assignment6
                assignment6.getResults().add(s1f);
                assignment6.getResults().add(s2f);
                assignment6.getResults().add(s3f);
                assignment6.getResults().add(s4f);

        // Add assignment 6 to course 3
        course3.getAssignments().add(assignment6);

        // Add the course to the mock data's course list
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
    }

    // Get instance of CanvasMockData
    public static CanvasMockData getInstance() {
        if (instance == null) {
            instance = new CanvasMockData();
        }
        return instance;
    }
        
    //
    public List<CanvasCourse> getCourses() {
        return courses;
    }

    // Methods to retrieve courses, assignments, and results
        public List<String> getAvailableCourses() {
        List<String> courseIds = new ArrayList<>();
        for (CanvasCourse course : courses) {
            courseIds.add(course.getCourseId());
        }
        return courseIds;
    }

    public List<CanvasAssignment> getAssignmentsForCourse(String courseId) {
        for (CanvasCourse course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course.getAssignments();
            }
        }
        return new ArrayList<>();
    }

    public List<CanvasStudentResult> getResults(String courseId, String assignmentName) {
        for (CanvasCourse course : courses) {
            if (course.getCourseId().equals(courseId)) {
                for (CanvasAssignment assignment : course.getAssignments()) {
                    if (assignment.getAssignmentName().equals(assignmentName)) {
                    return assignment.getResults();
                    }
                }
            }
        }
        return new ArrayList<>();
    }
    
}
