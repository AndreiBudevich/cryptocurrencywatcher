INSERT INTO users (name, registration_time)
VALUES ('Andrei Budevich', '2023-01-13'),
       ('Tatsiana Budevich', '2023-01-13');

INSERT INTO cryptocurrency (id, symbol)
VALUES (90, 'BTC'),
       (80, 'ETH'),
       (48543, 'SOL');

INSERT INTO user_cryptocurrency (user_id, price, prise_time, cryptocurrency_id)
VALUES (1, 26000.00, '2023-01-13', 90),
       (1, 1798.00, '2023-01-13', 80),
       (1, 20.97, '2023-01-13', 48543),
       (2, 25000.00, '2023-01-13', 90),
       (2, 1888.48, '2023-01-13', 80),
       (2, 22.22, '2023-01-13', 48543);
