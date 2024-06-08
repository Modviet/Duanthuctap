package com.example.demo2.service;
import com.example.demo2.model.Notification;
import com.example.demo2.model.User;
import com.example.demo2.repository.NotificationRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepos notiRepo;

    public void sendNotification(User user,String content,String link){
        Notification noti = new Notification();
        noti.setUserId(user);
        noti.setContent(content);
        noti.setLink(link);
        noti.setIsSeen(false);
        noti.setCreateTime(LocalDate.now());
        notiRepo.save(noti);
    }

    public void notifyStudents(List<User> students,String content,String link){
        for (User student: students){
            sendNotification(student,content,link);
        }
    }
}

