package com.chatapp;

import com.chatapp.dao.*;
import com.chatapp.model.*;
import com.chatapp.service.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class App {
    private static UserService userService;
    private static GroupService groupService;
    private static MessageService messageService;

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        UserDAO userDAO = new UserDAOImpl(sessionFactory);
        GroupDAO groupDAO = new GroupDAOImpl(sessionFactory);
        MessageDAO messageDAO = new MessageDAOImpl(sessionFactory);

        userService = new UserService(userDAO);
        groupService = new GroupService(groupDAO);
        messageService = new MessageService(messageDAO);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register User");
            System.out.println("2. Send Message");
            System.out.println("3. Create Group");
            System.out.println("4. Add User to Group");
            System.out.println("5. View Messages by User");
            System.out.println("6. View Messages by Group");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter username:");
                    String name = scanner.nextLine();
                    userService.registerUser(name);
                    System.out.println("User registered successfully.");
                    break;

                case 2:
                    System.out.println("Enter sender ID:");
                    int senderId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter receiver ID (0 for group message):");
                    int receiverId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter group ID (0 if not a group message):");
                    int groupId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter message:");
                    String messageText = scanner.nextLine();
                    Message message = new Message();
                    message.setSender(userService.getUser(senderId));
                    message.setReceiver(receiverId == 0 ? null : userService.getUser(receiverId));
                    message.setGroup(groupId == 0 ? null : groupService.getGroup(groupId));
                    message.setMessage(messageText);
                    message.setTimestamp(new Timestamp(System.currentTimeMillis()));
                    messageService.sendMessage(message);
                    System.out.println("Message sent.");
                    break;

                case 3:
                    System.out.println("Enter group name:");
                    String groupName = scanner.nextLine();
                    Group group = new Group();
                    group.setName(groupName);
                    groupService.createGroup(group);
                    System.out.println("Group created successfully.");
                    break;

                case 4:
                    System.out.println("Enter group ID:");
                    int grpId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter user IDs to add to group (comma separated):");
                    String[] userIds = scanner.nextLine().split(",");
                    Group existingGroup = groupService.getGroup(grpId);
                    Set<User> users = existingGroup.getUsers();
                    for (String idStr : userIds) {
                        int userId = Integer.parseInt(idStr.trim());
                        User user = userService.getUser(userId);
                        if (user != null) {
                            users.add(user);
                        }
                    }
                    existingGroup.setUsers(users);
                    groupService.createGroup(existingGroup); // Save updated group
                    System.out.println("Users added to group.");
                    break;

                case 5:
                    System.out.println("Enter user ID:");
                    int userId = scanner.nextInt();
                    List<Message> userMessages = messageService.getMessagesByUser(userId);
                    for (Message msg : userMessages) {
                        System.out.println(msg.getTimestamp() + " - " + msg.getSender().getName() + ": " + msg.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Enter group ID:");
                    int gId = scanner.nextInt();
                    List<Message> groupMessages = messageService.getMessagesByGroup(gId);
                    for (Message msg : groupMessages) {
                        System.out.println(msg.getTimestamp() + " - " + (msg.getSender() != null ? msg.getSender().getName() : "Unknown") + ": " + msg.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    sessionFactory.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
