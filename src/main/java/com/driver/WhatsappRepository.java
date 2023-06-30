package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class WhatsappRepository {

    //Assume that each user belongs to at most one group
    //You can use the below mentioned hashmaps or delete these and create your own.
    private HashMap<Group, List<User>> groupUserMap;
    private HashMap<Group, List<Message>> groupMessageMap;
    private HashMap<Message, User> senderMap;
    private HashMap<Group, User> adminMap;
    private HashMap<String , String> user;
    private HashSet<String> userMobile;

    private int customGroupCount;
    private int messageId;


    public WhatsappRepository(){
        this.groupMessageMap = new HashMap<Group, List<Message>>();
        this.groupUserMap = new HashMap<Group, List<User>>();
        this.senderMap = new HashMap<Message, User>();
        this.adminMap = new HashMap<Group, User>();
        this.userMobile = new HashSet<>();
        this.customGroupCount = 1;
        this.messageId = 1;
    }

    public String createUser(String name, String mob) throws Exception{

       if(user.containsKey(mob)){
       throw new Exception("User already exists");
       }
        user.put(name, mob);
        return "SUCCESS";
    }

   public Group createGroup(List<User> users){

       Group group = new Group();
       if(users.size()==2){
            group.setName(String.valueOf(users.indexOf(1)));


        }
       else if(users.size()>2){
           String ans = "Group";
           group.setName(ans + String.valueOf(users.size()));
       }

       return Group;
   }

//   public int createMessage(String content){
//
//       Message message = new Message(content);
//
//        messageId++;
//        return message.getId();
//   }

    public int sendMessage(Message message, User sender, Group group) throws Exception{

        for(Group group1 : adminMap.keySet()){
            if(!group1.equals(group)){
                throw new Exception("Group does not exist");
            }
        }

        for(User user1: adminMap.values()){
            if(!user1.equals(user)){
                throw new Exception("You are not allowed to send message");
            }
        }
        int msg=0;
        for(List<Message> messages: groupMessageMap.values()){
            if(messages.equals(message)){
                msg  = messages.size();
            }
        }



 return msg;
    }

    public String changeAdmin(User approver, User user, Group group) throws Exception{

        if(!groupUserMap.containsKey(group)){
            throw new Exception("Group does not exist");
        }
        if(!approver.getMobile().equals(adminMap.get(group).getMobile())){
            throw new Exception("Approver does not have rights");
        }
        List<User> users = new ArrayList<>(groupUserMap.get(group));
        for(User x : users){
            if(x.getMobile().equals(user.getMobile())){
                adminMap.put(group, user);
                return "SUCCESS";
            }
        }
        throw new Exception("User is not a participant");
    }
    public int removeUser(User user) throws Exception{

        return 0;
    }

    public String findMessage(Date start, Date end, int K) throws Exception{

        return null;
    }


    public int createMessage(String content) {
        int id = 0;
        for(Message message : senderMap.keySet()){
            if(message.getContent().equals(content)){
                id = message.getId();
            }
        }

        return id;
    }
}

