package application.team;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

/**
 * Created by allarviinamae on 15/05/16.
 *
 * Represents data to be displayed.
 */
@Entity
public class ShortTeamView extends Team {

    @ElementCollection
//    @CollectionTable(name="<name_of_join_table>")
//    @MapKeyColumn(name="user_name")
    private List<ShortTableRow> shortTableRowMap;

    public ShortTeamView() {
    }


    public List<ShortTableRow> getShortTableRowMap() {
        return shortTableRowMap;
    }

    public void setShortTableRowMap(List<ShortTableRow> shortTableRowMap) {
        this.shortTableRowMap = shortTableRowMap;
    }
}
