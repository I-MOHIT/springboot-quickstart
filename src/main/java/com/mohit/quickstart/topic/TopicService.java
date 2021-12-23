package com.mohit.quickstart.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

//    private List<Topic> topicList = new ArrayList<>(Arrays.asList(
//            new Topic("spring","Spring Framework","Spring Framework Description"),
//            new Topic("java","Core Java","Core Java Description"),
//            new Topic("javascript","JavaScript","JavaScript Description")
//    ));

    public List<Topic> getAllTopics(){
        List<Topic> topicList = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topicList::add);
        return topicList;
    }

    public Topic getTopic(String id){
        //return topicList.stream().filter(t-> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id){
//        for(int i=0;i< topicList.size();i++){
//            Topic t = topicList.get(i);
//            if(t.getId().equals(id)){
//                topicList.set(i, topic);
//                return;
//            }
//        }
        topicRepository.save(topic);
    }

    public void deleteTopic(String id){
        //topicList.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
