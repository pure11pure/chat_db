package com.example.chat_db;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private InfoRepository infoRepository;

    public List<Chat> getAllChats() {
        return chatRepository.findAll(); // ใช้ chatRepository เพื่อดึงข้อมูลทั้งหมดจากฐานข้อมูล
    }

    public Chat addChat(Chat chat) {
        return chatRepository.save(chat); // เพิ่มข้อมูลแชทลงใน MongoDB
    }

    public List<Chat> getChatsByRoom(String roomId) {
        List<Chat> byRoomId = chatRepository.findByRoomId(roomId);
        ObjectId RoomId = new ObjectId(roomId);
        Room room = roomRepository.findByRoomId(RoomId);
        System.out.println("Room Chat: "+ room.getName()+"  "+ room.getRoomId());
        for (Chat chat : byRoomId) {
            String nameId = chat.getNameId();
            Info info = infoRepository.findByInfoId(nameId);
            String formattedTimestamp = formatTimestamp(chat.getTimestamp());
            System.out.println(info.getImg()+ " " +info.getName() + ": " + chat.getMsg() + "       (" + formattedTimestamp+")");
        }
        System.out.println();
        return byRoomId;
    }
    private String formatTimestamp(Date timestamp) {
        ZonedDateTime zonedDateTime = timestamp.toInstant().atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return zonedDateTime.format(formatter);
    }
}

