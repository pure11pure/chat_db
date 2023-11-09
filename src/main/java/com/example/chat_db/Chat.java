package com.example.chat_db;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
@Data // สร้างต่าง ๆ อัตโนมัติเช่น getter, setter, toString, hashCode, และ equals เพื่อลดจำนวนโค้ดที่ต้องเขียนเอง
@Document("Chats") //Mongo collection
public class Chat implements Serializable {
    @Id
    private String _id; // ใช้เป็น ObjectId ของ MongoDB

    private String msg; // ข้อความแชท
    private Date timestamp; // วันที่และเวลา

    private String roomId; // รหัสห้องแชท
    private String nameId; // รหัสชื่อผู้ใช้ที่ส่งข้อความ

    // Constructor สำหรับคลาส Chat
    public Chat(String msg, Date timestamp, String roomId, String nameId) {
        this.msg = msg;
        this.timestamp = timestamp;
        this.roomId = roomId;
        this.nameId = nameId;
    }
}
