package com.example.demo2.controller;

import com.example.demo2.model.ConfirmEmail;
import com.example.demo2.model.User;
import com.example.demo2.repository.ConfirmEmailRepos;
import com.example.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ConfirmEmailRepos conRepo;

    //cap nhat
    @PutMapping(value="{/id}")
    public ResponseEntity<User> remakeUser (@PathVariable int id, @RequestBody User userUpdate ) {
        try {
            User updatedUser = userService.updateUser(userUpdate);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Lay thong tin nguoi dung theo id
    @GetMapping(value="/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping(value="/forgot-password")
    public ResponseEntity<String> forgotPass(@RequestParam String email){
        String confirmCode= UUID.randomUUID().toString();
        ConfirmEmail conEmail = new ConfirmEmail();
        conEmail.setConfirmCode(confirmCode);
        conEmail.setExpiryTime(LocalDate.from(LocalDateTime.now().plusMinutes(1)));
        conEmail.setId(userService.getUserByEmail(email).get().getId());
        conEmail.setIsConfirm(false);
        conRepo.save(conEmail);
        return ResponseEntity.ok("Email xác nhận đã được gửi");
    }
    @PostMapping(value="/reset-password")
    public ResponseEntity<String> resetPass (@RequestParam String confirmCode,@RequestParam String newPassword){
        Optional<ConfirmEmail>confirmEmailOp= conRepo.findByConfirmCode(confirmCode);
        if (confirmEmailOp.isPresent()) {
            ConfirmEmail conEmail=confirmEmailOp.get();
            if(conEmail.getExpiryTime().isAfter(ChronoLocalDate.from(LocalDateTime.now()))&&!conEmail.isIsConfirm()) {
                userService.resetPassword(conEmail.getUserId().getEmail(), newPassword);
                conEmail.setIsConfirm(true);
                conRepo.save(conEmail);
                return ResponseEntity.ok("Mật khẩu đã được đặt lại thành công");
            }
        }
        return ResponseEntity.badRequest().body("Mã xác nhận không hợp lệ hoặc đã hết hạn");
    }
}
