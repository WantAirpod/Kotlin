package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional


@SpringBootTest
//@Transactional
class UserServiceTest @Autowired constructor(
    private val userRepository: UserRepository
    ,private val userService: UserService
) {

    @AfterEach
    fun clean(){
        userRepository.deleteAll()
    }

    @Test
    fun saveUserTest(){
        // given
        val request  = UserCreateRequest("최진영",23);
        // when
        userService.saveUser(request)
        // then
        val result = userRepository.findAll()
        assertThat(result).hasSize(1)
        assertThat(result[0].name).isEqualTo("최진영")
        assertThat(result[0].age).isEqualTo(23)
    }

    @Test
    fun getUserTest(){
        //given
        userRepository.saveAll(listOf(
            User("A",20),
            User("B",30),
        ))

        // when
        var result = userService.getUsers()

        // then
        assertThat(result).hasSize(2)
        assertThat(result).extracting("name").containsExactlyInAnyOrder("A","B") //["A","B"]
        assertThat(result).extracting("age").containsExactlyInAnyOrder(20,30) //["A","B"]
    }
    @Test
    @DisplayName("유저 업데이트가 정상동작 테스트")
    fun updateUserNameTest(){
        //given
        val savedUser = userRepository.save(User("A",20))
        val request = UserUpdateRequest(savedUser.id,"B")


        //when
        userService.updateUserName(request)

        //then
        val result = userRepository.findAll()[0]
        assertThat(result.name).isEqualTo("B")


    }

    @Test
    @DisplayName("유저 삭제가 정상작동하는지 테스트")
    fun deleteUserTest(){
        userRepository.save(User("A",23))

        //when
        userService.deleteUser("A")

        //then
        assertThat(userRepository.findAll()).isEmpty()
    }

}