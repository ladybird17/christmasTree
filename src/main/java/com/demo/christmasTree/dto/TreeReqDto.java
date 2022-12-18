package com.demo.christmasTree.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author : yjseo
 * date : 2022-12-14
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TreeReqDto {
  private Long id;

  private String contents;

  @NotNull(message = "비밀번호는 필수입니다!")
  private String passwd;

  private String name;
}
