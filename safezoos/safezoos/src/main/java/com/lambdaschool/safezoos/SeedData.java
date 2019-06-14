package com.lambdaschool.safezoos;


import com.lambdaschool.safezoos.model.Role;
import com.lambdaschool.safezoos.model.User;
import com.lambdaschool.safezoos.model.UserRoles;
import com.lambdaschool.safezoos.repository.RoleRepository;
import com.lambdaschool.safezoos.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("zoodata");
        Role r4 = new Role("animaldata");
        Role r5 = new Role("mgr");


        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> zoodatas = new ArrayList<>();
        zoodatas.add(new UserRoles(new User(), r3));

        ArrayList<UserRoles> animaldatas = new ArrayList<>();
        animaldatas.add(new UserRoles(new User(), r4));

        ArrayList<UserRoles> managers = new ArrayList<>();
        managers.add(new UserRoles(new User(), r5));


        rolerepos.save(r1);
        rolerepos.save(r2);
        rolerepos.save(r3);
        rolerepos.save(r4);
        rolerepos.save(r5);

        User u1 = new User("roger", "1234", users);
        User u2 = new User("admin", "password", admins);
        User u3 = new User("ZooAdmin", "password", zoodatas);
        User u4 = new User( "animaladmin", "password", animaldatas);
        User u5 = new User( "Manager", "password", managers);

        userrepos.save(u1);
        userrepos.save(u2);
        userrepos.save(u3);
        userrepos.save(u4);
        userrepos.save(u5);
    }
}

