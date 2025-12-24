package com.onedu.demo.member.controllers;

import com.onedu.demo.global.libs.Utils;
import com.onedu.demo.global.rests.JSONData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final Utils utils;

    public void join() {


    }

    public JSONData login() {

        return null;
    }

    public JSONData info() {

        return null;
    }

    public JSONData delete() {

        return null;
    }

    public JSONData edit() {

        return null;
    }

    public JSONData info(String email) {

        return null;
    }

    public ResponseEntity<Void> exists() {

        return null;
    }

    public void findPassword() {


    }

    public void changePassword() {


    }

    public void validateToken() {


    }
}
