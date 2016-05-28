package main.groovy.application.dao

import main.groovy.application.model.Coconut
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by allarviinamae on 18/05/16.
 *
 * JpaRepository abil saab teha kõiki tavapäraseid CRUD operatsioone ilma neid defineerimata.
 */
public interface CoconutRepository extends JpaRepository<Coconut, Integer> {
}