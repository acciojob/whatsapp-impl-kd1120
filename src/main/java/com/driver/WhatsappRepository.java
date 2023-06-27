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
    private HashSet<String> userMobile;
   // private int customGroupCount;
   // private int messageId;
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

       if(!userMobile.contains(mob)){
           userMobile.add(mob);
       }
   return "SUCCESS";
    }

   public Group createGroup(List<User> users){
        if(users.size()==2){

        }
        return null;
   }

//   public int createMessage(String content){
//
//       Message message = new Message(content);
//
//        messageId++;
//        return message.getId();
//   }

    public int sendMessage(Message message, User sender, Group group) throws Exception{


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

    }

    public String findMessage(Date start, Date end, int K) throws Exception{

    }




    }

