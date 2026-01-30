package logic;

import java.util.ArrayList;

public class Server {
    private  String name;
    private User owner;
    private ArrayList<Channel> channelList;
    private ArrayList<User> memberList;

    public Server(String name, User owner, TemplateType template){
        this.setOwner(owner);
        memberList = new ArrayList<>();
        channelList = new ArrayList<>();

        memberList.add(owner);
        this.owner.addJoinedServersList(this);

        this.setName(name);

        if(template.equals(TemplateType.BASIC)){
            this.addChannel(this.owner,"general");
        } else if(template.equals(TemplateType.GAMING)){
            this.addChannel(this.owner,"gaming");
        } else if(template.equals(TemplateType.STUDY)){
            this.addChannel(this.owner,"homework-help");
        }
    }

    public boolean isMemberInServer(User user){
        if(memberList.contains(user)){
            return true;
        }
        return false;
    }

    public Channel addChannel(User user, String channelName){
        if(user.equals(this.owner)){
            Channel channel = new Channel(channelName);
            channelList.add(channel);
        }
        return null;
    }

    public User addUser(User user){
        if(!memberList.contains(user)){
            memberList.add(user);
            user.addJoinedServersList(this);
            return user;
        } else {
            return null;
        }
    }

    public boolean kickUser(User kicker, User kicked) throws Exception{
        if(!kicker.equals(this.owner)){
            throw new Exception("Error");
        } else {
            if(!memberList.contains(kicked)){
                return  false;
            } else if(kicked.equals(this.owner)){
                return  false;
            }
        }

        kicked.getJoinedServersList().remove(this);
        memberList.remove(kicked);
        return true;
    }

    public void setName(String name){
        if(name.isBlank()){
            this.name = this.getOwner().getName() + " home";
            return;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ArrayList<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(ArrayList<Channel> channelList) {
        this.channelList = channelList;
    }

    public ArrayList<User> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<User> memberList) {
        this.memberList = memberList;
    }
}
