INSERT INTO volunteers(first_name, last_name, email_address, birthday, is_student, photo_url)
VALUES ('Omer',   'Yildirim', 'omer.yildirim@student.kdg.be', DATE '2005-06-24', TRUE,  'randomurl1'),
       ('Naz',    'Aksinir',  'naz.aksinir@student.kdg.be',   DATE '2007-11-23', TRUE,  'randomurl2'),
       ('Yigit',  'Yildirim', 'yigit.yildirim@gmail.com',     DATE '2009-01-24', TRUE,  'randomurl3'),
       ('John',   'Doe',      'johndoe@gmail.com',            DATE '1967-02-14', FALSE, 'randomurl4'),
       ('Jane',   'Doe',      'janedoe@gmail.com',            DATE '1969-06-04', FALSE, 'randomurl5'),
       ('Victor', 'Osimhen',  'victorosimhen@gmail.com',      DATE '1997-04-22', FALSE, 'randomurl6');

INSERT INTO organizations(name, founded_date, average_rating, is_verified, logo_url)
VALUES ('Live Nation',         DATE '2010-01-25', 3.9, TRUE,  'https://cdn.prod.website-files.com/69fcec01601a440674da336f/6a060e72c4e409d4794af40e_LN_Logo_Primary_Red-Black_web.webp'),
       ('Cirque du Soleil',    DATE '1984-01-25', 4.0, TRUE,  'https://upload.wikimedia.org/wikipedia/fr/1/1c/Logo_Cirque_du_Soleil.svg?utm_source=fr.wikipedia.org&utm_campaign=index&utm_content=original'),
       ('UNICEF',              DATE '1946-01-25', 4.5, TRUE,  'https://thumb.wikimedia.org/wikipedia/commons/thumb/3/36/Logo_of_UNICEF_%28cropped%29.svg/3840px-Logo_of_UNICEF_%28cropped%29.svg.png?utm_source=commons.wikimedia.org&utm_campaign=index&utm_content=thumbnail'),
       ('Feeding America',     DATE '1979-01-01', 2.3, TRUE,  'https://i0.wp.com/www.fsproduce.com/wp-content/uploads/2015/05/Feeding_America_logo.svg.png?ssl=1'),
       ('World Wildlife Fund', DATE '1961-04-29', 5.0, TRUE,  'https://thumb.wikimedia.org/wikipedia/de/thumb/0/06/WWF_Logo.svg/1920px-WWF_Logo.svg.png?utm_source=de.wikipedia.org&utm_campaign=index&utm_content=thumbnail'),
       ('KDG',                 DATE '1999-09-09', 1.2, FALSE, 'https://upload.wikimedia.org/wikipedia/commons/5/5b/Logo_Karel_de_Grote_Hogeschool.png?utm_source=commons.wikimedia.org&utm_campaign=index&utm_content=original');

INSERT INTO events(title, event_date, category, location, status, banner_url, max_volunteers, organization_id)
VALUES ('J. Cole: The Fall Off',                    DATE '2026-10-17', 'CONCERT',           'Antwerp',   'PLANNED',   'jcole.svg.url',          10, 1),
       ('Coldplay: Music of the Spheres',           DATE '2026-07-22', 'CONCERT',           'Brussels',  'PLANNED',   'coldplay.svg.url',       15, 1),
       ('Cirque du Soleil: KOOZA',                  DATE '2026-05-09', 'CONCERT',           'Kooza',     'PLANNED',   'kooza.svg.url',          12, 2),
       ('Cirque du Soleil: Alegria',                DATE '2026-03-14', 'CONCERT',           'Brussels',  'COMPLETED', 'alegria.svg.url',         8, 2),
       ('UNICEF Vaccination Drive - Lagos',         DATE '2026-04-03', 'HEALTHCARE',        'Lagos',     'ONGOING',   'unicefvax.svg.url',      25, 3),
       ('UNICEF School Supplies Program',           DATE '2026-09-01', 'EDUCATION',         'Tanger',    'PLANNED',   'unicefedu.svg.url',      20, 3),
       ('Feeding America Food Bank Drive',          DATE '2026-01-20', 'FOOD_DISTRIBUTION', 'Houston',   'ONGOING',   'feedingamerica.svg.url', 30, 4),
       ('WWF Coastal Cleanup - Great Barrier Reef', DATE '2026-06-08', 'CLEANUP',           'Cape Town', 'PLANNED',   'wwfcleanup.svg.url',     35, 5),
       ('KDG Student quiz',                         DATE '2026-12-02', 'EDUCATION',         'Antwerp',   'PLANNED',   'randomkdgphoto.svg.url',  5, 6);