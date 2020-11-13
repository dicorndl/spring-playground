package me.dicorndl.springplayground

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository,
    val articleRepository: ArticleRepository) {

  @Test
  internal fun `When findByIdOrNull then return Article`() {
    val dicorndl = User("dicorndl", "dico", "rndl")
    entityManager.persist(dicorndl)
    val article = Article("코틀린 츄라이", "츄라이 츄라이 코틀린 함 무라", "Lorem ipsum", dicorndl)
    entityManager.persist(article)
    entityManager.flush()
    val found = articleRepository.findByIdOrNull(article.id!!)
    assertThat(found).isEqualTo(article)
  }

  @Test
  internal fun `When findByLofin then return User`() {
    val dicorndl = User("dicorndl", "dico", "rndl")
    entityManager.persist(dicorndl)
    entityManager.flush()
    val user = userRepository.findByLogin(dicorndl.login)
    assertThat(user).isEqualTo(dicorndl)
  }
}