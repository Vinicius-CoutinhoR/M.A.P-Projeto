/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uepb.Map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vinicius Coutinho
 */
@RestController
@RequestMapping(value = "/theranos/shakehand", produces = "application/json;charset=UTF-8")
public class ConnectionShakehandController {

    @Autowired
    private EntityManager entityManager;

    @GetMapping
    public ResponseEntity<Object> isConnected() {
            Map<String, Object> response = new HashMap<>();
            response.put("serverStatus", true);
            response.put("databaseStatus", testDatabase());
            return ResponseEntity.ok(response);
    }

    private boolean testDatabase() {
        try {
            entityManager.createNativeQuery("SELECT 1").getResultList();
            System.out.println(entityManager.createNativeQuery("SELECT 1").getResultList());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
