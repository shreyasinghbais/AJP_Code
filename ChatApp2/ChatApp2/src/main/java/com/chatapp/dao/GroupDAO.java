package com.chatapp.dao;

import com.chatapp.model.Group;
import java.util.List;

public interface GroupDAO {
    void addGroup(Group group);
    Group getGroup(int id);
    Group getGroupByName(String name);
    List<Group> getAllGroups();
}
