package com.example.controller;

import com.example.dao.MsgsDao;
import com.example.domain.Msgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author ymm
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/msgs")
public class MsgsController {
    @Autowired
    private MsgsDao msgsDao;


    public boolean saveInMsg(int id) {
        Msgs msgs = new Msgs();
        msgs.setMsgsCont("有新的入库申请");
        msgs.setType(1);
        msgs.setOrderId(id);
        boolean ifSuccess = msgsDao.insert(msgs) > 0;
        System.out.println(ifSuccess);
        return ifSuccess;
    }

    public boolean saveOutMsg(int id) {
        Msgs msgs = new Msgs();
        msgs.setMsgsCont("有新的出库申请");
        msgs.setType(1);
        msgs.setOrderId(id);
        return msgsDao.insert(msgs) > 0;
    }

    public boolean saveOrdersMsg(int id) {
        Msgs msgs = new Msgs();
        msgs.setMsgsCont("有新的待处理操作");
        msgs.setType(2);
        msgs.setOrderId(id);
        return msgsDao.insert(msgs) > 0;
    }

    public boolean saveApplyMsg(int id) {
        Msgs msgs = new Msgs();
        msgs.setMsgsCont("申请已完成");
        msgs.setType(3);
        msgs.setOrderId(id);
        return msgsDao.insert(msgs) > 0;
    }

    @PutMapping
    public boolean updatemsg(@RequestParam("msgid") Integer msgid) {
        return msgsDao.updatemsg(msgid) > 0;
    }

    /**
     * type: 1是新的出入库申请，2是新的待出入库订单，3是已完成的申请，0是已读
     *
     * @return list
     */
    @GetMapping
    public List<Msgs> getMsgs() {
        return msgsDao.selectType(1);
    }

    @GetMapping("/orders")
    public List<Msgs> getOrdersMsgs() {
        return msgsDao.selectType(2);
    }

    @GetMapping("/apply")
    public List<Msgs> getApplyMsgs() {
        return msgsDao.selectType(3);
    }



}
