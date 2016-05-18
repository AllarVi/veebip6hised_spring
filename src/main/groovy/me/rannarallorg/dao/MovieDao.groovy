package main.groovy.me.rannarallorg.dao

import main.groovy.me.rannarallorg.movie.Movie
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Repository
@Transactional
class MovieDao {

    @PersistenceContext
    private EntityManager entityManager;

    List getAll() {
        entityManager.createQuery("from Movie").resultList
    }

    Movie getById(int id) {
        entityManager.find(Movie .class, id)
    }

    void update(Movie movie) {
        entityManager.merge(movie)
    }
}
