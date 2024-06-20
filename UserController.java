package com.example.demo2.controller;

import com.example.demo2.model.ConfirmEmail;
import com.example.demo2.model.User;
import com.example.demo2.repository.ConfirmEmailRepos;
import com.example.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ConfirmEmailRepos conRepo;

    @PutMapping("{/id}")
    public ResponseEntity<User> remakeUser (@PathVariable int id,@RequestBody User userUpdate ) {
        try {
            User updatedUser = userService.updateUser(userUpdate);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<User>> getAll(){
      List<User> danhsach = userService.getAll();
      return new ResponseEntity<>(danhsach, HttpStatus.OK);
    }


    @GetMapping("id")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPass(@RequestParam String email){
        String confirmCode=UUID.randomUUID().toString();
        ConfirmEmail conEmail = new ConfirmEmail();
        conEmail.setConfirmCode(confirmCode);
        conEmail.setExpiryTime(LocalDateTime.now().plusMinutes(1));
        conEmail.setId(userService.getUserByEmail(email).get().getId());
        conEmail.setIsConfirm(false);
        conRepo.save(conEmail);
        return ResponseEntity.ok("Email xác nhận đã được gửi");
    }
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPass (@RequestParam String confirmCode,@RequestParam String newPassword){
        Optional<ConfirmEmail> confirmEmailOp = conRepo.findByConfirmCode(confirmCode);
        if (confirmEmailOp.isPresent()) {
            ConfirmEmail conEmail= confirmEmailOp.get();
            if(conEmail.getExpiryTime().isAfter(LocalDateTime.now())&&!conEmail.isIsConfirm()) {
                userService.resetPassword(conEmail.getUserId().getEmail(), newPassword);
                conEmail.setIsConfirm(true);
               conRepo.save(conEmail);
                return ResponseEntity.ok("Mật khẩu đã được đặt lại thành công");
            }
        }
        return ResponseEntity.badRequest().body("Mã xác nhận không hợp lệ hoặc đã hết hạn");
    }

}
