package com.chatapp.service;

import com.chatapp.dao.GroupDAO;
import com.chatapp.model.Group;

import java.util.List;

public class GroupService {
    private GroupDAO groupDAO;

    public GroupService(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    public void createGroup(Group group) {
        groupDAO.addGroup(group);
    }

    public Group getGroup(int id) {
        return groupDAO.getGroup(id);
    }

    public Group getGroupByName(String name) {
        return groupDAO.getGroupByName(name);
    }

    public List<Group> getAllGroups() {
        return groupDAO.getAllGroups();
    }
}
