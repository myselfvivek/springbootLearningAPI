package org.example.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
//    it makes singlton object
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("Java", "Java Spring", "It is java spring boot."),
//            new Topic("Javascript", "Java Script here", "It is a java script.")
//    ));

    public List<Topic> getAllTopics()
    {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id)
    {
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).orElse(null);
    }

    public void addTopic(Topic topic) {
//        topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {

//        for(int i = 0; i < topics.size(); i++)
//        {
//            if(topics.get(i).getId().equals(id))
//            {
//                topics.set(i, topic);
//                return;
//            }
//        }
        topicRepository.save(topic);
    }
    public void deleteTopic(String id) {

        topicRepository.deleteById(id);
    }
}
