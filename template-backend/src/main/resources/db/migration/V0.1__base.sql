create table templates
(
  id      BIGSERIAL NOT NULL PRIMARY KEY,
  name    TEXT      not null unique,
  payload TEXT      NOT NULL
);

INSERT INTO templates (id, name, payload)
VALUES (1, 'template1', 'template2');
