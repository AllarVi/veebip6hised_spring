package main.groovy.application.dao;

import main.groovy.application.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by UserAccount on 1.06.2016.
 */
public interface UserTypeRepository extends JpaRepository<UserType,Long> {
}
