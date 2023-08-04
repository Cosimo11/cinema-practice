# Angular-Spring exam practice: Cinema

### Preparation

- Clone the repository to your computer
- Commit your changes frequently!
- Go through the whole description before starting it

### What are the rules?

- please work individually
- ChatGPT and Phind usages are not allowed
- Be careful when copy-pasting parts from previous projects
- Take your time to plan your software (domain objects, software layers, urls, components etc.)
- Always check the acceptance criteria before finishing a user story
- You can complete the user stories in any order you want

### Technical requirements

- Use a Maven project
- Use SpringBoot with JPA
- Use MySQL to store the data
- Use Bootstrap to make it cool looking, create a navigation bar
- Use Logback to log what is happening
- Use Angular for frontend

### Brief description

Create a ticket booking app that people can use to buy cinema tickets from the comfort of their homes. When they do so,
the application should keep track of all bookings, including the remaining seats for each film. Also, include the
functionality of adding new screenings so cinema managers will also be able to use the application.

### User stories:

### 0. Backlog item: Config (3 points)

- Create the database
- Import required css and js files for Bootstrap

#### 1. US: Create new screening (23 points)

As a cinema manager, I want to add new screenings that are stored in a persistent database (like Mysql),
so my customers can find them on my website.

Screening properties/fields:

- Movie title (String, mandatory)
- Screening date/time (LocalDateTime, mandatory)
- Total seats (Integer, mandatory)
- Picture URL (String, optional)

**Acceptance criteria:**

- There is a link on the navigation bar that navigates to the "New Screening" page (2p)
- The form has all necessary fields and a Save button (7p)
- If there is NO validation error, the screening data is stored in the database (use DTOs) (8p)
- The input is validated and validation errors are shown under the input fields (5p)
- Technical req.: "New screening added" is logged using Logback to the console (1p)

#### 2. US: Screening list (15 points)

As a user, I want to see all the screenings in a list sorted in ascending order by time.

Screening's fields to display in the list:

- Picture (use css to show a smaller, fixed size image - e.g. \_height: 70px;)
- Title
- Time of Screening
- Total Seats
- Free Seats

**Acceptance criteria:**

- There is a link on the navigation bar that navigates to the "Screenings" page (2p)
- Create a DTO for the screening list items (3p)
- The screenings are displayed with all fields (4p)
- They are ordered by time (3p)
- After adding a new screening, the user is redirected to the "Screenings" page (2p)
- Technical req.: "Screenings page requested" is logged using Logback to the console (1p)

**NOT list:**

- there is no "modify screening" or "delete screening" function

#### 3. US: New reservation (30 points)

As a user, I want to create new Reservations for movie screenings that are stored in a persistent database (like Mysql).

Reservation properties/fields:

- Name (of the person making the reservation - String, mandatory)
- Number of Seats (cannot be more than the available seats for the selected screening - Integer, mandatory)
- Movie screening, that is chosen from a _select_ list (Screening, mandatory)

**Acceptance criteria:**

- There is a link on the navigation bar that navigates to the "New Reservation" page (2p)
- The form is shown with all fields and a Save button (6p)
- The available movie screenings are displayed as options (in the select input field) (6p)
- If there is NO validation error, the expense data is stored in the database (use DTOs) (8p)
- The input is validated and validation errors are shown under the input fields (7p)
- Technical req.: When making a booking, "Ticket(s) reserved" is logged using Logback to the console (1p)

#### 4. US: Reservation list (12 points)

As a user, I want to see all the reservations in a list so I can see my recent bookings and check what other people
are going to watch.

Reservations' details to display in the list:

- Name
- Title
- Number of seats
- Time of screening (format: yyyy-MM-dd hh:mm)

**Acceptance criteria:**

- There is a link on the navigation bar that navigates to the "Resevations" page (2p)
- Create a DTO for the reservation list items (3p)
- The reservations are displayed with all fields (4p)
- The date is formatted (2p)
- Technical req.: "Reservations page requested" is logged using Logback to the console (1p)

**NOT list:**

- there is no "modify reservation" or "delete reservation" function

#### 5. US: Movie summary page (17 points)

As a user, I want to see the overview of the screenings, so I know which movies are the most popular.

| Movie Title | Number of Screenings | Tickets Sold |
| :---------: | :------------------: | :----------: |
|   Rocky 4   |          4           |      23      |
| Sharknado 7 |          9           |      4       |
|   Rambo 9   |          6           |      35      |
| Dead Alive  |          2           |      71      |

**Acceptance criteria:**

- There is a link on the navigation bar that navigates to the "Movie Summary" page (2p)
- A table or list is displayed (use DTOs) (6p)
- Correct values displayed for "Number of Screenings" (4p)
- Correct values displayed for "Tickets Sold" (4p)
- Technical req.: "Movie summary page requested" is logged using Logback to the console (1p)

## License

Copyright © Progmasters (QTC Kft.), 2016-2023.
All rights reserved. No part or the whole of this Teaching Material (TM) may be reproduced, copied, distributed, publicly performed, disseminated to the public, adapted or transmitted in any form or by any means, including photocopying, recording, or other electronic or mechanical methods, without the prior written permission of QTC Kft. This TM may only be used for the purposes of teaching exclusively by QTC Kft. and studying exclusively by QTC Kft.’s students and for no other purposes by any parties other than QTC Kft.
This TM shall be kept confidential and shall not be made public or made available or disclosed to any unauthorized person.
Any dispute or claim arising out of the breach of these provisions shall be governed by and construed in accordance with the laws of Hungary.
