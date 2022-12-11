package com.group.libraryapp.domain.user;

import com.group.libraryapp.calculator.domain.book.Book;
import com.group.libraryapp.calculator.domain.user.loanhistory.UserLoanHistory;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class JavaUser {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = true)
  private Integer age;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private final List<UserLoanHistory> userLoanHistories = new ArrayList<>();


  public JavaUser(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public JavaUser(Long id, String name, Integer age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public JavaUser() {
  }

  public JavaUser(String name, Integer age) {
    if (name.isBlank()) {
      throw new IllegalArgumentException("이름은 비어 있을 수 없습니다");
    }
    this.name = name;
    this.age = age;
  }

  public void updateName(String name) {
    this.name = name;
  }

  /**
   * id를 디폴트로 비워둘수가 없고 항상 null로 채워줘야한다.
   * @param book
   */
  public void loanBook(Book book) {
    //this.userLoanHistories.add(new UserLoanHistory(this, book.getName(), false,null));
  }

  public void returnBook(String bookName) {
    UserLoanHistory targetHistory = this.userLoanHistories.stream()
        .filter(history -> history.getBookName().equals(bookName))
        .findFirst()
        .orElseThrow();
    targetHistory.doReturn();
  }

  public String getName() {
    return name;
  }



  @Nullable
  public Integer getAge() {
    return age;
  }

  public Long getId() {
    return id;
  }

}
