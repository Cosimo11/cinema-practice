package pm.practice.cinema.dto.outgoing;

import lombok.Data;

@Data
public class MovieSummaryItem {

    private String movieTitle;
    private Integer numberOfScreenings;
    private Integer ticketsSold;

    public MovieSummaryItem(String movietitle, int numberOfScreenings, int ticketsold) {

        this.movieTitle = movietitle;
        this.numberOfScreenings = numberOfScreenings;
        this.ticketsSold = ticketsold;

    }
}
