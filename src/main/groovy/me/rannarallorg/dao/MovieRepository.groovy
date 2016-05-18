package main.groovy.me.rannarallorg.dao

import main.groovy.me.rannarallorg.movie.Movie
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by allarviinamae on 18/05/16.
 *
 * Do CRUD operations like a boss.
 */
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}