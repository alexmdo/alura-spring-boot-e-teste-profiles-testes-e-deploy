package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class CursoRepositoryTest {

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void givenFindByNome_whenCourseExists_thenItShouldReturnAValidCourse() {
        String nomeCurso = "HTML 5";
        Curso curso = cursoRepository.findByNome(nomeCurso);

        assertNotNull(curso);
        assertEquals(nomeCurso, curso.getNome());
    }

    @Test
    void givenFindByNome_whenCourseDoesNotExists_thenItShouldNotReturnAValidCourse() {
        String nomeCurso = "JPA";
        Curso curso = cursoRepository.findByNome(nomeCurso);

        assertNull(curso);
    }
}