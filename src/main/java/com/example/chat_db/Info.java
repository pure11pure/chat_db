package com.example.chat_db;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data // สร้างต่าง ๆ อัตโนมัติเช่น getter, setter, toString, hashCode, และ equals เพื่อลดจำนวนโค้ดที่ต้องเขียนเอง
@Document("Info")
public class Info {
    @Id
    private String infoId;
    private String name;
    private String img;

    // Constructor ที่รับอาร์กิวเมนต์
    public Info(String infoId, String name, String img) {
        this.infoId = infoId;
        this.name = name;
        this.img = img;
    }
}