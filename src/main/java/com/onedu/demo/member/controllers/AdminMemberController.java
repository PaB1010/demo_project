package com.onedu.demo.member.controllers;

import com.onedu.demo.global.libs.Utils;
import com.onedu.demo.global.rests.JSONData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminMemberController {

    private final Utils utils;

    public JSONData list() {

        return null;
    }

    public JSONData statusUpdate() {

        return null;
    }

    public JSONData statusUpdate(String data) {

        return null;
    }

    public JSONData statusDelete() {

        return null;
    }

    public JSONData status() {

        return null;
    }

    public JSONData statusList() {

        return null;
    }

    public JSONData edit() {

        return null;
    }

    public JSONData delete() {

        return null;
    }

    public JSONData block() {

        return null;
    }

    public JSONData blocks() {

        return null;
    }

    public void unblock() {

    }

    public void unblocks() {

    }
}
