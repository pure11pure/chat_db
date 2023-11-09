package com.example.chat_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping
    public List<Chat> getAllChats() {
        return chatService.getAllChats();
    }

    @PostMapping
    public ResponseEntity<?> addChat(@RequestBody Chat chat) {
        if (chat.getMsg() != null && !chat.getMsg().isEmpty()) {
            // สร้าง timestamp โดยอัตโนมัติที่เป็นปัจจุบัน
            chat.setTimestamp(new Date()); // หรือ LocalDateTime.now() ถ้าคุณใช้ Java 8 หรือใหม่กว่า

            Chat addedChat = chatService.addChat(chat); // เพิ่มข้อมูลแชทโดยใช้คำขอ POST
            return new ResponseEntity<>(addedChat, HttpStatus.OK);
        } else {
            // หาก msg เป็นค่าว่างหรือ null ให้ส่งคำตอบผิดพลาดและแจ้งเตือนผู้ใช้
            String responseMessage = "ข้อมูลไม่ถูกต้องหรือไม่ครบถ้วน";
            return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/room/{roomId}")
    public List<Chat> getChatsByRoom(@PathVariable String roomId) {
        return chatService.getChatsByRoom(roomId);
    }
}