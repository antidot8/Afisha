package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieItem {
  private int id;
  private int productId;
  private String productName;
  private int productGenre; // подразумевается, что жанры прописаны отдельно нумерованным списком, поэтому тип переменной int
  private String imageUrl;
}