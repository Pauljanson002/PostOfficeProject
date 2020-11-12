package controller;

import business.util.Notification;
import data.NotificationDB;

import java.util.ArrayList;

public class NotificationManager {
    private ArrayList<Integer> users;
    public void attach(int id){
        users.add(id);
    }
    public void detach(int id){
        users.remove(id);
    }
    public void newNotification(int reportId,String month){
        Notification notification = new Notification();
        notification.setReportId(reportId);
        notification.setSeen(0);
        notification.setMessage("The monthly report for month "+month+" is available");
        for (int x :
                users) {
           notification.setStaffId(x);
            NotificationDB.insertNotification(notification);
        }
    }

    public NotificationManager() {
        users = new ArrayList<>();
    }
}
