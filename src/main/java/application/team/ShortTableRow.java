package application.team;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by allarviinamae on 15/05/16.
 * <p>
 * Represents on row of short table.
 */
@Entity
public class ShortTableRow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Integer rank;

    private String userName;

    private String tier;

    private Integer points;

    public ShortTableRow(Integer rank, String userName, String tier, Integer points) {
        this.rank = rank;
        this.userName = userName;
        this.tier = tier;
        this.points = points;
    }

    public ShortTableRow() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
