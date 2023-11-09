package com.example.chat_db;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data // สร้างต่าง ๆ อัตโนมัติเช่น getter, setter, toString, hashCode, และ equals เพื่อลดจำนวนโค้ดที่ต้องเขียนเอง
@Document("rooms")
public class Room {
    @Id
    private String roomId;
    private String name;
    private List<String> member; // เก็บรายชื่อสมาชิก

    // Constructor ที่รับอาร์กิวเมนต์
    public Room(String roomId, String name, List<String> member) {
        this.roomId = roomId;
        this.name = name;
        this.member = member;
    }
}