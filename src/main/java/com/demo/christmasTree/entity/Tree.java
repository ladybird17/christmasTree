package com.demo.christmasTree.entity;

import com.demo.christmasTree.dto.TreeReqDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * author : yjseo
 * date : 2022-12-14
 */
@Entity
@Table(name = "tree")
@Getter
@RequiredArgsConstructor
public class Tree {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String contents;

  private String passwd;

  private String name;

  @Column(name = "created_on")
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
  @CreationTimestamp
  private LocalDateTime createdON;

  public void dtoToEntity(TreeReqDto treeReqDto){
    this.contents = treeReqDto.getContents();
    this.passwd = treeReqDto.getPasswd();
    this.name = treeReqDto.getName();
  }

  public void updateEntity(TreeReqDto treeReqDto){
    if(treeReqDto.getContents()!=null){
      this.contents = treeReqDto.getContents();
    }
    if(treeReqDto.getName()!=null){
      this.name = treeReqDto.getName();
    }
  }
}
