package com.mohit.quickstart.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

//    private List<Topic> topicList = new ArrayList<>(Arrays.asList(
//            new Topic("spring","Spring Framework","Spring Framework Description"),
//            new Topic("java","Core Java","Core Java Description"),
//            new Topic("javascript","JavaScript","JavaScript Description")
//    ));

    public List<Course> getAllCourses(String topicId){
//        List<Course> courseList = new ArrayList<>();
//        courseRepository.findAll()
//                .forEach(courseList::add);
//        return courseList;

        List<Course> courseList = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(courseList::add);
        return courseList;
    }

    public Course getCourse(String id){
        //return topicList.stream().filter(t-> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Course course){
//        for(int i=0;i< topicList.size();i++){
//            Topic t = topicList.get(i);
//            if(t.getId().equals(id)){
//                topicList.set(i, topic);
//                return;
//            }
//        }
        courseRepository.save(course);
    }

    public void deleteCourse(String id){
        //topicList.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);
    }
}
