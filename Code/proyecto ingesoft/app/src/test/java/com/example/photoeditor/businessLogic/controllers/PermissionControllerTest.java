package com.example.photoeditor.businessLogic.controllers;

import org.junit.Test;

import static org.junit.Assert.*;

public class PermissionControllerTest {
    @Test
    public void traductWorks() {
        assertEquals(PermissionController.binaryStringToInt("00000000000000110"),6);
    }
}