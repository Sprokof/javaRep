package client;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

    public class ClientGuiModel {
        private final Set<String> allUsers = new TreeSet<>();
        private String newName;
        private String newMessage;

        public Set<String> getAllUsers() {
            return Collections.unmodifiableSet(allUsers);}

        public String getNewName() {
            return newName;}

        public void setNewName(String newName) {
            this.newName = newName;}

        public String getNewMessage() {
            return newMessage;
        }

        public void setNewMessage(String newMessage) {
            this.newMessage = newMessage;
        }

        public void addUser(String newUserName){
            allUsers.add(newUserName);}

        public void deleteUser(String userName){
            allUsers.remove(userName);}



    }
