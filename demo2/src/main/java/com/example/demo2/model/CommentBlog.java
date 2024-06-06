package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Commentblog")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentBlog {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int Id;

   @ManyToOne
   @JoinColumn(name = "blogId")
   private Blog BlogId;

   @ManyToOne
   @JoinColumn(name = "userId")
   private User UserId;

   private int Contebt;
   private Boolean Edited;
}
