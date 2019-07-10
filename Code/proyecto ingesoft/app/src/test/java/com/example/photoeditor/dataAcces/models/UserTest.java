package com.example.photoeditor.dataAcces.models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User usuario = new User("UnitTest1","qwerty",0,15,8);

    @Test
    public void traductWorks() {
        assertArrayEquals(usuario.traductPermissions(false),new boolean[]{true, false,false,false});
    }
}