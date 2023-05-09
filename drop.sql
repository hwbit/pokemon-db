use cs3380;

drop table if exists Pokemon_Move;

create table Pokemon_Move (pokedex_number INTEGER, form_id INTEGER, m_name varchar(64) REFERENCES Move, FOREIGN KEY (pokedex_number, form_id) REFERENCES Pokemon, PRIMARY KEY(pokedex_number,form_id,m_name));